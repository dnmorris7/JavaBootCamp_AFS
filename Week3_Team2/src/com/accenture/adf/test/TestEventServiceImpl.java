package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.EventServiceImpl;
import com.accenture.adf.helper.FERSDataConnection;

/**
 * Junit test case to test class EventServiceImpl
 * 
 */
public class TestEventServiceImpl {

	private List<Event> eventList;
	private Visitor visitor;
	private EventServiceImpl eventServiceImpl;
	private ArrayList<Event> events;
	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet rs = null;

	/**
	 * Set up the objects required before execution of every method
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		eventServiceImpl = new EventServiceImpl();
		visitor = new Visitor();

		// Setup the user, with a fake name and last name.
		// Create an event with an id of 0 and description of test,
		// and register the user for it
		Visitor visitor = new Visitor();
		visitor.setFirstName("TestFirst");
		visitor.setLastName("TestLast");
		visitor.setEmail("emailTest");
		visitor.setAddress("address");
		visitor.setPassword("passwordTest");
		visitor.setPhoneNumber("phoneNumberTest");
		visitor.setVisitorId(0000);
		visitor.setUserName("userNameTest");

		Event event = new Event();
		event.setEventid(0);
		event.setDescription("test");
		event.setDuration("durationTest");
		event.setEventtype("eventtypeTest");
		event.setName("nameTest");
		event.setPlace("placeTest");
		event.setSeatsavailable(0000);

		events = new ArrayList<Event>();
		events.add(event);
		// registering the visitor to the event and passing the
		// registgeredEvents the
		// event array list we made
		visitor.setRegisteredEvents(events);
		events.add(event);
		connection = FERSDataConnection.createConnection();
	}

	/**
	 * Deallocates the objects after execution of every method
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null
		 */
		eventServiceImpl = null;
		visitor = null;
		events = null;
		eventList = null;
		connection.close();
	}

	/**
	 * Test case to test the method getAllEvents
	 */

	// @Test

	@Test
	public void testGetAllEvents() {

		eventList = (ArrayList<Event>) eventServiceImpl.getAllEvents();
		int size1 = eventList.size();
		assertTrue(size1 == 6 || size1 == 3);
		// or could do this
		// assertEquals(getAllEvents.get(0).getDescription(), "test");
		/**
		 * @TODO: Call getAllEvents method and assert it for the size of
		 *        returned array
		 */
	}

	/**
	 * Test case to test the method checkEventsofVisitor
	 */
	/*@Test
	public void testCheckEventsofVisitor() {
		*//**
		 * @TODO: Call checkEventsofVisitor and assert the returned type of this
		 *        method for appropriate return type
		 *//*

		
		 * • In the try/catch block o Load checkEventsofVisitor(…) method via
		 * the EventDao object into the Boolean variable o Keep a reference to
		 * the returned Boolean value. o If no exceptions occur, return the
		 * reference. o If ClassNotFoundException and SQLException exceptions
		 * occur, catch them , log the Exception message and return null.
		 
		// int testId = 1006;
		EventDAO eventDao = new EventDAO();
		eventList = (ArrayList<Event>) eventServiceImpl.getAllEvents();
		visitor.setRegisteredEvents((ArrayList<Event>) eventList);

		boolean results = eventServiceImpl.checkEventsofVisitor(visitor, 1001);
		// assertEquals(true, results);
		assertEquals(results, true);
	}*/

	@Test
	public void testCheckEventsofVisitor_positive() {
		try {

			VisitorDAO vd = new VisitorDAO();
			visitor = vd.searchUser("jjones", "password");
			vd.registerVisitorToEvent(visitor, 1001);
			boolean checkEventsofVisitor = eventServiceImpl.checkEventsofVisitor(visitor, 1001);
			assertEquals(checkEventsofVisitor, true);
		} catch (Exception e) {
			fail("Failed due to: " + e.getMessage());
		}
		// will assert true if visior is going to event 0 which i set him up for
		// don't need to test against anything else b/c boolean
		/**
		 * @TODO: Call checkEventsofVisitor and assert the returned type of this
		 *        method for appropriate return type
		 */

	}

	@Test
	public void testCheckEventsofVisitor_negative() {
		try {

			VisitorDAO vd = new VisitorDAO();
			visitor = vd.searchUser("bsmith", "password");
			vd.registerVisitorToEvent(visitor, 1001);
			boolean checkEventsofVisitor = eventServiceImpl
					.checkEventsofVisitor(visitor, 1001);
			assertEquals(true, checkEventsofVisitor);
		} catch (Exception e) {
			fail("Failed due to: " + e.getMessage());
		}
	}

	/**
	 * Test case to test the method updateEventDeletions
	 * 
	 * @Author David 1. Create a new user, and add an event. 2. Assert that it
	 *         is not null. 3. Use the deletion method 4. Check that trying to
	 *         look up the same event returns a null
	 * 
	 * @Dependencies TODO: Various method dependencies.
	 */
	// @Test

	@Test
	public void testUpdateEventDeletions_Positive() {
		/**
		 * @TODO: Call updateEventDeletions and assert the return type of this
		 *        method
		 */
		int eventId = 1004;
		EventDAO evDao = new EventDAO();
		int initialSeats = 0;

		initialSeats = getSeats(1004);

		try {
			evDao.updateEventNominations(eventId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int updatedSeats = getSeats(1004);
		assertEquals(initialSeats - 1, updatedSeats);
		/*
		 * 
		 * 
		 */

		eventServiceImpl.updateEventDeletions(eventId);

		int finalSeats = getSeats(eventId);
		assertEquals(updatedSeats + 1, finalSeats);
	}

	public int getSeats(int eventId) {
		int seating = 0;
		try {

			statement = connection
					.prepareStatement("SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?");
			statement.setInt(1, eventId);
			rs = statement.executeQuery();
			if (rs.next()) {
				seating = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seating;
	}
}
