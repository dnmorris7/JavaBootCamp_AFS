package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.EventServiceImpl;
import com.accenture.adf.helper.FERSDataConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Junit test case to test class EventServiceImpl
 *
 */
public class TestEventServiceImpl {

	private List<Event> eventList;	
	private Visitor visitor;
	private EventServiceImpl eventServiceImpl;
	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet rs = null;
	/**
	 * Set up the objects required before execution of every method
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {		
		eventServiceImpl = new EventServiceImpl();
		visitor = new Visitor();
		connection = FERSDataConnection.createConnection();
	}

	/**
	 * Deallocates the objects after execution of every method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		eventList = null;
		visitor = null;
		eventServiceImpl = null;
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
	}

	/**
	 * Test case to test the method getAllEvents
	 */
	@Test
	public void testGetAllEvents() {
		List<Event> events = eventServiceImpl.getAllEvents();
		List<Event> expectedEvents = new ArrayList<Event>();
		boolean status = false;
		if (expectedEvents.size()< events.size())
		{
			status = true;
		}

	assertTrue(status);
		
		//
		//
		//
		
		/**
		 * @TODO: Call getAllEvents method and assert it for the size of returned array
		 */		
	}



	/**
	 * Test case to test the method checkEventsofVisitor
	 */
	@Test
	public void testCheckEventsofVisitor() {
		
		visitor.setVisitorId(1001);
		assertEquals(true, eventServiceImpl.checkEventsofVisitor(visitor, 1001));
		
		
		/**
		 * @TODO: Call checkEventsofVisitor and assert the returned type of this method
		 * for appropriate return type
		 */		
	}

	/**
	 * Test case to test the method updateEventDeletions
	 * @return 
	 */
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

  {
	}

}
