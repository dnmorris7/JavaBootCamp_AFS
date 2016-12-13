package com.accenture.adf.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.VisitorServiceImpl;
import com.accenture.adf.exceptions.FERSGenericException;

/**
 * Junit test class for VisitorServiceImpl
 *
 */
public class TestVisitorServiceImpl {

	private List<Event> visitorList;	
	private Visitor visitor;
	private VisitorServiceImpl visitorServiceImpl;

	/**
	 * Set up the initial methods 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {		
		visitorServiceImpl = new VisitorServiceImpl();
		visitor = new Visitor();
	}
	
	

	/**
	 * Deallocates the objects after execution of every method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		visitorList = null;
		visitor = null;
		visitorServiceImpl = null;
		
	}


	/**
	 * Test case for method createVisitor
	 */
	//Positive Test Case
	@Test
	public void testCreateVisitor() {
		/**
		 * @TODO: Set the appropriate values for visitor object and
		 * call the method createVisitor by passing an argument of this visitor 
		 * object and then asserting the returned type of this method
		 */		
		
		//setVisitorDataOne();
		assertEquals(true,visitorServiceImpl.createVisitor(visitor));
		
	
	}

	/**
	 * Test case for method createVisitor
	 */
	@Test
	public void testSearchVisitor() {
		/**
		 * @TODO: Call searchVisitor method by passing the appropriate arguments 
		 * and then asserting the returned type visitor username with the argument passed
		 */
		
		assertEquals("bsmith",(visitorServiceImpl.searchVisitor("bsmith","password")).getUserName());
		
	}
		
	

	/**
	 * Test case for method RegisterVisitor
	 */
	@Test
	public void testRegisterVisitor() {
		/**
		 * @TODO: Call RegisterVisitor method by passing visitor object which 
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of RegisterVisitor method
		 */
		
		visitor.setVisitorId(1001);
		boolean found = false;
		visitorServiceImpl.RegisterVisitor(visitorServiceImpl.searchVisitor("bsmith", "password"), 1001);
		List<Event> events = visitorServiceImpl.showRegisteredEvents(visitor);
		System.out.println(events);
	
		for (Event e: events) {
			if (e.getEventid() == 1001) {
				found = true;
			}
		}
		assertTrue(found);
	}

	/**
	 * Test case for method showRegisteredEvents
	 */
	@Test
	public void testShowRegisteredEvents() {
		/**
		 * @TODO: Call showRegisteredEvents method by passing visitor object which 
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of showRegisteredEvents method 
		 */		
		
			visitor.setVisitorId(1001);
			//List<Event> events = visitorServiceImpl.showRegisteredEvents(visitor);
			
			//assertEquals(new ArrayList<Event>(),events);
			
			
			visitorServiceImpl.RegisterVisitor(visitorServiceImpl.searchVisitor("bsmith", "password"), 1001);
			List<Event> events = visitorServiceImpl.showRegisteredEvents(visitor);
			boolean found = false;
			for (Event e: events) {
				if (e.getEventid() == 1001) {
					found = true;
				}
			}
			assertTrue(found);
			
		

		
	}

	/**
	 * Test case for method updateVisitorDetails
	 */
	@Test
	public void testUpdateVisitorDetailsPos() {
		/**
		 * @TODO: Call updateVisitorDetails method by passing the visitor object which
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of updateVisitorDetails
		 */		
		Visitor v = visitorServiceImpl.searchVisitor("bsmith", "password");
		
		v.setEmail("hey");
		visitorServiceImpl.updateVisitorDetails(v);
		v = visitorServiceImpl.searchVisitor("bsmith", "password");
		
		assertEquals("hey", v.getEmail());
		
	}
	
	/**
	 * Test case for method updateVisitorDetails
	 */
	@Test
	public void testUpdateVisitorDetailsNeg() {
		/**
		 * @TODO: Call updateVisitorDetails method by passing the visitor object which
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of updateVisitorDetails
		 */		
		Visitor v = visitorServiceImpl.searchVisitor("bsmith", "password");
		
		v.setLastName(null);
		visitorServiceImpl.updateVisitorDetails(v);
		v = visitorServiceImpl.searchVisitor("bsmith", "password");
		assertEquals("Smith", v.getLastName());
		
	}

	/**
	 * Test case for method unregisterEvent
	 */
	@Test
	public void testUnregisterEvent() {
		/**
		 * @TODO: Call unregisterEvent method by passing the visitor object which can be
		 * retrieved using searchVisitor method and then asserting the returned type 
		 * of unregisterEvent
		 */
		Visitor v = visitorServiceImpl.searchVisitor("bsmith", "password");

		visitorServiceImpl.RegisterVisitor(v, 1001);
		ArrayList<Event> events = visitorServiceImpl.showRegisteredEvents(v);
		boolean found = false;
		for (Event e: events) {
			if (e.getEventid() == 1001) {
				found = true;
			}
		}
		assertTrue(found);
		
		visitorServiceImpl.unregisterEvent(v, 1001);
		
		events = visitorServiceImpl.showRegisteredEvents(v);
		found = false;
		for (Event e: events) {
			if (e.getEventid() == 1001) {
				found = true;
			}
		}
		assertFalse(found);
	}
	
	/**
	 * Test case for method unregisterEvent
	 */
	@Test
	public void testChangePassword() {
		
		Visitor v = visitorServiceImpl.searchVisitor("bsmith", "password");
		
		v.setPassword("word");
		try {
			visitorServiceImpl.changePassword(v);
		} catch (FERSGenericException e) {
			e.printStackTrace();
		}
		v = null;
		v = visitorServiceImpl.searchVisitor("bsmith", "word");
		
		assertNotNull(v);
		
		
	}

}
