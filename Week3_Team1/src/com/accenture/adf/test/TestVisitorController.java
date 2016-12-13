package com.accenture.adf.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.adf.businesstier.controller.VisitorController;
import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Event;
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
		modelAndView = null;
		controller = null;
		session = null;
		response = null;
		visitorDao = null;
	}

	/**
	 * Positive test case to test the method newVisitor
	 */
	@Test
	public void testNewVisitor_Positive() {
		try {
			request = new MockHttpServletRequest("GET", "/newVisitor.htm");

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
		// assertTrue(modelAndView.getModel().containsValue("User Registered Succesfully !!!"));
		assertTrue(modelAndView
				.getModel()
				.containsValue(
						"USERNAME already exists.. please register again with different USERNAME.."));
		assertEquals("/registration.jsp", modelAndView.getViewName());
	}

	/**
	 * Negative test case to test the method newVisitor
	 */
	@Test
	public void testNewVisitor_Negative() {
		/**
		 * @TODO: Call newVisitor method by passing request object as null and
		 *        asserting the model view name
		 */
		boolean gotException = false;
		try {
			modelAndView = controller.newVisitor(null, response);
		} catch (Exception exception) {
			gotException = true;
			// fail("Exception");
		}
		assertTrue(gotException);
	}

	/**
	 * Positive test case to test the method searchVisitor
	 */
	@Test
	public void testSearchVisitor_Positive() {
		/**
		 * @TODO: Create MockHttpServletRequest object Set request parameters
		 *        for USERNAME and PASSWORD for valid values Call searchVisitor
		 *        method and assert model view name
		 */
		try {
			request = new MockHttpServletRequest("GET", "/searchVisitor.htm");

			request.setParameter("USERNAME", "ylee");
			request.setParameter("PASSWORD", "password");
			modelAndView = controller.searchVisitor(request, response);
		} catch (Exception exception) {
			// exception.printStackTrace();
			fail("Exception");
		}
		assertEquals("/visitormain.jsp", modelAndView.getViewName());
	}

	/**
	 * Negative test case of invalid user for method searchVisitor
	 */
	@Test
	public void testSearchVisitor_Negative_InvalidUser() {
		/**
		 * @TODO: Create MockHttpServletRequest object Set request parameters
		 *        for USERNAME and PASSWORD for invalid values Call
		 *        searchVisitor method and assert model view name
		 */
		try {
			request = new MockHttpServletRequest("GET", "/searchVisitor.htm");

			request.setParameter("USERNAME", "a");
			request.setParameter("PASSWORD", "b");
			modelAndView = controller.searchVisitor(request, response);
		} catch (Exception exception) {
			// exception.printStackTrace();
			fail("Exception");
		}
		assertEquals("/index.jsp", modelAndView.getViewName());
	}

	/**
	 * Negative test case for method searchVisitor
	 */
	@Test
	public void testSearchVisitor_Negative() {
		/**
		 * @TODO: Call searchVisitor method by passing request object as null
		 *        and asserting the model view name
		 */
		boolean gotException = false;
		try {
			modelAndView = controller.searchVisitor(null, null);
		} catch (Exception e) {
			gotException = true;
		}
		assertTrue(gotException);

	}

	/**
	 * Positive test case for method registerVisitor
	 */
	@Test
	public void testRegisterVisitor_Positive() {
		/**
		 * @TODO: Create MockHttpServletRequest object Set visitor object in
		 *        VISITOR session by calling searchUser method from visitorDAO
		 *        Set request parameters for USERNAME and PASSWORD for valid
		 *        values Call registerVisitor method and assert model view name
		 */
		Visitor v = null;
		try {
			request = new MockHttpServletRequest("GET", "/eventreg.htm");
			v = visitorDao.searchUser("ylee", "password");
			request.getSession().setAttribute("VISITOR", v);
			request.setParameter("USERNAME", "ylee");
			request.setParameter("PASSWORD", "password");
			request.setParameter("eventId", "1001");
			modelAndView = controller.registerVisitor(request, response);
		} catch (Exception exception) {
			exception.printStackTrace();
			fail("Exception");
		}
		assertFalse(modelAndView.getModel().containsKey("RegError"));
	}

	/**
	 * Negative test case for method registerVisitor Invalid eventId
	 */
	@Test
	public void testRegisterVisitor_Negative() {
		/**
		 * @TODO: Create MockHttpServletRequest object Set visitor object in
		 *        VISITOR session by calling searchUser method from visitorDAO
		 *        Set request parameters for USERNAME and PASSWORD for valid
		 *        values Call registerVisitor method and assert model view name
		 */
		Visitor v = null;
		try {
			request = new MockHttpServletRequest("GET", "/eventreg.htm");
			v = visitorDao.searchUser("ylee", "password");
			request.getSession().setAttribute("VISITOR", v);
			request.setParameter("username", "ylee");
			request.setParameter("password", "password");
			request.setParameter("eventId", "0");
			modelAndView = controller.registerVisitor(request, response);
		} catch (Exception exception) {
			exception.printStackTrace();
			fail("Exception");
		}
		assertTrue(modelAndView.getModel().containsKey("RegError"));
	}

	/**
	 * Negaative test case for method registerVisitor
	 */
	@Test
	public void testRegisterVisitor_Exception() {
		/**
		 * @TODO: Call registerVisitor method by passing request object as null
		 *        and asserting the model view name
		 */
		boolean gotException = false;
		try {
			modelAndView = controller.registerVisitor(null, null);
		} catch (Exception e) {
			gotException = true;
		}
		assertTrue(gotException);
	}

	/**
	 * Positive test case for method updateVisitor
	 */
	@Test
	public void testUpdateVisitor_Positive() {
		/**
		 * @TODO: Create MockHttpServletRequest object Set visitor object in
		 *        VISITOR session by calling searchUser method from visitorDAO
		 *        Set request parameters for all valid user values Call
		 *        updateVisitor method and assert model view name
		 */
		Visitor v = null;
		try {
			request = new MockHttpServletRequest("GET", "/updatevisitor.htm");
			v = visitorDao.searchUser("ylee", "password");
			request.getSession().setAttribute("VISITOR", v);
			request.setParameter("username", "ylee");
			request.setParameter("password", "password");
			request.setParameter("firstname", "Mr.");
			request.setParameter("lastname", "Dude");
			request.setParameter("email", "my@gmail.com");
			request.setParameter("phoneno", "91919199191");
			request.setParameter("address", "in a box");
			// request.setSession(session);
			modelAndView = controller.updateVisitor(request, response);
		} catch (Exception exception) {
			exception.printStackTrace();
			fail("Exception");
		}
		assertTrue(modelAndView.getModel().containsKey("status"));
	}

	/**
	 * Negative test case for method updateVisitor
	 */
	@Test
	public void testUpdateVisitor_Negative() {

		Visitor v = null;
		try {
			request = new MockHttpServletRequest("GET", "/updatevisitor.htm");
			v = visitorDao.searchUser("ylee", "password");
			request.getSession().setAttribute("VISITOR", v);
			request.setAttribute("USERNAME", "ylee");
			request.setAttribute("PASSWORD", "password");
			request.setParameter("firstname", "Mr.");
			request.setParameter("lastname", "");
			request.setParameter("email", "gmail.com");
			modelAndView = controller.updateVisitor(request, response);
		} catch (Exception exception) {
			exception.printStackTrace();
			fail("Exception");
		}
		assertTrue(modelAndView.getModel().containsKey("updatestatus"));
	}

	/**
	 * Exception test case for method updateVisitor
	 */
	@Test
	public void testUpdateVisitor_Exception() {
		/**
		 * @TODO: Call updateVisitor method by passing request object as null
		 *        and asserting the model view name
		 */
		boolean gotException = false;
		try {
			modelAndView = controller.updateVisitor(null, null);
		} catch (Exception e) {
			gotException = true;
		}
		assertTrue(gotException);
	}

	/**
	 * Positive test case for method unregisterEvent
	 */
	@Test
	public void testUnregisterEvent_Positive() {
		/**
		 * @TODO: Create MockHttpServletRequest object Set visitor object in
		 *        VISITOR session by calling searchUser method from visitorDAO
		 *        Set request parameters for all USERNAME, PASSWORD and eventId
		 *        values Call unregisterEvent method and assert model view name
		 */
		Visitor v = null;
		try {
			request = new MockHttpServletRequest("GET", "/eventunreg.htm");
			v = visitorDao.searchUser("sWill", "banjo");
			request.getSession().setAttribute("VISITOR", v);
			request.setParameter("USERNAME", "sWill");
			request.setParameter("PASSWORD", "banjo");
			request.setParameter("eventId", "1001");
			modelAndView = controller.unregisterEvent(request, response);
		} catch (Exception exception) {
			exception.printStackTrace();
			fail("Exception");
		}
		assertEquals(modelAndView.getViewName(), "/visitormain.jsp");
	}

	/**
	 * Negative test case for method unregisterEvent
	 */
	@Test
	public void testUnregisterEvent_Negative() {
		/**
		 * @TODO: Call unregisterEvent method by passing request object as null
		 *        and asserting the model view name
		 */
		boolean gotException = false;
		try {
			modelAndView = controller.unregisterEvent(null, null);
		} catch (Exception e) {
			gotException = true;
		}
		assertTrue(gotException);
	}

	@Test
	public void testChangePassword_Positive() {
		try {
			request = new MockHttpServletRequest("GET", "/changePWD.htm");
			Visitor visitor = visitorDao.searchUser("ylee", "password");

			request.getSession().setAttribute("VISITOR", visitor);

			request.setParameter("password", "password3");
			modelAndView = controller.changePassword(request, response);
		} catch (Exception exception) {
			fail("Exception");
		}
		assertEquals("success", modelAndView.getModelMap().get("status"));

		// To make sure password is reset to the original value after testing
		request.setParameter("password", "password");
		try {
			modelAndView = controller.changePassword(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testChangePassword_PasswordNull() {
		try {
			request = new MockHttpServletRequest("GET", "/changePWD.htm");

			Visitor visitor = visitorDao.searchUser("ylee", "password");

			String s = null;
			session.setAttribute("VISITOR", visitor);
			request.setParameter("password", s);
			request.setSession(session);

			// TODO: Invoke changePassword() method on controller with mock
			// request and response objects are arguments
			modelAndView = controller.changePassword(request, response);
		} catch (Exception exception) {
			fail("Exception");
		}

		assertEquals("error", modelAndView.getModelMap().get("status"));
	}
}
