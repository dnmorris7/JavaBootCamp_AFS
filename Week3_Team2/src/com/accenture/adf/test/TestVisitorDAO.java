package com.accenture.adf.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.helper.FERSDataConnection;
import com.mysql.jdbc.PreparedStatement;

/**
 * JUnit test case for VisiqtorDAO class for testing all repository methods to
 * call database sub-routines
 * 
 */
public class TestVisitorDAO {
	private static Connection connection = null;
	private static java.sql.PreparedStatement statement = null;
	private Visitor visitor;
	private VisitorDAO visitorDAO;
	private ArrayList<Event> registeredEvents;

	/**
	 * Setting up initial objects 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpDatabaseConnection() throws Exception {
		connection = FERSDataConnection.createConnection();
	}
	@Before
	public void setUp() throws Exception {
		visitor = new Visitor();
		visitorDAO = new VisitorDAO();
		registeredEvents = new ArrayList<Event>();
	}
	@AfterClass
	public static void tearDownDatabaseConnection() throws Exception {
		connection.close();
		/**
		 * @TODO: Close connection object here  
		 */
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
	public void testInsertData_Positive(){
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
@Test
/**
 * Exception testcase for checking result exceeding 8 digits
 */
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
	public void testSearchUser_Positive(){

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
@Test
		public void RegisterVisitorToEvent_Positive(){
	try{
		visitor=visitorDAO.searchUser("bsmith", "password");
		visitorDAO.registerVisitorToEvent(visitor, 1001);
		statement=connection.prepareStatement("select visitorid from eventsignup where eventid=1001");
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


@Test
	public void testregisteredEvents_Positive(){
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

		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Update the value in this visitor object
		 * Pass this visitor object to updateVisitor method
		 * and assert the value of changed value
		 */	

@Test
	public void testUpdateVisitor_Positive() {
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

@Test
public void testUnregisterEvent_Positive(){
try{

visitor=visitorDAO.searchUser("bsmith", "password");
visitorDAO.unregisterEvent(visitor, 1001);
statement=connection.prepareStatement("select eventid from eventsignup where visitorid=?");
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
	visitorDAO.unregisterEvent(visitor, 1001);
	statement=connection.prepareStatement("select visitorid from eventsignup where eventid=1001");
	ResultSet rs=statement.executeQuery();
	int check=0;
	
	}
	catch(Exception e){
		assertEquals("Records not updated properly",e.getMessage());
	}
}
/** ChangePassword Test for Positive case*/
@Test 
public void testChangePassword_Positive(){
	int results=0;
	try{
	visitor=visitorDAO.searchUser("npatel", "password");
	visitor.setPassword("password1");
	results=visitorDAO.changePassword(visitor);
	assertTrue(results>0);
	}
	catch(Exception e){
		fail("ChangePassword Positive test failed due to Exception: "+e.getMessage());
	}
	
}
/** ChangePassword Test for Negative case*/
@Test 
public void testChangePassword_Negative(){
	int results=0;
	try{
	visitor=visitorDAO.searchUser("npatel", "password1");
	visitor.setPassword("password1");
	results=visitorDAO.changePassword(visitor);
	assertTrue(results==-10);
	}
	catch(Exception e){
		fail("ChangePassword Positive test failed due to Exception: "+e.getMessage());
	}
	finally{
		try{
			visitor.setPassword("password");
			results=visitorDAO.changePassword(visitor);
		}
		catch(Exception e){
			
		}
	}
	
}
/** ChangePassword Test for Exception case*/
@Test 
public void testChangePassword_Exception(){
	int results=0;
	try{
		visitor=null;
	results=visitorDAO.changePassword(visitor);
	assertTrue(results==-1);
	}
	catch(Exception e){
		fail("ChangePassword Positive test failed due to Exception: "+e.getMessage());
	}
	
}

		
}
