package com.accenture.adf.businesstier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.exceptions.FERSGenericException;
import com.accenture.adf.helper.FERSDataConnection;
import com.accenture.adf.helper.FERSDbQuery;

/**
 * 
 * <br/>
 * CLASS DESCRIPTION:<br/>
 * A Data Access Object (DAO) class for handling and managing visitor related
 * data requested, used, and processed in the application and maintained in the
 * database. The interface between the application and visitor data persisting
 * in the database.
 * 
 */

public class VisitorDAO {

	// LOGGER for handling all transaction messages in VISITORDAO
	private static Logger log = Logger.getLogger(VisitorDAO.class);

	// JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private FERSDbQuery query;

	// Default constructor for injecting Spring dependencies for SQL queries
	public VisitorDAO() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		query = (FERSDbQuery) context.getBean("SqlBean");
	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION:<br/>
	 * DAO method to loading visitor details into VISITOR table in database<br/>
	 * and validating about existing visitor details before inserting a visitor <br/>
	 * 
	 * <br/>
	 * PSEUDOCODE: <br/>
	 * Create a connection to database<br/>
	 * Prepare a statement object using the connection that uses a query that
	 * inserts visitor information <br/>
	 * into the visitor table <br/>
	 * Execute a statement object selects all the usernames from the visitor
	 * table<br/>
	 * if the username is not in the visitor table <br/>
	 * 
	 * @param visitor
	 *            (type Visitor)
	 * 
	 * @return boolean
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 * 
	 */
	public boolean insertData(Visitor visitor) throws ClassNotFoundException,
			SQLException, Exception {

		connection = FERSDataConnection.createConnection();

		PreparedStatement query1 = connection.prepareStatement(query
				.getValidateVisitor());
		PreparedStatement query2 = connection.prepareStatement(query
				.getInsertQuery());

		log.info("Query1: Searching current visitors");

		resultSet = query1.executeQuery();
		boolean isDuplicate = false;
		while (resultSet.next()) {
			if (visitor.getUserName().equals(resultSet.getString(1))) {
				isDuplicate = true;
			}
		}
		if (isDuplicate) {
			log.info("Username is already in database!");
		} else {
			query2.setString(1, visitor.getUserName());
			query2.setString(2, visitor.getPassword());
			query2.setString(3, visitor.getFirstName());
			query2.setString(4, visitor.getLastName());
			query2.setString(5, visitor.getEmail());
			query2.setString(6, visitor.getPhoneNumber());
			query2.setString(7, visitor.getAddress());

			log.info("Query2: Adding new visitor");

			int changedRows = query2.executeUpdate();
			if (changedRows <= 0) {
				throw new FERSGenericException("Visitor "
						+ visitor.getUserName()
						+ " details not inserted into database",
						new Exception());
			}

			log.info("Details for visitor " + visitor.getUserName()
					+ " were successfully added");
			resultSet.close();
			FERSDataConnection.closeConnection();
			return true;
		}
		resultSet.close();
		FERSDataConnection.closeConnection();
		return false;
	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION:<br/>
	 * DAO method for searching for visitor details using USERNAME and PASSWORD<br/>
	 * 
	 * <br/>
	 * PSEUDOCODE: <br/>
	 * Create a connection to database<br/>
	 * Prepare a statement object using the connection<br/>
	 * that uses a query that retrieves all the data from the visitor table
	 * based on the username and password provided. Execute the query and <br/>
	 * Using a WHILE LOOP, store the results in the result set record in the
	 * visitor object.<br/>
	 * 
	 * @param username
	 *            (type String)
	 * @param password
	 *            (type String)
	 * 
	 * @return Visitor
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
	public Visitor searchUser(String username, String password)
			throws ClassNotFoundException, SQLException {

		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getSearchQuery());
		statement.setString(1, username);
		statement.setString(2, password);

		log.info("Executing Search Query for " + username);

		Visitor visitor = new Visitor();
		resultSet = statement.executeQuery();
		int numVis = 0;
		while (resultSet.next()) {
			numVis++;
			visitor.setVisitorId(resultSet.getInt(1));
			visitor.setUserName(resultSet.getString(2));
			visitor.setPassword(resultSet.getString(3));
			visitor.setFirstName(resultSet.getString(4));
			visitor.setLastName(resultSet.getString(5));
			visitor.setEmail(resultSet.getString(6));
			visitor.setPhoneNumber(resultSet.getString(7));
			visitor.setAddress(resultSet.getString(8));
		}
		log.info(numVis + " records received while searching for " + username);
		resultSet.close();
		FERSDataConnection.closeConnection();
		return visitor;
	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION: <br/>
	 * DAO method to register visitor to specific event and checking about
	 * status of visitor to particular event. <br/>
	 * 
	 * PSEUDO-CODE: <br/>
	 * Create a connection to the database <br/>
	 * Prepare a statement object using the connection: that inserts the visitor
	 * and event IDs into the EVENTSIGNUP table <br/>
	 * Execute the query to perform the update <br/>
	 * 
	 * 
	 * @param visitor
	 * @param eventid
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 * 
	 */
	public void registerVisitorToEvent(Visitor visitor, int eventid)
			throws ClassNotFoundException, SQLException, Exception {

		connection = FERSDataConnection.createConnection();

		log.info("Registered event " + eventid + " to " + visitor.getUserName());

		statement = connection.prepareStatement(query.getRegisterQuery());
		statement.setInt(1, eventid);
		statement.setInt(2, visitor.getVisitorId());
		log.info("Executing event registation for " + visitor.getUserName()
				+ " to event " + eventid);

		int success = statement.executeUpdate();
		if (success <= 0) {
			throw new FERSGenericException(visitor.getUserName()
					+ " was not registered to event " + eventid,
					new Exception());
		}
		FERSDataConnection.closeConnection();
	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION:<br/>
	 * DAO method to display all the events registered by particular visitor<br/>
	 * 
	 * PSEUDO-CODE: <br/>
	 * Create a connection to the database <br/>
	 * Prepare a statement object using the connection: that returns the event
	 * information for all the events that are registered to a visitor<br/>
	 * Execute the query to retrieve the results into a result set<br/>
	 * Place each event record‘s information in an event list. <br/>
	 * 
	 * @param visitor
	 *            (type Visitor)
	 * 
	 * @return Collection of Event Arrays (type Event)
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
	public ArrayList<Event> registeredEvents(Visitor visitor)
			throws ClassNotFoundException, SQLException {

		connection = FERSDataConnection.createConnection();

		statement = connection.prepareStatement(query.getStatusQuery());

		statement.setInt(1, visitor.getVisitorId());

		log.info("Searching for all events for visitor "
				+ visitor.getUserName());

		resultSet = statement.executeQuery();

		ArrayList<Event> events = new ArrayList<Event>();
		while (resultSet.next()) {
			Event e = new Event();
			e.setEventid(resultSet.getInt(1));
			e.setName(resultSet.getString(2));
			e.setDescription(resultSet.getString(3));
			e.setPlace(resultSet.getString(4));
			e.setDuration(resultSet.getString(5));
			e.setEventtype(resultSet.getString(6));
			e.setSignupid(resultSet.getInt(7));
			events.add(e);
		}
		log.info("Retrieved " + events.size() + " events for "
				+ visitor.getUserName());
		resultSet.close();
		FERSDataConnection.closeConnection();
		return events;
	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION:<br/>
	 * DAO method to update visitor with additional information <br/>
	 * <br/>
	 * 
	 * @param visitor
	 *            (type Visitor)
	 * 
	 * @return int
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 * 
	 */
	public int updateVisitor(Visitor visitor) throws ClassNotFoundException,
			SQLException {

		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getUpdateQuery());
		statement.setString(1, visitor.getFirstName());
		statement.setString(2, visitor.getLastName());
		statement.setString(3, visitor.getUserName());
		statement.setString(4, visitor.getEmail());
		statement.setString(5, visitor.getPhoneNumber());
		statement.setString(6, visitor.getAddress());
		statement.setInt(7, visitor.getVisitorId());

		int status = statement.executeUpdate();
		log.info("Updating visitor details in Database for Visitor ID :"
				+ visitor.getVisitorId());
		FERSDataConnection.closeConnection();
		return status;
	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION: <br/>
	 * DAO method to unregister from events <br/>
	 * 
	 * 
	 * @param visitor
	 *            (type Visitor)
	 * @param eventid
	 *            (type int)
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 * 
	 */
	public void unregisterEvent(Visitor visitor, int eventid)
			throws ClassNotFoundException, SQLException, Exception {

		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getDeleteEventQuery());
		statement.setInt(1, eventid);
		statement.setInt(2, visitor.getVisitorId());
		int status = statement.executeUpdate();
		if (status <= 0)
			throw new FERSGenericException("Records not updated properly",
					new Exception());
		log.info("unregistering event in Database for the visitor :"
				+ visitor.getFirstName());
		FERSDataConnection.closeConnection();
	}

	/**
	 */
	public int changePassword(Visitor visitor) throws ClassNotFoundException, SQLException {	
		
		int status = -1;
		try {
			connection = FERSDataConnection.createConnection();
			if(connection != null){
				
				if (visitor != null) {
					
					if(matchWithOldPwd(visitor)){
						status = -10;
					}
					else{
						status = 1;
						statement = connection.prepareStatement(query.getChangePWDQuery());
						statement.setString(1, visitor.getPassword());
						statement.setInt(2, visitor.getVisitorId());
						statement.executeUpdate();
						log.info("Visitor " + visitor.getVisitorId() + " password successfully modified");
					}
				}
				else {
					log.info("Visitor details are invalid");
				}
			}
			else{
				System.out.println("Got here");
				throw new SQLException("Connection Error, could not establish connection with database");
			}
		}
		finally {
			connection.close();
		}
		return status;
	}

	private boolean matchWithOldPwd(Visitor visitor) throws SQLException{
			String currentPWD = "";
			try{
				statement = connection.prepareStatement(query.getVerifyPWDQuery());
				statement.setInt(1, visitor.getVisitorId());
				resultSet = statement.executeQuery();
				resultSet.next();
				currentPWD = resultSet.getString(1);
				if(currentPWD.equalsIgnoreCase(visitor.getPassword())){
					log.info("New password must be different from previous password, please choose a different password");
					return true;
				}
			}
			finally {
				statement.close();
			}
			return false;
		}
}