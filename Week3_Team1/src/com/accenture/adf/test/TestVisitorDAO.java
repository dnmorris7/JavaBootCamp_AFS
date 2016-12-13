package com.accenture.adf.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.helper.FERSDataConnection;
import com.accenture.adf.helper.FERSDbQuery;

/**
 * JUnit test case for VisitorDAO class for testing all repository methods to
 * call database sub-routines
 * 
 */
public class TestVisitorDAO {

	private Visitor visitor;
	private VisitorDAO visitorDAO;
	private ArrayList<Event> registeredEvents;

	/**
	 * Setting up initial objects
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		visitor = new Visitor();
		visitorDAO = new VisitorDAO();
		registeredEvents = new ArrayList<Event>();
	}

	public void setVisitorDataOne() {
		visitor.setFirstName("Steve");
		visitor.setLastName("Williams");
		visitor.setAddress("5555 North Main St.");
		visitor.setEmail("will.steve@gmail.com");
		visitor.setPassword("banjo");
		visitor.setUserName("sWill");
		visitor.setVisitorId(1007);
		visitor.setPhoneNumber("4445556666");
	}

	/**
	 * Deallocating objects after execution of every method
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		visitor = null;
		visitorDAO = null;
		registeredEvents = null;
	}

	/**
	 * Test case for method insertData
	 */
	@Test
	public void testInsertData() {

		// Positive Case
		// Assert insert visitor success
		setVisitorDataOne();
		try {
			assertTrue(visitorDAO.insertData(visitor));
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		} catch (Exception e) {
		}
		visitor = null;
		try {
			visitor = visitorDAO.searchUser("sWill", "banjo");
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}
		assertEquals("Williams", visitor.getLastName());
		assertEquals("banjo", visitor.getPassword());
		assertEquals("4445556666", visitor.getPhoneNumber());
		assertEquals(visitor.getEmail(), "will.steve@gmail.com");
	}

	/**
	 * Test case for method insertData
	 */
	@Test
	public void testInsertDataNeg() {

		setVisitorDataOne();
		// Negative Case
		// Assert Duplicate insert fails
		try {
			assertFalse(visitorDAO.insertData(visitor));
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		} catch (Exception e) {
		}
	}

	/**
	 * Positive Test case for method searchUser
	 */
	@Test
	public void testSearchUserPos() {

		// Assert Successful Search
		try {
			visitor = visitorDAO.searchUser("bsmith", "password");
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}

		assertEquals(visitor.getUserName(), "bsmith");
		assertEquals(visitor.getPhoneNumber(), "748937487");
	}

	/**
	 * Negative Test case for method searchUser
	 */
	@Test
	public void testSearchUserNeg() {

		// Assert Failed Search (before visitor added)
		try {
			visitor = visitorDAO.searchUser("billybobjohnson", "allie");
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}
		assertNull(visitor);
	}

	/**
	 * Positive Test case for method registerVisitorToEvent
	 */
	@Test
	public void testRegisterVisitorToEventPos() {

		setVisitorDataOne();
		try {
			visitorDAO.registerVisitorToEvent(visitor, 1001);
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		} catch (Exception e) {
		}

		ArrayList<Event> events = null;
		try {
			events = visitorDAO.registeredEvents(visitor);
		} catch (ClassNotFoundException e1) {
		} catch (SQLException e1) {
		}

		boolean found = false;
		for (Event e : events) {
			if (e.getEventid() == 1001) {
				found = true;
			}
		}
		assertTrue(found);
	}

	/**
	 * Negative Test case for method registerVisitorToEvent
	 * 
	 * Only need to test for improper eventid. Improper visitor will be handled
	 * before this method (during searchUser)
	 */
	@Test
	public void testRegisterVisitorToEventNeg() {
		
		setVisitorDataOne();
		try {
			visitorDAO.registerVisitorToEvent(visitor, 99999);
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		} catch (Exception e) {
		}

		ArrayList<Event> events = null;
		try {
			events = visitorDAO.registeredEvents(visitor);
		} catch (ClassNotFoundException e1) {
		} catch (SQLException e1) {
		}
		boolean found = false;
		for (Event e : events) {
			if (e.getEventid() == 99999) {
				found = true;
			}
		}
		assertFalse(found);
	}

	/**
	 * Test case for method registeredEvents
	 */
	@Test
	public void testRegisteredEvents() {

		setVisitorDataOne();

		// Add event and assert even list not empty
		//try {
		//	visitorDAO.registerVisitorToEvent(visitor, 1001);
		//} catch (ClassNotFoundException e) {
		//} catch (SQLException e) {
		//} catch (Exception e) {
		//}

		ArrayList<Event> visEvent = new ArrayList<Event>();
		try {
			visEvent = visitorDAO.registeredEvents(visitor);
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		} catch (Exception e) {
		}
		assertTrue(visEvent.size() > 0);
	}

	/**
	 * Positive Test case for method updateVisitor
	 */
	@Test
	public void testUpdateVisitorPos() {

		int changedRows = 0;
		// Insert original visitor
		setVisitorDataOne();
		try {
			visitorDAO.insertData(visitor);
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		} catch (Exception e) {
		}

		// Make changes and update
		visitor.setPhoneNumber("1119991111");
		try {
			changedRows = visitorDAO.updateVisitor(visitor);
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}

		// Search user and assert changes
		try {
			visitor = visitorDAO.searchUser("sWill", "banjo");
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}
		assertTrue(changedRows > 0);
		assertEquals(visitor.getPhoneNumber(), "1119991111");
	}

	/**
	 * Negative Test case for method updateVisitor
	 */
	@Test
	public void testUpdateVisitorNeg() {

		int changedRows = 0;
		try {
			changedRows = visitorDAO.updateVisitor(new Visitor());
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}
		assertEquals(changedRows, 0);
	}

	/**
	 * Positive Test case for method registeredEvents
	 */
	@Test
	public void testUnregisterEventPos() {

		// Visitor is registered for event
		// and successfully unregistered
		setVisitorDataOne();

		// Assert Registered
		ArrayList<Event> visEvent = new ArrayList<Event>();
		try {
			visEvent = visitorDAO.registeredEvents(visitor);
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		} catch (Exception e) {
		}
		assertTrue(visEvent.size() > 0);

		// Unregister
		 try {
		 visitorDAO.unregisterEvent(visitor, 1001);
		 } catch (ClassNotFoundException e) {
		 } catch (SQLException e) {
		 } catch (Exception e) {
		 }

		// Assert not registered
		visEvent = new ArrayList<Event>();
		try {
			visEvent = visitorDAO.registeredEvents(visitor);
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		} catch (Exception e) {
		}
		assertEquals(visEvent.size(), 0);

	}

	/**
	 * Negative Test case for method registeredEvents
	 */
	@Test
	public void testUnregisterEventNeg() {

		// Visitor is not registered for event,
		// so unregister fails
		setVisitorDataOne();

		ArrayList<Event> events = new ArrayList<Event>();
		try {
			events = visitorDAO.registeredEvents(visitor);
		} catch (ClassNotFoundException e1) {
		} catch (SQLException e1) {
		}
		int befUnreg = events.size();
		// Unregister
		try {
			visitorDAO.unregisterEvent(visitor, 99999);
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		} catch (Exception e) {
		}
		
		try {
			events = visitorDAO.registeredEvents(visitor);
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}
		int aftUnreg = events.size();
		assertEquals(befUnreg, aftUnreg);
	}

	/**
	 * Exception Test case for method registeredEvents
	 */
	@Test
	public void testUnregisterEventExc() {
		setVisitorDataOne();
		try {
			visitorDAO.unregisterEvent(visitor, 99999);
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		} catch (Exception e) {
		}
	}
	
	/**
	 * Test changed password with null visitor
	 */
	@Test
	public void testChangedPasswordPos() {
		Visitor v = null;
		try {
			v = visitorDAO.searchUser("bsmith", "password");
			assertEquals("Smith", v.getLastName());
			v.setPassword("charlie");
			visitorDAO.changePassword(v);
			v = null;
			v = visitorDAO.searchUser("bsmith", "charlie");
			assertNotNull(v);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test changed password with null visitor
	 */
	@Test
	public void testChangedPasswordNull() {
		Visitor v = null;
		try {
			assertEquals(-1, visitorDAO.changePassword(v));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
