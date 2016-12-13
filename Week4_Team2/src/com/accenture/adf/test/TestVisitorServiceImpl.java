package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.VisitorServiceImpl;

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
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
	}

	/**
	 * Test case for method createVisitor
	 */
	@Test
	public void testCreateVisitor() {
		/**
		 * @TODO: Set the appropriate values for visitor object and
		 * call the method createVisitor by passing an argument of this visitor 
		 * object and then asserting the returned type of this method
		 */		
		Visitor visitor = new Visitor();
		visitor.setFirstName("TestFirst");
		visitor.setLastName("TestLast");
		visitor.setEmail("emailTest");
		visitor.setAddress("address");
		visitor.setPassword("passwordTest");
		visitor.setPhoneNumber("phoneNumberTest");
		visitor.setVisitorId(0000);
		visitor.setUserName("userNameTest");
		boolean createVisitor = visitorServiceImpl.createVisitor(visitor);
		assertTrue(createVisitor);
	}
	@Test
	public void testCreateVisitor_Negative() {
		
		Visitor visitor = new Visitor();
		visitor.setFirstName("TestFirst");
		visitor.setLastName("TestLast");
		visitor.setEmail("emailTest");
		visitor.setAddress("address");
		visitor.setPassword("passwordTest");
		visitor.setPhoneNumber("phoneNumberTest");
		visitor.setVisitorId(0000);
		visitor.setUserName("userNameTest");
		boolean createVisitor = visitorServiceImpl.createVisitor(visitor);
		assertEquals(createVisitor, false);
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
		Visitor foundVisitor = visitorServiceImpl.searchVisitor("jjones", "password");
		assertEquals(foundVisitor.getUserName(), "jjones");
	}
	@Test
	public void testSearchVisitor_Neg() {
		
		Visitor foundVisitor = visitorServiceImpl.searchVisitor("jjones", "password");
		assertNotSame(foundVisitor.getUserName(), "bsmith");
	}

	/**
	 * Test case for method RegisterVisitor
	 */
	//K - modified to incorporate sessionid
	@Test
	public void testRegisterVisitor() {
		/**
		 * @TODO: Call RegisterVisitor method by passing visitor object which 
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of RegisterVisitor method 
		 */	
		Visitor visitor = visitorServiceImpl.searchVisitor("npatel", "password");
		visitorServiceImpl.RegisterVisitor(visitor, 1001, 10001);
		ArrayList<Event> registeredEvents = visitor.getRegisteredEvents();
		assertEquals(visitor.getRegisteredEvents().get(0).getEventid(), 1001);
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
		Visitor visitor = visitorServiceImpl.searchVisitor("jjones", "password");
		VisitorServiceImpl visitor2 = new VisitorServiceImpl();
		visitorServiceImpl.showRegisteredEvents(visitor);
		ArrayList<Object[]> showRegisteredEvents = visitor2.showRegisteredEvents(visitor);
		assertNotNull(showRegisteredEvents);
		//K - showRegisteredEvents - let eclipse change type of 'showRegisteredEvents'
		//'to ArrayList<Object[]>'
	}
	@Test
	public void testShowRegisteredEvents_Negative() {
			
		//needed VisitorService because show is in there
		//not asserting returned type - stupid - 
		//instead testing if array is null
		Visitor visitor = visitorServiceImpl.searchVisitor("ylee", "password");
		VisitorServiceImpl visitor2 = new VisitorServiceImpl();
		visitorServiceImpl.showRegisteredEvents(visitor);
		ArrayList<Object[]> showRegisteredEvents = visitor2.showRegisteredEvents(visitor);
		assertTrue(showRegisteredEvents.isEmpty());
		//K - changed it to same as positive method
	}

	/**
	 * Test case for method updateVisitorDetails
	 */
	@Test
	public void testUpdateVisitorDetails() {
		/**
		 * @TODO: Call updateVisitorDetails method by passing the visitor object which
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of updateVisitorDetails
		 */		
		Visitor visitor = visitorServiceImpl.searchVisitor("jjones", "password");
		int status = visitorServiceImpl.updateVisitorDetails(visitor);
		assertEquals(status, 1);
	}
	@Test
	public void testUpdateVisitorDetails_Negative() {
		Visitor visitor = new Visitor();
		
		try{
		int status = visitorServiceImpl.updateVisitorDetails(visitor);
		assertEquals(status, 0);
		}
		catch(Exception e){
			fail("Failed due to: "+e.getMessage());
		}
	}

	/**
	 * Test case for method unregisterEvent
	 */
	//K - modified to include sessionid
	@Test
	public void testUnregisterEvent() {
		/**
		 * @TODO: Call unregisterEvent method by passing the visitor object which can be
		 * retrieved using searchVisitor method and then asserting the returned type 
		 * of unregisterEvent
		 */		
		try{
			visitor=visitorServiceImpl.searchVisitor("npatel","password");
			visitorServiceImpl.unregisterEvent(visitor, 1001, 10001); 
			assertNull(visitor.getRegisteredEvents());
			}
			catch(Exception e){
			fail("Exception: "+e.getMessage());
			}
	}
	//K - modified to include session id - not sure if line 213 is correct
	@Test
	public void testUnregisterEvent_Exception1() {

		try{
		visitor=visitorServiceImpl.searchVisitor("npatel","password");
		visitorServiceImpl.unregisterEvent(visitor, 0, 0);
		}
		catch(Exception e){
		assertEquals("Records not updated properly",e.getMessage());
		}
		}
}
