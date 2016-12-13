package com.accenture.adf.businesstier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

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
 * A Data Access Object (DAO) class for handling and managing visitor related data requested, 
 * used, and processed in the application and maintained in the database.  
 * The interface between the application and visitor data persisting in the database.
 * 
 */
 
public class VisitorDAO {

	// LOGGER for handling all transaction messages in VISITORDAO
	private static Logger log = Logger.getLogger(VisitorDAO.class);

	//JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private FERSDbQuery query;

	//Default constructor for injecting Spring dependencies for SQL queries
	public VisitorDAO() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		query = (FERSDbQuery) context.getBean("SqlBean");
	}

	/**
	 * <br/>
	 *  METHOD DESCRIPTION:<br/>
	 *	DAO method to loading visitor details into VISITOR table in database<br/>
	 * and validating about existing visitor details before inserting a visitor <br/>
	 *  
	 *  <br/>
	 *  PSEUDOCODE: <br/>
	 *  Create a connection to database<br/>
	 *  Prepare a statement object using the connection that uses a query that inserts visitor information <br/>
	 *  into the visitor table <br/>
	 *  Execute a statement object selects all the usernames from the visitor table<br/>
	 *  if the username is not in the visitor table <br/>
	 * 
	 * 	@param visitor (type Visitor)
	 * 
	 * 	@return boolean
	 * 
	 * 	@throws ClassNotFoundException
	 * 	@throws SQLException
	 *	@throws Exception
	 *	  
	 */
	
	public boolean insertData(Visitor visitor) throws ClassNotFoundException,
			SQLException, Exception {
		boolean result;
		connection = FERSDataConnection.createConnection();
		PreparedStatement statement_names=connection.prepareStatement("Select username from visitor");
		log.info("Query 1 is about to be executed");
		ResultSet usernames=statement_names.executeQuery();
		boolean check=false;
		
		while(usernames.next()){
			String name1=usernames.getString(1);
			String name2=visitor.getUserName();
			if(name1.equals(name2)){
				check=true;
				break;
				
			}
		}
		if(check){
			log.info("Username is already being used in the database");
			result=false;
		}
		else{
			statement=connection.prepareStatement(query.getInsertQuery());
			statement.setString(1,visitor.getUserName());
			statement.setString(2,visitor.getPassword());
			statement.setString(3,visitor.getFirstName());
			statement.setString(4,visitor.getLastName());
			statement.setString(5,visitor.getEmail());
			statement.setString(6,visitor.getPhoneNumber());
			statement.setString(7,visitor.getAddress());
			log.info("Query 2 is about to be executed");
			int value=statement.executeUpdate();
			if(value<=0){
				throw new FERSGenericException("Visitor "+visitor.getUserName()+" details not inserted into database",
						new Exception());
			}
			log.info("Visitor Details were added");
			result=true;
		
		}
		usernames.close();
		connection.close();
		return result;
	}

	/**
	 *  <br/>
	 *  METHOD DESCRIPTION:<br/>
	 *  DAO method for searching for visitor details using USERNAME and PASSWORD<br/>
	 * 
	 * 	<br/>
	 *  PSEUDOCODE: <br/>
	 *  Create a connection to database<br/>
	 *  Prepare a statement object using the connection<br/>
	 *  that uses a query that retrieves all the data from the visitor 
	 *  table based on the username and password provided. Execute the query and <br/>
	 *  Using a WHILE LOOP, store the results in the result set record in the visitor object.<br/>
	 *  
	 * 	@param username (type String)
	 * 	@param password (type String)
	 * 
	 * 	@return Visitor
	 * 
	 * 	@throws ClassNotFoundException
	 * 	@throws SQLException
	 * 
	 * 
	 */
	public Visitor searchUser(String username, String password)
			throws ClassNotFoundException, SQLException {
		
		Visitor visitor = new Visitor();
		connection = FERSDataConnection.createConnection();
		statement=connection.prepareStatement(query.getSearchQuery());
		statement.setString(1, username);
		statement.setString(2, password);
		log.info("Query is about to be executed");
		resultSet=statement.executeQuery();
		log.info("Visitor details were searched using the username and the number of records that were retrieved");
		while(resultSet.next()){
			visitor.setAddress(resultSet.getString("address"));
			visitor.setEmail(resultSet.getString("email"));
			visitor.setPassword(resultSet.getString("password"));
			visitor.setUserName(resultSet.getString("username"));
			visitor.setFirstName(resultSet.getString("firstname"));
			visitor.setLastName(resultSet.getString("lastname"));
			visitor.setPhoneNumber(resultSet.getString("phonenumber"));
			visitor.setVisitorId(resultSet.getInt("visitorid"));
		}
		resultSet.close();
		connection.close();
		return visitor;
	}

	/**
	 *  <br/>
	 *  METHOD DESCRIPTION: <br/>
	 *  DAO method to register visitor to specific event and checking about status
	 *  of visitor to particular event. <br/>
	 *  
	 *  PSEUDO-CODE: <br/>
	 *  Create a connection to the database <br/>
	 *  Prepare a statement object using the connection: that inserts the   
	 *     visitor and event IDs into the EVENTSESSIONSIGNUP table <br/>
	 *  Execute the query to perform the update <br/>
	 *  
	 * 
	 *  @param visitor
	 *  @param eventid
	 *   
	 *  @throws ClassNotFoundException
	 *  @throws SQLException
	 *  @throws Exception
	 *  
	 */

	public void registerVisitorToEvent(Visitor visitor, int eventid)
			throws ClassNotFoundException, SQLException, Exception {
		connection=FERSDataConnection.createConnection();
		log.info("The Visitor: "+visitor+" The EventID: "+eventid);
		statement=connection.prepareStatement(query.getRegisterQuery());
		statement.setInt(1, eventid);
		statement.setInt(2,visitor.getVisitorId());
		log.info("Query is about to be executed");
		int result=statement.executeUpdate();
		if(result<=0){
			throw new FERSGenericException("Visitor "+visitor.getUserName()+" not registered with EventID: "+eventid,
					new Exception());
		}
		connection.close();
		
		
	}

	/**
	 *  <br/>
	 *  METHOD DESCRIPTION:<br/>
	 *  DAO method to display all the events registered by particular visitor<br/>
	 *  
	 *  PSEUDO-CODE: <br/>
	 *  Create a connection to the database <br/>
	 *  Prepare a statement object using the connection: that returns the event   
	 *     information for all the events that are registered to a visitor<br/>
	 *  Execute the query to retrieve the results into a result set<br/>
	 *  Place each event record‘s information in an event list. <br/>
	 *  
	 *	@param  visitor (type Visitor)
	 *  
	 *  @return Collection of Event Arrays (type Event)
	 *  
	 *  @throws ClassNotFoundException
	 *  @throws SQLException
	 *  
	 */
	public ArrayList<Event> registeredEvents(Visitor visitor)
			throws ClassNotFoundException, SQLException {
		ArrayList<Event> registered=new ArrayList<Event>();
		connection=FERSDataConnection.createConnection();
		statement=connection.prepareStatement(query.getStatusQuery());
		statement.setInt(1,visitor.getVisitorId());
		log.info("Query is about to be executed");
		resultSet=statement.executeQuery();
		int amount=0;
		while(resultSet.next()){
			Event eventadd=new Event();
			eventadd.setEventid(resultSet.getInt(1));
			eventadd.setName(resultSet.getString(2));
			eventadd.setDescription(resultSet.getString(3));
			eventadd.setPlace(resultSet.getString(4));
			eventadd.setDuration(resultSet.getString(5));
			eventadd.setEventtype(resultSet.getString(6));
			eventadd.setSignupid(resultSet.getInt(7));
			registered.add(eventadd);
			amount++;
		}
		log.info("Number of events added is: "+amount);
	
		resultSet.close();
		connection.close();
		
		return registered; 
	}

	/**
	 * <br/>
	 *  METHOD DESCRIPTION:<br/>
	 *	 DAO method to update visitor with additional information <br/>
	 *  <br/>
	 *  
	 *  @param visitor (type Visitor)
	 * 
	 * 	@return int
	 * 
	 * 	@throws ClassNotFoundException
	 * 	@throws SQLException
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
	 *  <br/>
	 *  METHOD DESCRIPTION: <br/>
	 *  DAO method to unregister from events <br/>
	 *  
	 *     
	 *  @param  visitor (type Visitor)
	 *  @param  eventid (type int)
	 *    
	 *  @throws ClassNotFoundException
	 *  @throws SQLException
	 *  @throws Exception
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
		
		public int changePassword(Visitor visitor) throws ClassNotFoundException, SQLException {	
			int status=-1;
			try{
				connection = FERSDataConnection.createConnection();
				
				if(connection != null){
					if(visitor!=null){
						log.info("Visitor is not null");
				
							if(matchWithOldPwd(visitor)){
								status = -10;
							}
							else{
								statement=connection.prepareStatement(query.getChangePWDQuery());
								statement.setString(1,visitor.getPassword());
								statement.setInt(2,visitor.getVisitorId());
								status=statement.executeUpdate();
								log.info("Visitor password successfully modified for VisitorID: "+visitor.getVisitorId());
							}
							
				  } 
					else {
						log.info("Visitor details are invalid");
					}
				}
				else{ 
						throw new SQLException("Connection Error, could not establish connection with database");
				}
			}
			
				finally{
					connection.close();
				}
			return status;
			}

		
			private boolean matchWithOldPwd(Visitor visitor) throws SQLException{
				String currentPWD = "";
				try{
					statement=connection.prepareStatement(query.getVerifyPWDQuery());
					statement.setInt(1, visitor.getVisitorId());
					resultSet=statement.executeQuery();
					
					
					while(resultSet.next()){
						currentPWD=resultSet.getString(1);
					}
					if(currentPWD.equalsIgnoreCase(visitor.getPassword())){
			log.info("New password must be different from previous password, please choose a different password");
						
			return true;
					}
				}
				finally{
					statement.clearParameters();
				}
				return false;
				
			}

			

}