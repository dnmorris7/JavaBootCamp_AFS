package com.accenture.adf.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.EventServiceImpl;
import com.accenture.adf.exceptions.FERSGenericException;
import com.accenture.adf.helper.FERSDataConnection;
import com.mysql.jdbc.Statement;

/**
 * Junit test class for EventDAO class
 *
 */
public class TestEventDAO {

	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet resultSet = null;
	private ArrayList<Event> showAllEvents;
	private EventDAO dao;	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/festivaldatabase";
	   //  Database credentials
	static final String USER = "root";
	 static final String PASS = "abcd1234";

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
		/**
		 * @TODO: Close connection object here  
		 */
		connection.close();//Jesse Added
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
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
	}

	/**
	 * Positive test case to test the method showAllEvents
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	//////////////////////////////////////////////Where My Work Begins//////////////////////////////////////////////////////////////////////////
	@Test
	//FERS.UT.AP491.TS.018.02 showAllEvents() Eventlist should return events
	public void testShowAllEvents_Positive() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Call showAllEvents method and assert it for
		 * size of returned type list
		 */		
		showAllEvents	= dao.showAllEvents();
		if(showAllEvents.size()>0)
		{
			assertNotNull(showAllEvents);
		}
		else fail();
	}
	

	/**
	 * Junit test case to test positive case for updateEventDeletions
	 * @throws Exception 
	 * @throws ClassNotFoundException 
	 */
	@Test	//Adds one ticket to the seats available column 
	public void testUpdateEventDeletions_Positive() throws ClassNotFoundException, Exception {//added throws
		/**
		 * @TODO: Find out seats available for an event by opening a connection
		 * and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?
		 * Call the updateEventDeletions for eventId
		 * Again find out the seats available for this event
		 * testSeatsAvailableBefore should be 1 more then testSeatsAvailableAfter
		 */		
		
		String sqlquery = "Select Seatsavailable from event where eventid = 1001";
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(DB_URL,USER,PASS);
		statement = connection.prepareStatement(sqlquery);
		ResultSet rs = statement.executeQuery();
		int asb=0;
		int asf=0;
		
	
		while(rs.next())
			{
				asb  = rs.getInt("seatsavailable");//Get the seats available before calling the updateEventDeletion Method
			}
		rs.close();
		statement.close();
		connection.close();
		
	 dao.updateEventDeletions(1001); //Changes the seats available by plus 1
	 
	 Class.forName("com.mysql.jdbc.Driver");
	 connection = DriverManager.getConnection(DB_URL,USER,PASS);
	 statement = connection.prepareStatement(sqlquery);
	 ResultSet rs1 = statement.executeQuery();
		while(rs1.next())
			{
				asf  = rs1.getInt("seatsavailable");//Get the seats avaiable After calling the updateeventdeletion method     
			}  
		rs1.close();
		if(asb+1==asf){}
		else {fail();}
		}
	/**
	 * Negative test case for method updateEventDeletions
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testUpdateEventDeletions_Negative(){ 
		/**
		 * @TODO: Call updateEventDeletions for incorrect eventid and it should
		 * throw an exception
		 */	
		boolean status = false;
		try {
			dao.updateEventDeletions(99999);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = true;
		}
		assertTrue(status);
	}

	/**
	 * Positive test case for method updateEventNominations
	 * @throws Exception 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testUpdateEventNominations_Positive() throws ClassNotFoundException, Exception {
		/**
		 * @TODO: Find out seats available for an event by opening a connection
		 * and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?
		 * Call the updateEventNominations for eventId
		 * Again find out the seats available for this event
		 * testSeatsAvailableBefore should be 1 less then testSeatsAvailableAfter
		 */			
		String sqlquery = "Select Seatsavailable from event where eventid = 1001";
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(DB_URL,USER,PASS);
		statement = connection.prepareStatement(sqlquery);
		ResultSet rs = statement.executeQuery();
		int asb=0;
		int asf=0;
		
	
		while(rs.next())
		{
	         //Retrieve by column name
	          asb  = rs.getInt("seatsavailable");//Get the seats available before calling the updateEventDeletion Method
		}
		rs.close();
		statement.close();
		connection.close();
		
	  dao.updateEventNominations(1001); //Changes the seats available by minus 1
	 Class.forName("com.mysql.jdbc.Driver");
	 connection = DriverManager.getConnection(DB_URL,USER,PASS);
	 statement = connection.prepareStatement(sqlquery);
		ResultSet rs1 = statement.executeQuery();
		while(rs1.next())
		{
	         asf  = rs1.getInt("seatsavailable");//Get the seats avaiable After calling the updateeventdeletion method
	         
		}  
		rs1.close();
		if(asb-1==asf){}
		else {fail();}
	
		
	}//close method
		
	

	/**
	 * Negative test case for method updateEventNominations
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test// Return
	public void testUpdateEventNominations_Negative() {
		/**
		 * @TODO: Call updateEventNominations for incorrect eventid and it should
		 * throw an exception
		 */	
		boolean status = false;
		try {
			dao.updateEventNominations(9999);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			status = true;
		}
		assertTrue(status);
		
	}

	/**
	 * Positive test case for method checkEventsofVisitor
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test//Test to check if the visitor has not signed up for event (Method returns a false if not signed up)
	public void testCheckEventsOfVisitor_Positive() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Create visitor object by setting appropriate values
		 * Call checkEventsofVisitor method by passing this visitor object and
		 * valid eventId
		 * Assert the value of return type 
		 */		
		Visitor v = new Visitor();
		v.setVisitorId(1001);
		
			assertEquals(true,dao.checkEventsofVisitor(v,1001));
	
		
		
	}

}
