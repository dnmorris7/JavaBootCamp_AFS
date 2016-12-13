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

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.entity.Event;
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
	private static ResultSet rs = null;
	private ArrayList<Event> showAllEvents;
	private EventDAO dao;	

	/**
	 * Sets up database connection before other methods are executed in this class
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpDatabaseConnection() throws Exception {
		connection = FERSDataConnection.createConnection();
	}

	/**
	 * Closes the database connection after all the methods are executed
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownDatabaseConnection() throws Exception {
		connection.close();
		/**
		 * @TODO: Close connection object here  
		 */
		connection.close();
	}

	/**
	 * Sets up the objects required in other methods
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		showAllEvents = new ArrayList<Event>();
		dao = new EventDAO();
	}

	/**
	 * Deallocate the resources after execution of method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		
		showAllEvents = new ArrayList<Event>();
		dao = new EventDAO();
	}

	/**
	 * Positive test case to test the method showAllEvents
	 */
	@Test
	public void testShowAllEvents_Positive() {
		try {
			showAllEvents=dao.showAllEvents();
			int size1=6;
			assertEquals(size1,dao.showAllEvents().size());
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Test Failed due to: "+e.getMessage());
			
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
		int seats1=0;
		int seats2=-1;
		
		try{
			int eventid=1001;
			statement=connection.prepareStatement("SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?");
			statement.setInt(1, eventid);
			 rs=statement.executeQuery();
			 if(rs.next()){
				 seats1=rs.getInt(1)+1;
			 }
			dao.updateEventDeletions(eventid);
			PreparedStatement statement2=connection.prepareStatement("SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?");
			statement2.setInt(1, eventid);
			ResultSet rs2=statement2.executeQuery();
			if(rs2.next()){
				 seats2=rs2.getInt(1);
			 }
			 assertEquals(seats1,seats2);

			
		}
		
		catch(Exception e){
			fail("Test Failed due to: "+e.getMessage());
			

		}
	
		
		
		
		
		/**
		 * @TODO: Find out seats available for an event by opening a connection
		 * and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?
		 * Call the updateEventDeletions for eventId
		 * Again find out the seats available for this event
		 * testSeatsAvailableBefore should be 1 more then testSeatsAvailableAfter
		 */		
	}

	/**
	 * Exception test case for method updateEventDeletions
	 */
	@Test
	public void testUpdateEventDeletions_Exception() {
		int seats1=0;
		try{
			int eventid=9;
			dao.updateEventDeletions(eventid);
			statement=connection.prepareStatement("SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID=?");
			statement.setInt(1, eventid);
			 rs=statement.executeQuery();
			 if(rs.next()){
				 seats1=rs.getInt(1)+1;
			 }
			
			
		}
		catch(Exception e){
			assertEquals("Records not updated properly", e.getMessage());


		}
		
		/**
		 * @TODO: Call updateEventDeletions for incorrect eventid and it should
		 * throw an exception
		 */	
	}

	/**
	 * Positive test case for method updateEventNominations
	 */
	@Test
	public void testUpdateEventNominations_Positive() {
		int seats1=0;
		int seats2=-1;
		try{
			int eventid=1001;
			statement=connection.prepareStatement("SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?");
			statement.setInt(1, eventid);
			 rs=statement.executeQuery();
			 if(rs.next()){
				 seats1=rs.getInt(1)-1;
			 }
			dao.updateEventNominations(eventid);
			PreparedStatement statement2=connection.prepareStatement("SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?");
			statement2.setInt(1, eventid);
			ResultSet rs2=statement2.executeQuery();
			if(rs2.next()){
				 seats2=rs2.getInt(1);
			 }
			 assertEquals(seats1,seats2);
			
			
			
		}
		catch(Exception e){
			fail("Test Failed due to: "+e.getMessage());

		}
		
		/**
		 * @TODO: Find out seats available for an event by opening a connection
		 * and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?
		 * Call the updateEventNominations for eventId
		 * Again find out the seats available for this event
		 * testSeatsAvailableBefore should be 1 le2ss then testSeatsAvailableAfter
		 */			
	}

	/**
	 * Exception test case for method updateEventNominations
	 */
	@Test
	public void testUpdateEventNominations_Exception() {
		int seats1=0;
		try{
			
			int eventid=9;
			dao.updateEventDeletions(eventid);
			statement=connection.prepareStatement("SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?");
			statement.setInt(1, eventid);
			rs=statement.executeQuery();
			if(rs.next()){
				seats1=rs.getInt(1);
			}
			
			
		}
		catch(Exception e){
			assertEquals("Records not updated properly", e.getMessage());
			
		}
		
		/**
		 * @TODO: Call updateEventNominations for incorrect eventid and it should
		 * throw an exception
		 */	
	}

	/**
	 * Positive test case for method checkEventsofVisitor
	 */
	@Test
	public void testCheckEventsOfVisitor_Positive() {
		try{
			Visitor visitor1=new Visitor();
			boolean test1=dao.checkEventsofVisitor(visitor1, 1111);
			assertEquals(test1,false);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Test Failed due to: "+e.getMessage());
			
		}
		
		/**
		 * @TODO: Create visitor object by setting appropriate values
		 * Call checkEventsofVisitor method by passing this visitor object and
		 * valid eventId
		 * Assert the value of return type 
		 */		
	}
	@Test
	/** No Events for visitor listed*/
	public void testCheckEventsOfVisitor_Negative(){
		try{
			Visitor visitor1=new Visitor();
			boolean test1=dao.checkEventsofVisitor(visitor1, 1111);
			assertFalse(test1);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Test Failed due to: "+e.getMessage());
			
		}
	}

}
