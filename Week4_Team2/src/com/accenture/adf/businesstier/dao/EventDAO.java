package com.accenture.adf.businesstier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.EventCoordinator;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.exceptions.FERSGenericException;
import com.accenture.adf.helper.FERSDataConnection;
import com.accenture.adf.helper.FERSDbQuery;

/**
 * <br/>
 * CLASS DESCRIPTION: <br/>
 * A Data Access Object (DAO) class for handling and managing event related data
 * requested, updated, and processed in the application and maintained in the
 * database. The interface between the application and event data persisting in
 * the database. <br/>
 * 
 * @author krishna.kishore
 * 
 */
public class EventDAO {

	// LOGGER for handling all transaction messages in EVENTDAO
	private static Logger log = Logger.getLogger(EventDAO.class);

	// JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private FERSDbQuery query;

	// Default constructor for injecting Spring dependencies for SQL queries
	public EventDAO() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		query = (FERSDbQuery) context.getBean("SqlBean");
	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION: <br/>
	 * DAO for displaying all the Events in the Event Table in the Database <br/>
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that gets all the events
	 * from the event table. <br/>
	 * Execute the SQL statement and keep a reference to the result set.<br/>
	 * Using a WHILE LOOP, store each record in the result set returned in an
	 * Event object by setting the values of the Event attributes as the
	 * corresponding values in the Result set.<br/>
	 * Return the ArrayList to the calling method. <br/>
	 * 
	 * @return Collection of Events
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
	public ArrayList<Object[]> showAllEvents() throws ClassNotFoundException,
			SQLException {
		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getSearchEvent());
		resultSet = statement.executeQuery();
		ArrayList<Object[]> eventList = new ArrayList<Object[]>();
		log.info("All Events retreived from Database :" + eventList);
		while (resultSet.next()) {
			Object[] eventObject = new Object[8];
			eventObject[0] = resultSet.getInt("eventid");
			eventObject[1] = resultSet.getString("name");
			eventObject[2] = resultSet.getString("description");
			eventObject[3] = resultSet.getString("duration");
			eventObject[4] = resultSet.getString("eventtype");
			eventObject[5] = resultSet.getString("places");
			eventObject[6] = resultSet.getInt("seatsavailable");
			eventObject[7] = resultSet.getInt("eventsessionid");
			eventList.add(eventObject);
		}
		resultSet.close();
		FERSDataConnection.closeConnection();
		return eventList;
	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION:<br/>
	 * DAO for updating events after the visitor registers for an event <br/>
	 * 
	 * @return void
	 * 
	 * @param eventid
	 * @param sessionid
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 * 
	 */

	public void updateEventNominations(int eventid, int sessionid)
			throws ClassNotFoundException, SQLException, Exception {
		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getUpdateEvent());
		statement.setInt(1, sessionid);
		statement.setInt(2, eventid);
		int status = statement.executeUpdate();
		if (status <= 0)
			throw new FERSGenericException("Records not updated properly",
					new Exception());
		log.info("Event registration status was updated in Database and Seat allocated");
		FERSDataConnection.closeConnection();

	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION:<br/>
	 * DAO for checking visitor has already registered for EVENT or not. Sends
	 * boolean values about status.<br/>
	 * 
	 * @return boolean
	 * 
	 * @param visitor
	 * @param eventid
	 * @param sessionid
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
	public boolean checkEventsofVisitor(Visitor visitor, int eventid,
			int sessionid) throws ClassNotFoundException, SQLException {
		connection = FERSDataConnection.createConnection();
		log.info("Status obtained for Visitor :" + visitor.getFirstName()
				+ " to event with ID :" + eventid);
		statement = connection.prepareStatement(query.getCheckEvent());
		statement.setInt(1, sessionid);
		statement.setInt(2, visitor.getVisitorId());
		statement.setInt(3, eventid);
		resultSet = statement.executeQuery();
		int status = 0;
		while (resultSet.next()) {
			status = resultSet.getInt("EVENTCOUNT");
		}
		resultSet.close();
		log.info("No of times visitor registered for Event :" + status);
		FERSDataConnection.closeConnection();
		if (status >= 1)
			return true;
		else
			return false;
	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION: <br/>
	 * DAO for update event database after unregistering event by visitor <br/>
	 * 
	 * @return void
	 * 
	 * @param eventid
	 * @param eventsessionid
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 * 
	 */

	public void updateEventDeletions(int eventid, int eventsessionid)
			throws ClassNotFoundException, SQLException, Exception {
		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getUpdateDeleteEvent());
		statement.setInt(1, eventsessionid);
		statement.setInt(2, eventid);
		int status = statement.executeUpdate();
		if (status <= 0)
			throw new FERSGenericException("Records not updated properly",
					new Exception());
		log.info("Event registration status was updated in Database and Seat released");
		FERSDataConnection.closeConnection();

	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION: <br/>
	 * DAO for displaying all the Events in the Event Table in the Database with
	 * names that contain the text entered by the user. <br/>
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that gets all the events
	 * from the event table. <br/>
	 * Execute the SQL statement and keep a reference to the result set. <br/>
	 * Using a WHILE LOOP, store each record in the result set returned in an
	 * Event object by setting the values of the Event attributes as the
	 * corresponding values in the Result set. <br/>
	 * Return the ArrayList to the calling method. <br/>
	 * 
	 * @param eventname
	 * 
	 * @return Collection of Events
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */

	public ArrayList<Object[]> showAllEvents(String eventname)
			throws ClassNotFoundException, SQLException {

		ArrayList<Object[]> eventList = new ArrayList<Object[]>();

		log.info("All Events retreived from Database :" + eventList);
		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getSearchByEventName());
		statement.setString(1, "%"+eventname+"%");

		resultSet = statement.executeQuery();

		log.info("All Events retreived from Database: " + eventList
				+ " /r with Event Query of " + eventname);
		while (resultSet.next()) {
			Object[] eventObject = new Object[8];
			eventObject[0] = resultSet.getInt("eventid");
			eventObject[1] = resultSet.getString("name");
			eventObject[2] = resultSet.getString("description");
			eventObject[3] = resultSet.getString("duration");
			eventObject[4] = resultSet.getString("eventtype");
			eventObject[5] = resultSet.getString("places");
			eventObject[6] = resultSet.getInt("seatsavailable");
			eventObject[7] = resultSet.getInt("eventsessionid");
			eventList.add(eventObject);
		}
		resultSet.close();
		FERSDataConnection.closeConnection();
		return eventList;

	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION: <br/>
	 * DAO for displaying all the Events in the Event Table in the Database in
	 * ascending order. <br/>
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that gets all the events
	 * from the event table in ascending order. <br/>
	 * Execute the SQL statement and keep a reference to the result set. <br/>
	 * Using a WHILE LOOP, store each record in the result set returned in an
	 * Event object by setting the values of the Event attributes as the
	 * corresponding values in the Result set. <br/>
	 * Return the ArrayList to the calling method. <br/>
	 * 
	 * 
	 * @return Collection of Events
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */

	public ArrayList<Object[]> showAllEventsAsc()
			throws ClassNotFoundException, SQLException {

		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getSearchEventAsc());
		resultSet = statement.executeQuery();
		ArrayList<Object[]> eventList = new ArrayList<Object[]>();
		log.info("All Events retreived from Database :" + eventList);
		while (resultSet.next()) {
			Object[] eventObject = new Object[8];
			eventObject[0] = resultSet.getInt("eventid");
			eventObject[1] = resultSet.getString("name");
			eventObject[2] = resultSet.getString("description");
			eventObject[3] = resultSet.getString("duration");
			eventObject[4] = resultSet.getString("eventtype");
			eventObject[5] = resultSet.getString("places");
			eventObject[6] = resultSet.getInt("seatsavailable");
			eventObject[7] = resultSet.getInt("eventsessionid");
			eventList.add(eventObject);
		}
		resultSet.close();
		FERSDataConnection.closeConnection();
		return eventList;

	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION: <br/>
	 * DAO for displaying all the Events in the Event Table in the Database in
	 * descending order. <br/>
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that gets all the events
	 * from the event table in descending order. <br/>
	 * Execute the SQL statement and keep a reference to the result set. <br/>
	 * Using a WHILE LOOP, store each record in the result set returned in an
	 * Event object by setting the values of the Event attributes as the
	 * corresponding values in the Result set. <br/>
	 * Return the ArrayList to the calling method. <br/>
	 * 
	 * 
	 * @return Collection of Events
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
	public ArrayList<Object[]> showAllEventsDesc()
			throws ClassNotFoundException, SQLException {

		ArrayList<Object[]> eventList = new ArrayList<Object[]>();

		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getSearchEventDesc());
		resultSet = statement.executeQuery();
		log.info("All Events retreived from Database :" + eventList);
		while (resultSet.next()) {
			Object[] eventObject = new Object[8];
			eventObject[0] = resultSet.getInt("eventid");
			eventObject[1] = resultSet.getString("name");
			eventObject[2] = resultSet.getString("description");
			eventObject[3] = resultSet.getString("duration");
			eventObject[4] = resultSet.getString("eventtype");
			eventObject[5] = resultSet.getString("places");
			eventObject[6] = resultSet.getInt("seatsavailable");
			eventObject[7] = resultSet.getInt("eventsessionid");
			eventList.add(eventObject);
		}
		resultSet.close();
		FERSDataConnection.closeConnection();
		

		return eventList;

	}

	/**
	 * This method fetch the event on basis of eventId
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that get an event from
	 * the event table for provided event id. <br/>
	 * Execute the SQL statement and keep a reference to the result set by using
	 * getGetEvent method. <br/>
	 * Using a WHILE LOOP, store each record in the result set returned in an
	 * Event object by setting the values of the Event attributes as the
	 * corresponding values in the Result set. <br/>
	 * Return the Event object to the calling method. <br/>
	 * 
	 * @param eventId
	 * @param sessionId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Event getEvent(int eventId, int sessionId)
			throws ClassNotFoundException, SQLException {

		Event event = new Event();
		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getGetEvent());
		statement.setInt(1,eventId);
		statement.setInt(2, sessionId);
		log.info("Get Event Query is about to be executed");
		resultSet=statement.executeQuery();
		while(resultSet.next()){
		event.setEventid(resultSet.getInt("eventid"));
		log.info("Event ID retrieved: "+resultSet.getInt("eventid"));
		event.setName(resultSet.getString("name"));
		log.info("Event Name retrieved: "+resultSet.getString("name"));
		event.setEventtype(resultSet.getString("eventtype"));
		log.info("Event Type retrieved: "+resultSet.getString("eventtype"));
		event.setDescription(resultSet.getString("description"));
		log.info("Event Description retrieved: "+resultSet.getString("description"));
		event.setPlace(resultSet.getString("places"));
		log.info("Event Description retrieved: "+resultSet.getString("description"));
		event.setDuration(resultSet.getString("duration"));
		event.setSessionId(resultSet.getInt("EVENTSESSIONID"));
		log.info("Event Session ID retrieved: "+resultSet.getInt("EVENTSESSIONID"));
		event.setSeatsavailable(resultSet.getString("SEATSAVAILABLE"));
		log.info("Event Seating retrieved: "+resultSet.getString("SEATSAVAILABLE"));
		}
		connection.close();

		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document

		return event;
	}

	/**
	 * This method updates the event
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that get an event from
	 * the event table for provided event id. <br/>
	 * Execute the SQL statement and keep a reference to the result set. <br/>
	 * Update the event object by calling getUpdateEventSession method Event is
	 * updated in database. <br/>
	 * Return the status of executed query. <br/>
	 * 
	 * @param updateEvent
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int updateEvent(Event updateEvent) throws ClassNotFoundException,
			SQLException {
		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getUpdateTEvent());
		log.info("The query is about to be executed");
		statement.setString(1,updateEvent.getName());
		statement.setString(2,updateEvent.getDescription());
		statement.setString(3, updateEvent.getPlace());
		statement.setString(4,updateEvent.getDuration());
		statement.setString(5,updateEvent.getEventtype());
		statement.setInt(6, updateEvent.getEventid());
		int result=statement.executeUpdate();
		log.info("EventId is: "+updateEvent.getEventid());
		log.info("Updation Result Integer is: " + result);
		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document
		connection.close();

		return result;
	}

	/**
	 * This method inserts new event in database
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that get an event from
	 * the event table for provided event id. <br/>
	 * Execute the SQL statement and keep a reference to the result set. <br/>
	 * Insert the event object by calling getInsertEvent method Event object is
	 * inserted in database <br/>
	 * Return the status of executed query. <br/>
	 * 
	 * @param insertEvent
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int insertEvent(Event insertEvent) throws ClassNotFoundException,
			SQLException {
		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getInsertEvent());
		log.info("The insert query is about to be executed");
		statement.setString(2,insertEvent.getName());
		statement.setString(3,insertEvent.getDescription());
		statement.setString(4, insertEvent.getPlace());
		statement.setString(5,insertEvent.getDuration());
		statement.setString(6,insertEvent.getEventtype());
		statement.setInt(1, insertEvent.getEventid());
		int result=statement.executeUpdate();
		log.info("EventId is: "+insertEvent.getEventid());
		log.info("Insertion Result Integer is: " + result);
		connection.close();
		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document

		return result;
	}

	/**
	 * This method deletes the event on basis of eventid and eventsessionid from
	 * database
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that get an event from
	 * the event table for provided event id. <br/>
	 * Execute the SQL statement and keep a reference to the result set. <br/>
	 * Delete the event object by calling getDeleteEventSession and
	 * getDeleteEvent method Event and EventSession object is deleted from
	 * database <br/>
	 * Return the status of executed query. <br/>
	 * 
	 * @param eventId
	 * @param sessionId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FERSGenericException
	 */
	public int deleteEvent(int eventId, int sessionId)
			throws ClassNotFoundException, SQLException, FERSGenericException {
		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getDeleteEventSession());
		statement.setInt(1,sessionId);
		log.info("The query for deleting Event Session is about to be executed");
		int result1=statement.executeUpdate();
		log.info("SessionId is deleted: "+sessionId);
		PreparedStatement statement2=connection.prepareStatement(query.getDeleteEvent());
		statement2.setInt(1, eventId);
		log.info("The query for deleting Event is about to be executed");
		int result2=statement2.executeUpdate();
		log.info("EventId is deleted: "+eventId);
		log.info("Deletion Result Integer is: " + result2);



		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document

		return result1+result2;
	}

	/**
	 * This method fetches the list of event coordinator from database
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that gets all the
	 * eventcoordinator username from the eventcoordinator table in descending
	 * order. <br/>
	 * Execute the SQL statement and keep a reference to the result set. <br/>
	 * Using a WHILE LOOP, store each record in the result set returned in an
	 * EventCoordinator object by setting the values of the Event attributes as
	 * the corresponding values in the Result set. <br/>
	 * Return the List to the calling method. <br/>
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<EventCoordinator> getEventCoordinator()
			throws ClassNotFoundException, SQLException {

		List<EventCoordinator> eventCoordinatorList = new ArrayList<EventCoordinator>();
		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getSelectEventCoordinator());
		resultSet=statement.executeQuery();
		int amount=0;
		while(resultSet.next()){
		EventCoordinator eventcoordinator=new EventCoordinator();
		eventcoordinator.setEventcoordinatorid(resultSet.getInt(1));
		eventcoordinator.setUserName(resultSet.getString(2));
		eventCoordinatorList.add(eventcoordinator);
		amount++;
		}
		log.info("The number of events retrieved: "+amount);
		connection.close();
		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document

		return eventCoordinatorList;
	}
}
