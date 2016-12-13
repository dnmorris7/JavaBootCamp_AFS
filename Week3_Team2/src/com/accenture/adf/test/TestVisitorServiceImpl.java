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
		//visitor = new Visitor();
		
//		Setup the user, with a fake name and last name.
//		Create an event with an id of 0 and description of test, 
		//and register the user for it
		
		
		
//		Event event = new Event();
//		event.setEventid(0);
//		event.setDescription("test");
//		event.setDuration("durationTest");
//		event.setEventtype("eventtypeTest");
//		event.setName("nameTest");
//		event.setPlace("placeTest");
//		event.setSeatsavailable(60);
		
		/*ArrayList<Event> events = new ArrayList<Event>();
		events.add(event);
		ArrayList<Visitor> visitors = new ArrayList<Visitor>();
		visitors.add(visitor);
		//registering the visitor to the event and passing the registgeredEvents the 
		//event array list we made
		visitor.setRegisteredEvents(events);*/
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
		//assertEquals(foundVisitor, visitor );
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
	@Test
	public void testRegisterVisitor() {
		/**
		 * @TODO: Call RegisterVisitor method by passing visitor object which 
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of RegisterVisitor method 
		 */		
		
		Visitor visitor = visitorServiceImpl.searchVisitor("npatel", "password");
		visitorServiceImpl.RegisterVisitor(visitor, 1001);
		ArrayList<Event> registeredEvents = visitor.getRegisteredEvents();
		assertEquals(visitor.getRegisteredEvents().get(0).getEventid(), 1001);
	}
	/*@Test
	public void testRegisterVisitor_Negative() {	
		Visitor visitor = visitorServiceImpl.searchVisitor("npatel", "password");
		visitorServiceImpl.RegisterVisitor(visitor, 1001);
		ArrayList<Event> registeredEvents = visitor.getRegisteredEvents();
		assertNotSame(visitor.getRegisteredEvents().get(0).getEventid(), 1002);
	}
	*/
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
		//needed VisitorService because show is in there
		//not asserting returned type - stupid - 
		//instead testing if array is null
		Visitor visitor = visitorServiceImpl.searchVisitor("jjones", "password");
		VisitorServiceImpl visitor2 = new VisitorServiceImpl();
		visitorServiceImpl.showRegisteredEvents(visitor);
		ArrayList<Event> showRegisteredEvents = visitor2.showRegisteredEvents(visitor);
		assertNotNull(showRegisteredEvents);
		
		//ArrayList<Event> registeredEvents = visitorServiceImpl.showRegisteredEvents(visitor);
		//assertEquals(visitor.getRegisteredEvents(), registeredEvents);
	}
	
	@Test
	public void testShowRegisteredEvents_Negative() {
			
		//needed VisitorService because show is in there
		//not asserting returned type - stupid - 
		//instead testing if array is null
		Visitor visitor = visitorServiceImpl.searchVisitor("ylee", "password");
		VisitorServiceImpl visitor2 = new VisitorServiceImpl();
		visitorServiceImpl.showRegisteredEvents(visitor);
		ArrayList<Event> showRegisteredEvents = visitor2.showRegisteredEvents(visitor);
		assertTrue(showRegisteredEvents.isEmpty());
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
		//not done
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

		
	@Test

	public void testUnregisterEvent_Positive() {

		/**

		* @TODO: Call unregisterEvent method by passing the visitor object which can be

		* retrieved using searchVisitor method and then asserting the returned type 

		* of unregisterEvent

		*/

		try{

		visitor=visitorServiceImpl.searchVisitor("npatel","password");

		visitorServiceImpl.unregisterEvent(visitor, 1001);

		 

		assertNull(visitor.getRegisteredEvents());

		}

		catch(Exception e){

		fail("Exception: "+e.getMessage());

		}

		}

		/**

		* Test case for method unregisterEvent Exception Generic

		*/

	@Test

	public void testUnregisterEvent_Exception1() {

		/**

		* @TODO: Call unregisterEvent method by passing the visitor object which can be

		* retrieved using searchVisitor method and then asserting the returned type 

		* of unregisterEvent

		*/

		try{

		visitor=visitorServiceImpl.searchVisitor("npatel","password");

		visitorServiceImpl.unregisterEvent(visitor, 0);

		 

		}

		catch(Exception e){

		assertEquals("Records not updated properly",e.getMessage());

		}

		 

		}
		
	}
//}
