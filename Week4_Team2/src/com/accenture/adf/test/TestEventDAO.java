package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.AssertThrows;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.EventCoordinator;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.exceptions.FERSGenericException;
import com.accenture.adf.helper.FERSDataConnection;

/**
 * Junit test class for EventDAO class
 * 
 */
public class TestEventDAO {

	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet resultSet = null;
	private ArrayList<Object[]> showAllEvents;
	private EventDAO dao;
	private Event testEvent;
	private Event testEvent2;

	/**
	 * Sets up database connection before other methods are executed in this
	 * class
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpDatabaseConnection() throws Exception {
		connection = FERSDataConnection.createConnection();
	}

	/**
	 * Sets up the objects required in other methods
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		showAllEvents = new ArrayList<Object[]>();
		dao = new EventDAO();
		Visitor visitor1 = new Visitor();

		testEvent = new Event();
		testEvent.setName("Tester");
		testEvent.setDescription("Tester Description");
		testEvent.setPlace("Testington Hills");
		testEvent.setDuration("50000");
		testEvent.setEventtype("Drama Play");
		testEvent.setEventid(1050);
		testEvent.setEventSession(10005);
		testEvent.setSeatsavailable("50");
		testEvent.setEventCoordinatorId(105);
		
		testEvent2 = new Event();
		testEvent2.setName("Updater Tester");
		testEvent2.setDescription("Updated Tester Description");
		testEvent2.setPlace("Updation Heights");
		testEvent2.setDuration("40000");
		testEvent2.setEventtype("Space Opera Play");
		testEvent2.setEventid(1050);
		testEvent2.setEventSession(10005);
		testEvent2.setSeatsavailable("100");
		testEvent2.setEventCoordinatorId(105);

	}

	/**
	 * Closes the database connection after all the methods are executed
	 * 
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownDatabaseConnection() throws Exception {
		/**
		 * @TODO: Close connection object here
		 */
	}

	/**
	 * Deallocate the resources after execution of method
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null
		 */
	}

	/**
	 * Positive test case to test the method showAllEvents
	 */
	@Test
	public void testShowAllEvents_Positive() {
		try {
			showAllEvents = dao.showAllEvents();
			int size1 = 8;
			assertEquals(size1, dao.showAllEvents().size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Test Failed due to: " + e.getMessage());

		}

		try {
			dao.showAllEvents();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @TODO: Call showAllEvents method and assert it for size of returned type
	 *        list
	 */

	@Test
	public void testShowAllEventsByName_Positive() {
		try {
			showAllEvents = dao.showAllEvents("Tour");
			int size1 = 4;
			assertEquals(size1, dao.showAllEvents("Tour").size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Test Failed due to: " + e.getMessage());

		}

		try {
			dao.showAllEvents();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Junit test case to test positive case for updateEventDeletions
	 */
	@Test
	public void testUpdateEventDeletions_Positive() {

		try {
			int eventid = 1001;
			int seats1 = 0;
			int seats2 = -1;
			statement = connection
					.prepareStatement("SELECT SEATSAVAILABLE FROM EVENTSESSION WHERE EVENTSESSIONID = ?");
			int sessionid = 10004;
			// statement.setInt(1, eventid);

			statement.setInt(1, sessionid);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				seats1 = resultSet.getInt(1);
			}
			dao.updateEventDeletions(eventid, sessionid);
			// modified prepared statement to add a ? for sessionid
			PreparedStatement statement2 = connection
					.prepareStatement("SELECT SEATSAVAILABLE FROM EVENTSESSION WHERE EVENTSESSIONID = ?");
			// statement2.setInt(1, eventid);
			statement2.setInt(1, sessionid);
			ResultSet rs2 = statement2.executeQuery();
			if (rs2.next()) {
				seats2 = rs2.getInt(1);
			}
			assertEquals(seats1, seats2);
		}

		catch (Exception e) {
			fail("Test Failed due to: " + e.getMessage());
		}

		/**
		 * @TODO: Find out seats available for an event by opening a connection
		 *        and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE
		 *        EVENTID = ? Call the updateEventDeletions for eventId Again
		 *        find out the seats available for this event
		 *        testSeatsAvailableBefore should be 1 more then
		 *        testSeatsAvailableAfter
		 */
	}

	/**
	 * Exception test case for method updateEventDeletions
	 */
	@Test
	public void testUpdateEventDeletions_Exception() {

		try {
			int eventid = 1001;
			int seats1 = 0;
			int sessionid = 10004;
			dao.updateEventDeletions(eventid, sessionid);
			// changed prepare statement to add ? for session id - still not
			// sure if this is right thing to do
			statement = connection
					.prepareStatement("SELECT SEATSAVAILABLE FROM EVENT WHERE SESSIONID=?");
			// statement.setInt(1, eventid);
			statement.setInt(2, sessionid);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				seats1 = resultSet.getInt(1) + 1;
			}
		} catch (Exception e) {
			assertEquals("Records not updated properly", e.getMessage());
		}
		/**
		 * @TODO: Call updateEventDeletions for incorrect eventid and it should
		 *        throw an exception
		 */
	}

	/**
	 * Negative test case for method updateEventDeletions
	 */
	/*
	 * @Test public void testUpdateEventDeletions_Negative() {//Don't think we
	 * need this method
	 *//**
	 * @TODO: Call updateEventDeletions for incorrect eventid and it should
	 *        throw an exception
	 */
	/*
	 * }
	 */

	/**
	 * Positive test case for method updateEventNominations
	 */
	@Test
	public void testUpdateEventNominations_Positive() {
		int seats1 = 0;
		int seats2 = -1;
		try {
			int eventid = 1001;
			statement = connection
					.prepareStatement("SELECT SEATSAVAILABLE FROM EVENTSESSION WHERE EVENTSESSIONID = ?");
			int sessionid = 10003;
			// statement.setInt(1, eventid);
			statement.setInt(1, sessionid);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				seats1 = resultSet.getInt(1) - 1;
			}
			dao.updateEventNominations(eventid, sessionid);
			PreparedStatement statement2 = connection
					.prepareStatement("SELECT SEATSAVAILABLE FROM EVENTSESSION WHERE EVENTSESSIONID = ?");
			// statement2.setInt(1, eventid);
			statement2.setInt(1, sessionid);
			ResultSet rs2 = statement2.executeQuery();
			if (rs2.next()) {
				seats2 = rs2.getInt(1);
			}
			assertEquals(seats1, seats2);
		} catch (Exception e) {
			fail("Test Failed due to: " + e.getMessage());
		}

		/**
		 * @TODO: Find out seats available for an event by opening a connection
		 *        and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE
		 *        EVENTID = ? Call the updateEventNominations for eventId Again
		 *        find out the seats available for this event
		 *        testSeatsAvailableBefore should be 1 le2ss then
		 *        testSeatsAvailableAfter
		 */
	}

	/**
	 * Exception test case for method updateEventNominations
	 */
	@Test
	public void testUpdateEventNominations_Exception() {

		try {
			int seats1 = 0;
			int eventid = 9;
			int sessionid = 424;
			dao.updateEventDeletions(eventid, sessionid);
			statement = connection
					.prepareStatement("SELECT SEATSAVAILABLE FROM EVENT WHERE SESSIONID = ?");
			// statement.setInt(1, eventid);
			statement.setInt(1, sessionid);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				seats1 = resultSet.getInt(1);
			}
		} catch (Exception e) {
			assertEquals("Records not updated properly", e.getMessage());
		}
		/**
		 * @TODO: Call updateEventNominations for incorrect eventid and it
		 *        should throw an exception
		 */
	}

	@Test
	public void testCheckEventsOfVisitor_Positive() {
		try {
			Visitor visitor1 = new Visitor();
			boolean test1 = dao.checkEventsofVisitor(visitor1, 1111, 10001);
			assertEquals(test1, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Test Failed due to: " + e.getMessage());
		}

		/**
		 * @TODO: Create visitor object by setting appropriate values Call
		 *        checkEventsofVisitor method by passing this visitor object and
		 *        valid eventId Assert the value of return type
		 */
	}

	@Test
	/** No Events for visitor listed*/
	public void testCheckEventsOfVisitor_Negative() {
		try {
			Visitor visitor1 = new Visitor();
			boolean test1 = dao.checkEventsofVisitor(visitor1, 1111, 12349);
			assertFalse(test1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Test Failed due to: " + e.getMessage());

		}
	}

	@Test
	public void testGetEventCoordinator() {
		/**
		 * @TODO: Call getEventCoordinator method Assert the size of return type
		 *        arraylist
		 */
		EventDAO eDAO = new EventDAO();
		try {
			List<EventCoordinator> eventCoordinators = eDAO
					.getEventCoordinator();
			assertTrue(eventCoordinators.size() > 0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Junit test case for getEvent
	 */
	@Test
	public void testGetEvent() {
		/**
		 * @TODO: Call getEvent method Assert the returned Event type with the
		 *        passed value of event id
		 */

		Event event = new Event();
	
		// TODO: Figure out the strange behavior here. Its not caring what I use as the expected value.
		try {
			event = dao.getEvent(1001, 10001);
		
		assertEquals(1001, event.getEventid());
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * Junit test case for updateEvent
	 */
	@Test
	public void testInsertEvent() {
		/**
		 * @TODO: Create Event object by setting appropriate values Call
		 *        insertEvent method by passing this event object Assert the
		 *        status of return type of this insertEvent method
		 */

		try {
			int resultSet = 0;
			resultSet=dao.insertEvent(testEvent);
			assertEquals(1, resultSet);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * Junit test case for updateEvent
	 */
	@Test
	public void testUpdateEvent() {
		/**
		 * @TODO: Fetch Event object by calling showAllEvents method Update the
		 *        values of event object Call updateEvent method by passing this
		 *        modified event as object Assert the status of return type of
		 *        updateEvent method
		 */
	try {
		int resultSet = dao.updateEvent(testEvent2);
		assertEquals(1, resultSet);
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

	/**
	 * Junit test case for deleteEvent
	 */
	@Test
	public void testDeleteEvent() {
		/**
		 * @TODO: Fetch Event object by calling showAllEvents method * Call
		 *        deleteEvent method by passing this event id and event session
		 *        id as object Assert the status of return type of updateEvent
		 *        method
		 */
		int resultSet = -1;
		try {
			
			resultSet = dao.deleteEvent(testEvent.getEventid(), testEvent.getSessionId());
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FERSGenericException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1, resultSet);
	}

}
