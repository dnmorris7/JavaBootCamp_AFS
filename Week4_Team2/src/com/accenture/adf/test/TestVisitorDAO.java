package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.helper.FERSDataConnection;

/**
 * JUnit test case for VisitorDAO class for testing all repository methods to
 * call database sub-routines
 * 
 */
public class TestVisitorDAO {
	
	//K- added from R1 - start
	private static Connection connection = null;
	private static java.sql.PreparedStatement statement = null;
	//K- added from R1 - end

	private Visitor visitor;
	private VisitorDAO visitorDAO;
	private ArrayList<Object[]> registeredEvents;

	/**
	 * Setting up initial objects
	 * 
	 * @throws Exception
	 */
	
	//K added from R1 - start
	@BeforeClass
	public static void setUpDatabaseConnection() throws Exception {
		connection = FERSDataConnection.createConnection();
	}
	//K added from R1-  stop
	@Before
	public void setUp() throws Exception {
		visitor = new Visitor();
		visitorDAO = new VisitorDAO();
		registeredEvents = new ArrayList<Object[]>();
	}

	/**
	 * Deallocating objects after execution of every method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
	}

	/**
	 * Test case for method insertData
	 */
	@Test
	public void testInsertData() {
		/**
		 * @TODO: Create visitor object by setting appropriate values
		 * Call insertData method by passing this visitor object
		 * Search this new visitor object by calling searchUser method
		 * Assert the values of username
		 */		
		boolean result=false;
		try{
			visitor.setEmail("inserttest@email.com");
			visitor.setPassword("password");
			visitor.setUserName("insertpos");
			visitor.setFirstName("Insert");
			visitor.setLastName("Positive");
			visitor.setPhoneNumber("7035678934");
			visitor.setVisitorId(1010);
			 result=visitorDAO.insertData(visitor);
			Visitor check=new Visitor();
			check=visitorDAO.searchUser("insertpos","password");
			assertEquals(check.getUserName(),"insertpos");
		}
		catch(Exception e){
			fail("Test InsertData Positive failed due to: "+e.getMessage()+" Insert result: "+result);
		}
	}	

	@Test
	/**
	 * Negative testcase for checking result exceeding 8 digits
	 */
	public void testInsertData_Negative() {
		boolean result=false;
		try{
			visitor.setEmail("inserttest@email.com");
			visitor.setPassword("password");
			visitor.setUserName("insertpos");
			visitor.setFirstName("Insert");
			visitor.setLastName("Positive");
			visitor.setPhoneNumber("7035678934");
			visitor.setVisitorId(1010);
			result=visitorDAO.insertData(visitor);
			Visitor check=new Visitor();
			check=visitorDAO.searchUser("insertpos","password");
			assertFalse(result);
		}
		catch(Exception e){
			fail("Test InsertData Positive failed due to: "+e.getMessage()+" Insert result: "+result);
		}
	}
	
	public void testInsertData_Exception() {
		boolean result=false;
		try{

		result=visitorDAO.insertData(visitor);

		}
		catch(Exception e){
		assertEquals("Visitor "+visitor.getUserName()+" details not inserted into database",e.getMessage());
		}
		}
	
	/**
	 * Test case for method searchUser
	 */
	@Test
	public void testSearchUser_Positive() {
		/**
		 * @TODO: Call searchUser method for valid values of username
		 * and password and assert the value of username for the returned type of method
		 */		
		try{
			visitor=visitorDAO.searchUser("bsmith", "password");
			assertEquals(visitor.getFirstName(),"Bob");
						
					}
					catch(Exception e){
						fail("Test failed due database: "+e.getMessage());
					}
				}
	@Test
	/**
	 * Negative testcase for checking result exceeding 8 digits
	 */
public void testSearchUser_Negative() {
try{
	visitor=visitorDAO.searchUser("jordey", "password");
	assertEquals(visitor.getFirstName(),"");
				
			}
			catch(Exception e){
				fail("Test failed due database: "+e.getMessage());
			}
}

	/**
	 * Test case for method registerVisitorToEvent
	 */
	//K - had to change method to incorporate sessionid
	@Test
	public void testRegisterVisitorToEvent_Positive() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to registerVisitorToEvent method
		 * and assert the value
		 */		
		try{
			visitor=visitorDAO.searchUser("bsmith", "password");
			visitorDAO.registerVisitorToEvent(visitor, 1001, 10001);
			statement=connection.prepareStatement("select visitorid from eventsessionsignup where eventid=1001");
			ResultSet rs=statement.executeQuery();
			int check=0;
			while(rs.next()){
				check=rs.getInt(1);
			}
			assertEquals(visitor.getVisitorId(),check);
		}
		catch(Exception e){
			fail("RegisterVisitortoEvent Positive failed due to: "+e.getMessage());
		}
	}	

	/**
	 * Test case for method registeredEvents
	 */
	@Test
	public void testRegisteredEvents_Positive() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to registeredEvents method
		 * and assert the value
		 */		
		try{
			visitor=visitorDAO.searchUser("bsmith", "password");
			registeredEvents=visitorDAO.registeredEvents(visitor);
			assertFalse(registeredEvents.isEmpty());
		}
		catch(Exception e){
			fail("TestRegisteredEvents Positive failed due to: "+e.getMessage());
		}
	}

	@Test
	public void testregisteredEvents_Negative(){
	try{
		visitor=visitorDAO.searchUser("ylee", "password");
		registeredEvents=visitorDAO.registeredEvents(visitor);
		assertTrue(registeredEvents.isEmpty());
		
	}
	catch(Exception e){
		fail("TestRegisteredEvents Positive failed due to: "+e.getMessage());
	}
	}

	/**
	 * Test case for method updateVisitor
	 */
	@Test
	public void testUpdateVisitor_Positive() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Update the value in this visitor object
		 * Pass this visitor object to updateVisitor method
		 * and assert the value of changed value
		 */		
		try{
			visitor=visitorDAO.searchUser("bsmith", "password");
			visitor.setPhoneNumber("7038675309");
			visitorDAO.updateVisitor(visitor);
			
			Visitor check=visitorDAO.searchUser("bsmith", "password");
			assertEquals(visitor.getPhoneNumber(),check.getPhoneNumber());
		}
		
		catch(Exception e){
			fail("Test Failed due to: "+e.getMessage());
		}
	}
	
	@Test
	public void testUpdateVisitor_Negative() {
		try{
			int status=visitorDAO.updateVisitor(visitor);
			
			assertEquals(status,0);
		}
		catch(Exception e){
			fail("Test Failed due to: "+e.getMessage());
		}
	}

	/**
	 * Test case for method registeredEvents
	 */
	//K - modified to incorporate sessionid
	@Test
	public void testUnregisterEvent_Positive() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to unregisterEvent method
		 * and assert the value
		 */		
		try{

			visitor=visitorDAO.searchUser("bsmith", "password");
			visitorDAO.unregisterEvent(visitor, 1001, 10001);
			statement=connection.prepareStatement("select eventid from eventsessionsignup where visitorid=?");
			statement.setInt(1, visitor.getVisitorId());
			ResultSet rs=statement.executeQuery();
			int check=0;
			while(rs.next()){
				check=rs.getInt(1);
			}
			assertEquals(0,check);

			}
			catch(Exception e){
				fail("UnregisterEvent Positive failed due to: "+e.getMessage());
			}
	}
	
	@Test
	public void testUnregisterEvent_Exception(){
	try{

		visitor=visitorDAO.searchUser("bsmith", "password");
		visitorDAO.unregisterEvent(visitor, 1001, 10001);
		statement=connection.prepareStatement("select visitorid from eventsignup where eventid=1001");
		ResultSet rs=statement.executeQuery();
		int check=0;
	}
	catch(Exception e){
		assertEquals("Records not updated properly",e.getMessage());
	}
}
	/**
	 * Test case for method change password
	 */
	/*@Test
	public void testChangePassword_VisitorNull() {
		*//**
		 * @TODO: Call changePassword method by passing visitor object as null
		 *//*		
	}*/
	
	/**
	 * Test case for method change password
	 */
	//K - left as is even though R1 had pos, neg, and exception
	@Test
	public void testChangePassword_VisitorNull() {
		try {
			visitor = null;
			visitorDAO.changePassword(visitor);
		} catch (SQLException exception) {
			fail("SQL Exception");
		} catch (ClassNotFoundException exception) {
			fail("Class Not Found Exception");
		} catch (Exception exception) {
			fail("NULL Exception");
		}
	}

}
