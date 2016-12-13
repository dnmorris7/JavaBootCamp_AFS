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

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.EventCoordinator;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.EventServiceImpl;
import com.accenture.adf.exceptions.FERSGenericException;
import com.accenture.adf.helper.FERSDataConnection;

/**
 * Junit test case to test class EventServiceImpl
 * 
 */
public class TestEventServiceImpl {

	private List<Object[]> eventList;
	private Visitor visitor;
	private EventServiceImpl eventServiceImpl;
	private ArrayList<Event> events;
	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet rs = null;
	private Event newevent = null;
	private Event newevent2;

	/**
	 * Set up the objects required before execution of every method
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		eventServiceImpl = new EventServiceImpl();
		visitor = new Visitor();

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

		newevent = new Event();
		newevent.setEventid(0);
		newevent.setDescription("test");
		newevent.setDuration("durationTest");
		newevent.setEventtype("eventtypeTest");
		newevent.setName("nameTest");
		newevent.setPlace("placeTest");
		newevent.setSeatsavailable("15");
newevent.setSessionId(000);

	/*	newevent2 = newevent;
		newevent2.setDescription("test2");
		newevent2.setDuration("durationTest2");
		newevent2.setEventtype("eventtypeTest2");
		newevent2.setName("nameTest2");
		newevent2.setPlace("placeTest2");
		newevent2.setSeatsavailable("45");
*/
		events = new ArrayList<Event>();
		events.add(newevent);
		// registering the visitor to the event and passing the
		// registgeredEvents the
		// event array list we made
		visitor.setRegisteredEvents(events);
		events.add(newevent);
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
		// events = null;
		eventList = null;
		newevent=null;
		events=null;
		connection.close();
	}

	/**
	 * Test case to test the method getAllEvents
	 */
	@Test
	public void testGetAllEvents() {
		// cast array - not sure if correct
		eventList = (List<Object[]>) eventServiceImpl.getAllEvents();
		int size1 = eventList.size();
		//System.out.println(size1);
		assertTrue(size1 == 8 || size1 == 3);
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
	@Test
	public void testCheckEventsofVisitor_positive() {
		try {

			VisitorDAO vd = new VisitorDAO();
			visitor = vd.searchUser("jjones", "password");
			vd.registerVisitorToEvent(visitor, 1001, 10001);
			boolean checkEventsofVisitor = eventServiceImpl					
					.checkEventsofVisitor(visitor, 1001, 10001);
			assertEquals(true, checkEventsofVisitor);
		} catch (Exception e) {
			fail("Failed due to: " + e.getMessage());
		}
		// will assert true if visior is going to event 1001 set him up for
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
			vd.registerVisitorToEvent(visitor, 1001, 10001);
			boolean checkEventsofVisitor = eventServiceImpl
					.checkEventsofVisitor(visitor, 1001, 10001);
			assertEquals(true, checkEventsofVisitor);
		} catch (Exception e) {
			fail("Failed due to: " + e.getMessage());
		}
	}

	/*
	 * @Test public void testCheckEventsofVisitor_negative(Visitor visitor, int
	 * eventid, int sessionid) { try {
	 * 
	 * VisitorDAO vd = new VisitorDAO(); visitor = vd.searchUser("bsmith",
	 * "password"); vd.registerVisitorToEvent(visitor, 1001, 10001); boolean
	 * checkEventsofVisitor = eventServiceImpl .checkEventsofVisitor(visitor,
	 * 1001); assertEquals(true, checkEventsofVisitor); } catch (Exception e) {
	 * fail("Failed due to: " + e.getMessage()); } }
	 */

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

	/*
	 * @Test public void testUpdateEventDeletions_Positive() {
	 *//**
	 * @TODO: Call updateEventDeletions and assert the return type of this
	 *        method
	 */
	/*
	 * int eventId = 1004; EventDAO evDao = new EventDAO(); int initialSeats =
	 * 0;
	 * 
	 * initialSeats = getSeats(1004);
	 * 
	 * try { evDao.updateEventNominations(eventId); } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } int updatedSeats =
	 * getSeats(1004); assertEquals(initialSeats - 1, updatedSeats);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * eventServiceImpl.updateEventDeletions(eventId);
	 * 
	 * int finalSeats = getSeats(eventId); assertEquals(updatedSeats + 1,
	 * finalSeats); }
	 */

	/**
	 * Junit test case for getEventCoordinator
	 */
	@Test
	public void testGetEventCoordinator() {
		/**
		 * @TODO: Call getAllEventCoordinators and assert the size of return
		 *        type of this method
		 */
List<EventCoordinator> eventListCoordinators = eventServiceImpl.getAllEventCoordinators();
int size1 = eventListCoordinators.size();
//System.out.println(size1);
assertTrue(size1 == 5);

	}

	/**
	 * Junit test case for getEvent
	 */
	@Test
	public void testGetEvent() {
		/**
		 * @TODO: Call getEvent and assert the event id of this event with
		 *        passed event id
		 */
		eventList = eventServiceImpl.getAllEvents("Tour");
		int size1 = eventList.size();

		eventList = eventServiceImpl.getAllEvents("Pavl");
		int size2 = eventList.size();
		assertTrue(size1 == 4 && size2 == 3);

	}

	@Test
	public void testUpdateEventDeletions_Positive() {
		/**
		 * @TODO: Call updateEventDeletions and assert the return type of this
		 *        method
		 */
		int eventId = 1004;
		int sessionid= 10004;
		EventDAO evDao = new EventDAO();
		int initialSeats = 0;

		initialSeats = getSeats(1004);

		try {
			evDao.updateEventNominations(eventId, sessionid);
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
		assertEquals(initialSeats, updatedSeats);


		eventServiceImpl.updateEventDeletions(eventId, sessionid);

		int finalSeats = getSeats(sessionid);
		assertEquals(updatedSeats, finalSeats);
	}

	/**
	 * Junit test case for updateEvent
	 */
	@Test
	public void testInsertEvent() {
		/**
		 * @TODO: Call insertEvent Create event object by setting appropriate
		 *        values Assert the status of insertEvent method
		 */

		int status = eventServiceImpl.insertEvent(newevent);
		assertEquals(1, status);

	}

	/**
	 * Junit test case for updateEvent
	 */
	@Test
	public void testUpdateEvent() {
		/**
		 * @TODO: Fetch Event object by calling getAllEvents method Update event
		 *        object by setting appropriate values Call updateEvent method
		 *        Assert the status of updateEvent method
		 */
		 newevent = eventServiceImpl.getEvent(newevent.getEventid(), newevent.getSessionId());
		newevent.setDescription("test2");
		newevent.setDuration("durationTest2");
		newevent.setEventtype("eventtypeTest2");
		newevent.setName("nameTest2");
		newevent.setPlace("placeTest2");
		newevent.setSeatsavailable("45");
		int status = eventServiceImpl.updateEvent(newevent);
		assertEquals(1, status);
	}

	/**
	 * Junit test case for deleteEvent
	 */
	@Test
	public void testDeleteEvent() {
		/**
		 * @TODO: Fetch Event object by calling getAllEvents method Update event
		 *        object by setting appropriate values Call deleteEvent method
		 *        Assert the status of deleteEvent method
		 */
		int status = eventServiceImpl.deleteEvent(newevent.getEventid(), newevent.getEventSession());
		assertEquals(1, status);
		
	}

	public int getSeats(int sessionid) {
		int seating = 0;
		try {

			statement = connection
					.prepareStatement("SELECT SEATSAVAILABLE FROM EVENT WHERE SESSIONID = ?");
			statement.setInt(1, sessionid);
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
