package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.adf.businesstier.controller.VisitorController;
import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Visitor;

/**
 * Junit test case to test the class VisitorController
 * 
 */
public class TestVisitorController {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockHttpSession session;
	private ModelAndView modelAndView;
	private VisitorController controller;
	private VisitorDAO visitorDao;

	/**
	 * Set up initial methods required before execution of every method
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		modelAndView = new ModelAndView();
		controller = new VisitorController();
		session = new MockHttpSession();
		response = new MockHttpServletResponse();
		visitorDao = new VisitorDAO();
	}

	/**
	 * Deallocate objects after execution of every method
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		
		modelAndView = null;
		controller = null;
		session =null;
		response = null;
		visitorDao = null;
	}
	/**
	 * Positive test case to test the method newVisitor
	 * Manually delete the new visitor every time you run this test.
	 */
	@Test
	public void testNewVisitor_Positive() {
		try {
			request = new MockHttpServletRequest("GET", "/newVistor.htm");

			request.setParameter("USERNAME", "ylee");
			request.setParameter("PASSWORD", "password");
			request.setParameter("FIRSTNAME", "TestVFname");
			request.setParameter("LASTNAME", "lname");
			request.setParameter("EMAIL", "mail");
			request.setParameter("PHONENO", "11111");
			request.setParameter("ADDRESS", "testAddress");
			modelAndView = controller.newVisitor(request, response);
		} catch (Exception exception) {
			fail("Exception");
		}
		assertEquals("/registration.jsp", modelAndView.getViewName());
	}

	/**
	 * Negative test case to test the method newVisitor
	 * Manually delete the new visitor every time you run this test.
	 */
	@Test
	public void testNewVisitor_Negative() {
		try {
			request = new MockHttpServletRequest("GET", "/newVistor.htm");
			
			request.setParameter("USERNAME", "bsmith");
			request.setParameter("PASSWORD", "password");
			request.setParameter("FIRSTNAME", "TestVFname");
			request.setParameter("LASTNAME", "lname");
			request.setParameter("EMAIL", "mail");
			request.setParameter("PHONENO", "11111");
			request.setParameter("ADDRESS", "testAddress");
			modelAndView = controller.newVisitor(request, response);
			assertEquals("USERNAME already exists.. please register again with different USERNAME..", modelAndView.getModel().get("REGISTRATIONSTATUSMESSAGE"));

		} catch (Exception exception) {
			fail("Exception: "+exception.getMessage());
		}
	}
	/**First Exception Test for newvisitor request=null**/
@Test
public void testNewVisitor_Exception1(){
	try {
	request = new MockHttpServletRequest("GET", "/newVistor.htm");
	
	request.setParameter("USERNAME", "ylee");
	request.setParameter("PASSWORD", "password");
	request.setParameter("FIRSTNAME", "TestVFname");
	request.setParameter("LASTNAME", "lname");
	request.setParameter("EMAIL", "mail");
	request.setParameter("PHONENO", "11111");
	request.setParameter("ADDRESS", "testAddress");
	modelAndView = controller.newVisitor(null, response);
} catch (Exception e) {
	assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder",e.getMessage());
	
}
	
}

/**second Exception Test for newvisitor response=null**/
@Test
public void testNewVisitor_Exception2(){
	try {
	request = new MockHttpServletRequest("GET", "/newVistor.htm");
	
	request.setParameter("USERNAME", "ylee");
	request.setParameter("PASSWORD", "password");
	request.setParameter("FIRSTNAME", "TestVFname");
	request.setParameter("LASTNAME", "lname");
	request.setParameter("EMAIL", "mail");
	request.setParameter("PHONENO", "11111");
	request.setParameter("ADDRESS", "testAddress");
	modelAndView = controller.newVisitor(request, null);
} catch (Exception e) {
	assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder",e.getMessage());
	
}
	
}

/**Third Exception Test for newvisitor request=null and response=null**/
@Test
public void testNewVisitor_Exception3(){
	try {
	request = new MockHttpServletRequest("GET", "/newVistor.htm");
	
	request.setParameter("USERNAME", "ylee");
	request.setParameter("PASSWORD", "password");
	request.setParameter("FIRSTNAME", "TestVFname");
	request.setParameter("LASTNAME", "lname");
	request.setParameter("EMAIL", "mail");
	request.setParameter("PHONENO", "11111");
	request.setParameter("ADDRESS", "testAddress");
	modelAndView = controller.newVisitor(null, null);
} catch (Exception e) {
	assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder",e.getMessage());
	
}
	
}

@Test
public void testSearchVisitor_Positive() {
	try {
		request = new MockHttpServletRequest("GET", "/searchVistor.htm");
		
		request.setParameter("USERNAME", "ylee");
		request.setParameter("PASSWORD", "password");
		modelAndView = controller.searchVisitor(request, response);
		
		assertEquals("/visitormain.jsp",modelAndView.getViewName());
		
	}
	catch (Exception e) {
		fail("SearchVisitor Positive falied: "+e.getMessage());
		
	}
	
	/**
	 * @TODO: Create MockHttpServletRequest object 
	 * Set request parameters for USERNAME and PASSWORD for valid values
	 * Call searchVisitor method and assert model view name 
	 */		
}

/**
 * Negative test case of invalid user for method searchVisitor
 */
@Test
public void testSearchVisitor_Negative() {
	try {
		request = new MockHttpServletRequest("GET", "/searchVistor.htm");
		
		request.setParameter("USERNAME", "justin1");
		request.setParameter("PASSWORD", "password");
		modelAndView = controller.searchVisitor(request, response);
		
		assertEquals("/index.jsp",modelAndView.getViewName());
		
	}
	catch (Exception e) {
		fail("SearchVisitor Positive falied: "+e.getMessage());
		
	}
	/**
	 * @TODO: Create MockHttpServletRequest object 
	 * Set request parameters for USERNAME and PASSWORD for invalid values
	 * Call searchVisitor method and assert model view name 
	 */		
}


/**
 * Exception1 test case for method searchVisitor request=null
 */
@Test
public void testSearchVisitor_Exception1() {
	try {
		request = new MockHttpServletRequest("GET", "/searchVistor.htm");
		
		request.setParameter("USERNAME", "justin1");
		request.setParameter("PASSWORD", "password");
		modelAndView = controller.searchVisitor(null, response);
		
		
		
	}
	catch (Exception e) {
		assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", e.getMessage());
		
	}
	
}

/**
 * Exception2 test case for method searchVisitor response=null
 */
@Test
public void testSearchVisitor_Exception2() {
	try {
		request = new MockHttpServletRequest("GET", "/searchVistor.htm");
		
		request.setParameter("USERNAME", "justin1");
		request.setParameter("PASSWORD", "password");
		modelAndView = controller.searchVisitor(request, null);
		
		
		
	}
	catch (Exception e) {
		assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", e.getMessage());
		
	}
	
}
/**
 * Exception3 test case for method searchVisitor request=null
 */
@Test
public void testSearchVisitor_Exception3() {
	try {
		request = new MockHttpServletRequest("GET", "/searchVistor.htm");
		
		request.setParameter("USERNAME", "justin1");
		request.setParameter("PASSWORD", "password");
		modelAndView = controller.searchVisitor(null, null);
		
		
		
	}
	catch (Exception e) {
		assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", e.getMessage());
		
	}
	
}


	/**
	 * Negative test case of invalid user for method searchVisitor
	 */
	@Test
	public void testSearchVisitor_Negative_InvalidUser() {
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set request parameters for USERNAME and PASSWORD for invalid values
		 * Call searchVisitor method and assert model view name 
		 */	
	}

	
	@Test
	public void testRegisterVisitor_Positive() {
		try{
			request = new MockHttpServletRequest("GET", "/eventreg.htm");
			VisitorDAO vdao=new VisitorDAO();
			Visitor visitor=vdao.searchUser("jjones", "password");
			request.setParameter("eventId", "1001");
			request.setParameter("sessionId","10001");
			request.getSession().setAttribute("VISITOR", visitor);
			request.setParameter("USERNAME","jjones");
			request.setParameter("PASSWORD","password");
			
			modelAndView=controller.registerVisitor(request,response);
			assertTrue(modelAndView.getModel().containsKey("regEvents"));
			

		}
		catch(Exception e){
			fail("Register Visitor Positive falied due to: "+e.getMessage());
		}
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		 
		 * Set request parameters for USERNAME and PASSWORD for valid values
		 * Call registerVisitor method and assert model view name 
		 */		
	}	

	/**
	 * Negaative test case for method registerVisitor
	 */
	@Test
	public void testRegisterVisitor_Negative() {
		try{
			request = new MockHttpServletRequest("GET", "/eventreg.htm");
			VisitorDAO vdao=new VisitorDAO();
			Visitor visitor=vdao.searchUser("jjones", "password");
			request.setParameter("eventId", "1001");
			request.setParameter("sessionId","10001");
			request.getSession().setAttribute("VISITOR", visitor);
			request.setParameter("USERNAME","jjones");
			request.setParameter("PASSWORD","password");
			modelAndView=controller.registerVisitor(request,response);
			assertTrue(modelAndView.getModel().containsKey("RegError"));
			

		}
		catch(Exception e){
			fail("Register Visitor Positive falied due to: "+e.getMessage());
		}
		
		/**
		 * @TODO: Call registerVisitor method by passing request object as null and 
		 * asserting the model view name
		 */		
	}
	/**
	 * Exception1 test case for method registerVisitor request=null
	 */
	@Test
	public void testRegisterVisitor_Exception1() {
		try{
			request = new MockHttpServletRequest("GET", "/eventreg.htm");
			VisitorDAO vdao=new VisitorDAO();
			Visitor visitor=vdao.searchUser("jjones", "password");
			String eventid="1001";
			request.setParameter("eventid", eventid);
			session.setAttribute("VISITOR", visitor);
			request.setParameter("USERNAME","jjones");
			request.setParameter("PASSWORD","password");
			modelAndView=controller.registerVisitor(null,response);
			

		}
		catch(Exception e){
			assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder",e.getMessage());
		}
	}
	/**
	 * Exception2 test case for method registerVisitor response=null
	 */
	@Test
	public void testRegisterVisitor_Exception2() {
		try{
			request = new MockHttpServletRequest("GET", "/eventreg.htm");
			VisitorDAO vdao=new VisitorDAO();
			Visitor visitor=vdao.searchUser("jjones", "password");
			String eventid="1001";
			request.setParameter("eventid", eventid);
			session.setAttribute("VISITOR", visitor);
			request.setParameter("USERNAME","jjones");
			request.setParameter("PASSWORD","password");
			modelAndView=controller.registerVisitor(request,null);
			

		}
		catch(Exception e){
			assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder",e.getMessage());
		}
	}
	/**
	 * Exception3 test case for method registerVisitor request=null and response =null
	 */
	@Test
	public void testRegisterVisitor_Exception3() {
		try{
			request = new MockHttpServletRequest("GET", "/eventreg.htm");
			VisitorDAO vdao=new VisitorDAO();
			Visitor visitor=vdao.searchUser("jjones", "password");
			String eventid="1001";
			request.setParameter("eventid", eventid);
			session.setAttribute("VISITOR", visitor);
			request.setParameter("USERNAME","jjones");
			request.setParameter("PASSWORD","password");
			modelAndView=controller.registerVisitor(null,null);
			

		}
		catch(Exception e){
			assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder",e.getMessage());
		}
	}
	

	@Test
	public void testUpdateVisitor_Positive() {
		try{
			request = new MockHttpServletRequest("GET", "/updatevisitor.htm");
			VisitorDAO vdao=new VisitorDAO();
			Visitor visitor=vdao.searchUser("jjones", "password");
			request.getSession().setAttribute("VISITOR", visitor);
			request.setParameter("username",visitor.getUserName());
			request.setParameter("password",visitor.getPassword());
			request.setParameter("firstname",visitor.getFirstName());
			request.setParameter("lastname",visitor.getLastName());
			request.setParameter("email",visitor.getEmail());
			request.setParameter("phoneno",visitor.getPhoneNumber());
			request.setParameter("address",visitor.getAddress());
			modelAndView=controller.updateVisitor(request, response);
			assertTrue(modelAndView.getModel().containsKey("status"));

			
		}
		catch(Exception e){
			fail("Update Visitor Positive failed due to: "+e.getMessage());
		}
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		 
		 * Set request parameters for all valid user values
		 * Call updateVisitor method and assert model view name 
		 */	
	}

	/**
	 * Negative test case for method updateVisitor
	 */
	@Test
	public void testUpdateVisitor_Negative() {
		try{
			request = new MockHttpServletRequest("GET", "/updatevisitor.htm");
			VisitorDAO vdao=new VisitorDAO();
			Visitor visitor=vdao.searchUser("justin32", "password");
			request.getSession().setAttribute("VISITOR", visitor);
			request.setParameter("username",visitor.getUserName());
			request.setParameter("password",visitor.getPassword());
			request.setParameter("firstname",visitor.getFirstName());
			request.setParameter("lastname",visitor.getLastName());
			request.setParameter("email",visitor.getEmail());
			request.setParameter("phoneno",visitor.getPhoneNumber());
			request.setParameter("address",visitor.getAddress());
			modelAndView=controller.updateVisitor(request, response);
			assertFalse(modelAndView.getModel().containsKey("status"));

			
		}
		catch(Exception e){
			fail("Update Visitor Positive failed due to: "+e.getMessage());
		}
		/**
		 * @TODO: Call updateVisitor method by passing request object as null and 
		 * asserting the model view name
		 */		
	}
	/**
	 * Exception1 test case for method updateVisitor request=null
	 */
	@Test
	public void testUpdateVisitor_Exception1() {
		try{
			request = new MockHttpServletRequest("GET", "/updatevisitor.htm");
			VisitorDAO vdao=new VisitorDAO();
			Visitor visitor=vdao.searchUser("jjones", "password");
			request.setParameter("username",visitor.getUserName());
			request.setParameter("password",visitor.getPassword());
			request.setParameter("firstname",visitor.getFirstName());
			request.setParameter("lastname",visitor.getLastName());
			request.setParameter("email",visitor.getEmail());
			request.setParameter("phoneno",visitor.getPhoneNumber());
			request.setParameter("address",visitor.getAddress());
			modelAndView=controller.updateVisitor(null, response);

			
		}
		catch(Exception e){
			assertEquals(e.getMessage(),"Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder");
		}
			
	}
	/**
	 * Exception2 test case for method updateVisitor response=null
	 */
	@Test
	public void testUpdateVisitor_Exception2() {
		try{
			request = new MockHttpServletRequest("GET", "/updatevisitor.htm");
			VisitorDAO vdao=new VisitorDAO();
			Visitor visitor=vdao.searchUser("jjones", "password");
			request.setParameter("username",visitor.getUserName());
			request.setParameter("password",visitor.getPassword());
			request.setParameter("firstname",visitor.getFirstName());
			request.setParameter("lastname",visitor.getLastName());
			request.setParameter("email",visitor.getEmail());
			request.setParameter("phoneno",visitor.getPhoneNumber());
			request.setParameter("address",visitor.getAddress());
			modelAndView=controller.updateVisitor(request, null);

			
		}
		catch(Exception e){
			assertEquals(e.getMessage(),"Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder");
		}
			
	}
	/**
	 * Exception3 test case for method updateVisitor request=null and response=null
	 */
	@Test
	public void testUpdateVisitor_Exception3() {
		try{
			request = new MockHttpServletRequest("GET", "/updatevisitor.htm");
			VisitorDAO vdao=new VisitorDAO();
			Visitor visitor=vdao.searchUser("jjones", "password");
			request.setParameter("username",visitor.getUserName());
			request.setParameter("password",visitor.getPassword());
			request.setParameter("firstname",visitor.getFirstName());
			request.setParameter("lastname",visitor.getLastName());
			request.setParameter("email",visitor.getEmail());
			request.setParameter("phoneno",visitor.getPhoneNumber());
			request.setParameter("address",visitor.getAddress());
			modelAndView=controller.updateVisitor(null, null);

			
		}
		catch(Exception e){
			assertEquals(e.getMessage(),"Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder");
		}
			
	}
	

	@Test
	public void testUnregisterEvent_Positive() {
		try{
			request = new MockHttpServletRequest("GET", "/updatevisitor.htm");
			VisitorDAO vdao=new VisitorDAO();
			Visitor visitor=vdao.searchUser("jjones", "password");
			request.getSession().setAttribute("VISITOR", visitor);
			request.setParameter("USERNAME", "jjones");
			request.setParameter("PASSWORD", "password");
			request.setParameter("eventId", "1001");
			request.setParameter("eventsessionid","10001");
			modelAndView=controller.unregisterEvent(request, response);
			assertEquals("/visitormain.jsp",modelAndView.getViewName());
		}
		
		catch(Exception e){
			fail("Unregister Event Positive failed due to: "+e.getMessage());
		}
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		 
		 * Set request parameters for all USERNAME, PASSWORD and eventId values
		 * Call unregisterEvent method and assert model view name 
		 */	
	}

	/**
	 * Exception1 test case for method unregisterEvent request=null
	 */
	@Test
	public void testUnregisterEvent_Exception1() {
		try{
			request = new MockHttpServletRequest("GET", "/updatevisitor.htm");
			VisitorDAO vdao=new VisitorDAO();
			Visitor visitor=vdao.searchUser("jjones", "password");
			request.setParameter("USERNAME", "jjones");
			request.setParameter("PASSWORD", "password");
			request.setParameter("eventId", "1001");
			modelAndView=controller.unregisterEvent(null, response);
		}
		
		catch(Exception e){
			assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder",e.getMessage());
		}
		/**
		 * @TODO: Call unregisterEvent method by passing request object as null and 
		 * asserting the model view name
		 */		
	}
	/**
	 * Exception2 test case for method unregisterEvent response=null
	 */
	@Test
	public void testUnregisterEvent_Exception2() {
		try{
			request = new MockHttpServletRequest("GET", "/updatevisitor.htm");
			VisitorDAO vdao=new VisitorDAO();
			Visitor visitor=vdao.searchUser("jjones", "password");
			request.setParameter("USERNAME", "jjones");
			request.setParameter("PASSWORD", "password");
			request.setParameter("eventId", "1001");
			modelAndView=controller.unregisterEvent(request, null);
		}
		
		catch(Exception e){
			assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder",e.getMessage());
		}
		/**
		 * @TODO: Call unregisterEvent method by passing request object as null and 
		 * asserting the model view name
		 */		
	}
	/**
	 * Exception3 test case for method unregisterEvent request=null and response=null
	 */
	@Test
	public void testUnregisterEvent_Exception3() {
		try{
			request = new MockHttpServletRequest("GET", "/updatevisitor.htm");
			VisitorDAO vdao=new VisitorDAO();
			Visitor visitor=vdao.searchUser("jjones", "password");
			request.setParameter("USERNAME", "jjones");
			request.setParameter("PASSWORD", "password");
			request.setParameter("eventId", "1001");
			modelAndView=controller.unregisterEvent(null, null);
		}
		
		catch(Exception e){
			assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder",e.getMessage());
		}
		/**
		 * @TODO: Call unregisterEvent method by passing request object as null and 
		 * asserting the model view name
		 */		
	}
	@Test
	public void testSearchEventsByName_Positive() {
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		 
		 * Set request parameters for eventname
		 * Call searchEventsByName method and assert model view name 
		 */		
		
		
		try {
			request = new MockHttpServletRequest("GET", "/searchEventByName.htm");
			VisitorDAO vdao=new VisitorDAO();
			Visitor visitor;
			visitor = vdao.searchUser("jjones", "password");
			request.getSession().setAttribute("VISITOR", visitor);
			request.setParameter("eventname", "Tour");
			
			modelAndView.setViewName("/index.jsp");	
			modelAndView=controller.searchEventsByName(request, response);
			
			assertEquals("/visitormain.jsp", modelAndView.getViewName());
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
	
		
		
	}

	/**
	 * Positive test case for search events by name catalog
	 */
	@Test
	public void testSearchEventsByNameCatalog_Positive() {
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		 
		 * Set request parameters for eventname
		 * Call searchEventsByNameCatalog method and assert model view name 
		 */		
	}

	/**
	 * Test case for show events in asc order
	 */
	@Test
	public void testShowEventsAsc() {
		/**
		 * @TODO: Create MockHttpServletRequest object Set visitor object in
		 *        VISITOR session by calling searchUser method from visitorDAO
		 *        Call showEventsAsc method and assert model view name
		 */
		try {
			request = new MockHttpServletRequest("GET", "/displayasc.htm");
			VisitorDAO vdao = new VisitorDAO();
			Visitor visitor;
			visitor = vdao.searchUser("ylee", "password");
			request.getSession().setAttribute("VISITOR", visitor);
			modelAndView=controller.showEventsAsc(request, response);
			
			assertEquals("/visitormain.jsp", modelAndView.getViewName());
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

	}

	/**
	 * Test case for show events in desc order
	 */
	@Test
	public void testShowEventsDesc() {
		/**
		 * @TODO: Create MockHttpServletRequest object Set visitor object in
		 *        VISITOR session by calling searchUser method from visitorDAO
		 *        Call showEventsDesc method and assert model view name
		 */
		try {
			request = new MockHttpServletRequest("GET", "/displaydesc.htm");
			VisitorDAO vdao = new VisitorDAO();
			Visitor visitor;
			visitor = vdao.searchUser("ylee", "password");
			request.getSession().setAttribute("VISITOR", visitor);
			modelAndView=controller.showEventsDesc(request, response);
			
			assertEquals("/visitormain.jsp", modelAndView.getViewName());
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
		
	}

	/**
	 * Test case for show events catalog asc order
	 */
	@Test
	public void testShowEventsCatalogAsc() {
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		
		 * Call showEventsCatalogAsc method and assert model view name 
		 */	
		try {
			request = new MockHttpServletRequest("GET", "/displaycatalogasc.htm");
			VisitorDAO vdao = new VisitorDAO();
			Visitor visitor;
			visitor = vdao.searchUser("ylee", "password");
			request.getSession().setAttribute("VISITOR", visitor);
			modelAndView=controller.showEventsCatalogAsc(request, response);
			
			assertEquals("/eventCatalog.jsp", modelAndView.getViewName());
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
		
	}

	/**
	 * Test case for show events catalog desc
	 */
	@Test
	public void testShowEventsCatalogDesc() {
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		
		 * Call showEventsCatalogDesc method and assert model view name 
		 */	
		
		try {
			request = new MockHttpServletRequest("GET", "/displaycatalogdesc.htm");
			VisitorDAO vdao = new VisitorDAO();
			Visitor visitor;
			visitor = vdao.searchUser("ylee", "password");
			request.getSession().setAttribute("VISITOR", visitor);
			modelAndView=controller.showEventsCatalogAsc(request, response);
			
			assertEquals("/eventCatalog.jsp", modelAndView.getViewName());
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
		
	}

	/**
	 * Negative test case for search events by name
	 */
	@Test
	public void testSearchEventsByName_Negative() {
		/**
		 * @TODO: Call searchEventsByName method by passing request object as null and 
		 * asserting the model view name
		 */		

		try {
				
			modelAndView=controller.searchEventsByName(null, response);
			
			assertEquals(null, modelAndView.getViewName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	
		
		
		
	}

	/**
	 * Negative test case for search events by name catalog
	 */
	@Test
	public void testSearchEventsByNameCatalog_Negative() {
		/**
		 * @TODO: Call searchEventsByNameCatalog method by passing request object as null and 
		 * asserting the model view name
		 */		
		
		 try {
				request = null;
	
				modelAndView=controller.searchEventsByNameCatalog(request, response);
				
				assertEquals(null, modelAndView.getViewName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		
	}

	/**
	 * Negative test case for show events in asc order
	 */
	@Test
	public void testShowEventsAsc_Negative() {
		/**
		 * @TODO: Call showEventsAsc method by passing request object as null and 
		 * asserting the model view name
		 */	

		
		 try {
				request = null;
	
				modelAndView=controller.showEventsAsc(request, response);
				
				assertEquals(null, modelAndView.getViewName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
	}

	/**
	 * Negative test case for show events in desc order
	 * 
	 */
	@Test
	public void testShowEventsDesc_Negative() {
		/**
		 * @TODO: Call showEventsDesc method by passing request object as null and 
		 * asserting the model view name
		 */		
		request = null;
		
		try {
			modelAndView=controller.showEventsDesc(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(null, modelAndView.getViewName());
	
	}

	/**
	 * Negative test case for show events catalog in asc order
	 */
	@Test
	public void testShowEventsCatalogAsc_Negative() {
		/**
		 * @TODO: Call showEventsCatalogAsc method by passing request object as null and 
		 * asserting the model view name
		 */		
		
		 try {
				request = null;
	
				modelAndView=controller.showEventsCatalogAsc(request, response);
				
				assertEquals(null, modelAndView.getViewName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		
		
	}

	/**
	 * Negative test case for show events catalog in desc order
	 */
	@Test
	public void testShowEventsCatalogDesc_Negative() {
		/**
		 * @TODO: Call showEventsCatalogDesc method by passing request object as null and 
		 * asserting the model view name
		 */		
		
		 try {
				request = null;
	
				modelAndView=controller.showEventsCatalogDesc(request, response);
				
				assertEquals(null, modelAndView.getViewName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		
	}
	
	
/*	*//**
	 * Positive test case for change password
	 *//*
	@Test
	public void testChangePassword_Positive(){
		*//**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		 
		 * Set request parameters for password
		 * Call changePassword method and assert status as success
		 *//*		
		try {
			request = new MockHttpServletRequest("GET", "/changePWD.htm");
			VisitorDAO vdao = new VisitorDAO();
			Visitor visitor;
			visitor = vdao.searchUser("ylee", "password");
			request.getSession().setAttribute("VISITOR", visitor);
			request.getSession().setAttribute("PASSWORD", visitor);
			modelAndView=controller.changePassword(request, response)(request, response);
			
			assertEquals("/eventCatalog.jsp", modelAndView.getViewName());
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
	
	*//**
	 * Negative test case for change password with password as null
	 *//*
	@Test
	public void testChangePassword_PasswordNull(){
		*//**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		 
		 * Do not set request parameters for password
		 * Call changePassword method and assert status as success
		 *//*	
	}
	
	*//**
	 * Negative test case for change password with visitor as null
	 *//*
	@Test
	public void testChangePassword_VisitorNull(){
		*//**
		 * @TODO: Create MockHttpServletRequest object 
		 * Do not set visitor object in VISITOR session by calling searchUser method from visitorDAO		 
		 * Set request parameters for password
		 * Call changePassword method and assert status as success
		 *//*		
	}*/
	
	/**
	 * Positive test case for change password
	 */
	/*@Test
	public void testChangePassword_Positive(){
		try{
			request = new MockHttpServletRequest("GET", "/changePWD.htm");
			Visitor visitor = visitorDao.searchUser("ylee", "password");	
			session.setAttribute("VISITOR", visitor);
			request.setSession(session);
			request.setParameter("password", "password3");
			modelAndView = controller.changePassword(request, response);		
		}catch(Exception exception){
			fail("Exception");
		}
		assertEquals("success", modelAndView.getModelMap().get("status"));
		request.setParameter("password", "password");
		modelAndView = controller.changePassword(request, response);
	}*/
	
	/**
	 * Negative test case for change password with password as null
	 */
	@Test
	public void testChangePassword_PasswordNull(){
		try{
			request = new MockHttpServletRequest("GET", "/changePWD.htm");
			Visitor visitor = visitorDao.searchUser("ylee", "password");			
			session.setAttribute("VISITOR", visitor);
			request.setSession(session);			
			modelAndView = controller.changePassword(request, response);		
		}catch(Exception exception){
			fail("Exception");
		}
		assertEquals("error", modelAndView.getModelMap().get("status"));
	}
	
	/**
	 * Negative test case for change password with visitor as null
	 */
	@Test
	public void testChangePassword_VisitorNull(){
		try{
			request = new MockHttpServletRequest("GET", "/changePWD.htm");
			Visitor visitor = new Visitor();			
			session.setAttribute("VISITOR", visitor);
			request.setSession(session);
			request.setParameter("password", "password");
			modelAndView = controller.changePassword(request, response);		
		}catch(Exception exception){
			fail("Exception");
		}
		assertEquals("error", modelAndView.getModelMap().get("status"));
	}
	
//  justin's test are below for password
	
	@Test
	public void testChangePassword_Positive(){
		try{
			request = new MockHttpServletRequest("GET", "/changePWD.htm");
			Visitor visitor = visitorDao.searchUser("npatel", "password");	
			request.getSession().setAttribute("VISITOR", visitor);
			
			
			request.setParameter("password", "password3");
			modelAndView = controller.changePassword(request, response);	
			assertEquals("success", modelAndView.getModelMap().get("status"));

		}
		catch(Exception exception){
			fail("Exception ");
			
		}
		
		//To make sure password is reset to the original value after testing
		finally{
			request.setParameter("password", "password");
			try {
				modelAndView = controller.changePassword(request, response);
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
  }
	//Password is same as change Password
	@Test
	public void testChangePassword_PasswordNegative(){
		try{
			request = new MockHttpServletRequest("GET", "/changePWD.htm");
			
			Visitor visitor = visitorDao.searchUser("ylee", "password");	
			session.setAttribute("VISITOR", visitor);
			request.setSession(session);			
			request.getSession().setAttribute("VISITOR", visitor);
			request.setParameter("password", "password");
			modelAndView = controller.changePassword(request, response);		
		}
		catch(Exception exception){
			fail("Exception");
		}
		
		assertEquals("error", modelAndView.getModelMap().get("status"));
   }
	//request=null exception thrown
	@Test
	public void testChangePassword_Exception1(){
		try{
			request = new MockHttpServletRequest("GET", "/changePWD.htm");
			
			Visitor visitor = visitorDao.searchUser("ylee", "password");	
			session.setAttribute("VISITOR", visitor);
			request.setSession(session);			
			request.getSession().setAttribute("VISITOR", visitor);
			request.setParameter("password", "password");
			modelAndView = controller.changePassword(null, response);		
		}
		catch(Exception e){
			assertEquals(null,e.getMessage());
		}
		
   }
	//response=null exception thrown
		@Test
		public void testChangePassword_Exception2(){
			try{
				request = new MockHttpServletRequest("GET", "/changePWD.htm");
				
				Visitor visitor = visitorDao.searchUser("ylee", "password");	
				session.setAttribute("VISITOR", visitor);
				request.setSession(session);			
				request.getSession().setAttribute("VISITOR", visitor);
				request.setParameter("password", "password");
				modelAndView = controller.changePassword(request, null);		
			}
			catch(Exception e){
				assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder",e.getMessage());
			}
			
	   }
		//request=null and response=null exception thrown
		@Test
		public void testChangePassword_Exception3(){
			try{
				request = new MockHttpServletRequest("GET", "/changePWD.htm");
				
				Visitor visitor = visitorDao.searchUser("ylee", "password");	
				session.setAttribute("VISITOR", visitor);
				request.setSession(session);			
				request.getSession().setAttribute("VISITOR", visitor);
				request.setParameter("password", "password");
				modelAndView = controller.changePassword(null, response);		
			}
			catch(Exception e){
				assertEquals(null,e.getMessage());
			}
			
	   }
// end justin's test for password
	
	
	
}
