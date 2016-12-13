package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;

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
//30 tests
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockHttpSession session;
	private ModelAndView modelAndView;
	private VisitorController controller;
	private VisitorDAO visitorDao;

	/**
	 * Set up initial methods required before execution of every method
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		modelAndView = new ModelAndView();
		controller = new VisitorController();
		session = new MockHttpSession();
		response = new MockHttpServletResponse();
		visitorDao =  new VisitorDAO();
	}

	/**
	 * Deallocate objects after execution of every method
	 * @throws ExceptionS
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
	}

	/**
	 * Positive test case to test the method newVisitor
	 */
	@Test
	public void testNewVisitor_Positive() {
		try {
			request = new MockHttpServletRequest("GET", "/newVistor.htm");
			
			request.setParameter("USERNAME", "yleo");
			request.setParameter("PASSWORD", "password");
			request.setParameter("FIRSTNAME", "TestVFname");
			request.setParameter("LASTNAME", "lname");
			request.setParameter("EMAIL", "mail");
			request.setParameter("PHONENO", "11111");
			request.setParameter("ADDRESS", "testAddress");
			modelAndView = controller.newVisitor(request, response);
			assertEquals("User Registered Succesfully !!!", modelAndView.getModel().get("REGISTRATIONSTATUSMESSAGE"));

		} catch (Exception exception) {
			fail("Exception: "+exception.getMessage());
		}
	}
	/**Positive test cast to test method newVisitor with not all parameters**/
	
	@Test
	public void testNewVisitor_ArgMiss_Positive() {
		try {
			request = new MockHttpServletRequest("GET", "/newVistor.htm");
			
			request.setParameter("USERNAME", "no_address");
			request.setParameter("PASSWORD", "password");
			request.setParameter("FIRSTNAME", "TestVFname");
			request.setParameter("LASTNAME", "lname");
			request.setParameter("EMAIL", "mail");
			request.setParameter("PHONENO", "11111");
			//request.setParameter("ADDRESS", "testAddress");
			modelAndView = controller.newVisitor(request, response);
			assertEquals("User Registered Succesfully !!!", modelAndView.getModel().get("REGISTRATIONSTATUSMESSAGE"));

		} catch (Exception exception) {
			fail("Exception: "+exception.getMessage());
		}
	}

	/**
	 * Negative test case to test the method newVisitor
	 */
	@Test
	public void testNewVisitor_Negative(){
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
	
	
		
		/**
		 * @TODO: Call newVisitor method by passing request object as null and 
		 * asserting the model view name
		 */		
	
	
	/**
	 * Positive test case to test the method searchVisitor
	 */
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
	 * Positive test case for method registerVisitor
	 */
	@Test
	public void testRegisterVisitor_Positive() {
		try{
			request = new MockHttpServletRequest("GET", "/eventreg.htm");
			VisitorDAO vdao=new VisitorDAO();
			Visitor visitor=vdao.searchUser("jjones", "password");
			request.setParameter("eventId", "1001");
			request.getSession().setAttribute("VISITOR", visitor);
			request.setParameter("USERNAME","jjones");
			request.setParameter("PASSWORD","password");
			modelAndView=controller.registerVisitor(request,response);
			assertFalse(modelAndView.getModel().containsKey("RegError"));
			

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
	

	/**
	 * Positive test case for method updateVisitor
	 */
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
	
	
	
	
	/**
	 * Positive test case for method unregisterEvent
	 */
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
			assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder",e.getMessage());
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
				assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder",e.getMessage());
			}
			
	   }


}
