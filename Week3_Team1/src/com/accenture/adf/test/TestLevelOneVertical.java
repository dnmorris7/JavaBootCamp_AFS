package com.accenture.adf.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.adf.businesstier.controller.EventController;
import com.accenture.adf.businesstier.controller.VisitorController;
import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;

import com.accenture.adf.businesstier.controller.VisitorController;
import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.exceptions.FERSGenericException;

public class TestLevelOneVertical {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockHttpSession session;
	private ModelAndView modelAndView;
	private VisitorController controller;
	private EventController eController;
	private VisitorDAO visitorDao;
	private EventDAO eventDao;
	private static Logger log = Logger.getLogger(VisitorController.class);
	/**
	 * Set up initial methods required before execution of every method
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		response = new MockHttpServletResponse();
		session = new MockHttpSession();
		modelAndView = new ModelAndView();
		controller = new VisitorController();
		eController = new EventController();
		visitorDao = new VisitorDAO();
		eventDao = new EventDAO();
	}

	/**
	 * Deallocate objects after execution of every method
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		response = null;
		session = null;
		modelAndView = null;
		controller = null;
		eController = null;
		visitorDao = null;
		eventDao = null;
	}
	
	/**
	 * Positive test case to test the method newVisitor
	 */
	@Test
	public void testRegVisitor_Positive() {
		try {
			request = new MockHttpServletRequest("GET", "/newVisitor.htm");

			request.setParameter("USERNAME", "ylees");
			request.setParameter("PASSWORD", "password");
			request.setParameter("FIRSTNAME", "TestVFname");
			request.setParameter("LASTNAME", "lname");
			request.setParameter("EMAIL", "mail");
			request.setParameter("PHONENO", "11111");
			request.setParameter("ADDRESS", "testAddress");
			modelAndView = controller.newVisitor(request, response);
			assertEquals("11111", visitorDao.searchUser("ylees", "password").getPhoneNumber());
		} catch (Exception exception) {
			fail("Exception");
		}
	}
	
	/**
	 * Positive test case to test the method newVisitor
	 */
	@Test
	public void testRegVisitor_PositiveTwo() {
		try {
			request = new MockHttpServletRequest("GET", "/newVisitor.htm");

			request.setParameter("USERNAME", "yleet");
			request.setParameter("PASSWORD", "password");
			request.setParameter("FIRSTNAME", "TestVFname");
			request.setParameter("LASTNAME", "lname");
			request.setParameter("EMAIL", "mail");
			request.setParameter("PHONENO", "11111");;
			modelAndView = controller.newVisitor(request, response);
		} catch (Exception exception) {
			fail("Exception");
		}
		try {
			assertEquals("11111", visitorDao.searchUser("yleet", "password").getPhoneNumber());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	
	/**
	 * Negative test case to test the method newVisitor
	 */
	@Test
	public void testRegVisitor_Negative() {
		try {
			request = new MockHttpServletRequest("GET", "/newVisitor.htm");

			request.setParameter("USERNAME", "yleen");
			request.setParameter("PASSWORD", "password");
			request.setParameter("FIRSTNAME", "TestVFname");
			request.setParameter("LASTNAME", "lname");
			request.setParameter("EMAIL", "mail");
			request.setParameter("PHONENO", "11111");
			modelAndView = controller.newVisitor(request, response);
			assertEquals("11111", visitorDao.searchUser("yleen", "password").getPhoneNumber());
			modelAndView = controller.newVisitor(request, response);
			assertTrue(modelAndView.getModel().containsValue("USERNAME already exists.. " +
					"please register again with different USERNAME.."));
		} catch (Exception exception) {
			fail("Exception");
		}	
	}
	
	/**
	 * Exception test case to test the method newVisitor
	 */
	@Test
	public void testRegVisitor_Exception() {
		boolean gotFERS = false;
		try {
			request = new MockHttpServletRequest("GET", "/newVisitor.htm");
			modelAndView = controller.newVisitor(null, response);
			
		} catch (Exception e) {
			if (e instanceof FERSGenericException) {
				gotFERS = true;
			}
		}	
		assertTrue(gotFERS);	
	}
	
	/**
	 * Exception test case to test the method newVisitor
	 */
	@Test
	public void testRegVisitor_Exception2() {
		boolean gotFERS = false;
		try {
			request = new MockHttpServletRequest("GET", "/newVisitor.htm");

			request.setParameter("USERNAME", "yleen");
			request.setParameter("PASSWORD", "password");
			request.setParameter("FIRSTNAME", "TestVFname");
			request.setParameter("LASTNAME", "lname");
			request.setParameter("EMAIL", "mail");
			request.setParameter("PHONENO", "11111");
			modelAndView = controller.newVisitor(request, null);
		} catch (Exception e) {
			if (e instanceof FERSGenericException) {
				gotFERS = true;
			}
		}
		assertTrue(gotFERS);
	}
	
	/**
	 * Exception test case to test the method newVisitor
	 */
	@Test
	public void testRegVisitor_Exception3() {
		boolean gotFERS = false;
		try {
			request = new MockHttpServletRequest("GET", "/newVisitor.htm");
			modelAndView = controller.newVisitor(null, null);
		} catch (Exception e) {
			if (e instanceof FERSGenericException) {
				gotFERS = true;
			}
		}	
		assertTrue(gotFERS);
	}
	
	/**
	 * Exception test case to test the method newVisitor
	 */
	@Test
	public void testSearchVisitor_Positive() {
		try {
			request = new MockHttpServletRequest("GET", "/searchVisitor.htm");

			request.setParameter("USERNAME", "ylee");
			request.setParameter("PASSWORD", "password");
			modelAndView = controller.searchVisitor(request, response);
			assertEquals("/visitormain.jsp", modelAndView.getViewName());
		} catch (Exception exception) {
			fail("Exception");
		}
	}
	
	/**
	 * Negative test case of invalid user for method searchVisitor
	 */
	@Test
	public void testSearchVisitor_Negative_InvalidUser() {
		try {
			request = new MockHttpServletRequest("GET", "/searchVisitor.htm");

			request.setParameter("USERNAME", "a");
			request.setParameter("PASSWORD", "password");
			modelAndView = controller.searchVisitor(request, response);
			assertTrue(modelAndView.getModel().containsValue("Invalid Username / Password."));
			assertEquals("/index.jsp", modelAndView.getViewName());
		} catch (Exception exception) {
			// exception.printStackTrace();
			fail("Exception");
		}
	}
	
	/**
	 * Negative test case of invalid user for method searchVisitor
	 */
	@Test
	public void testSearchVisitor_Negative_InvalidPassword() {
		try {
			request = new MockHttpServletRequest("GET", "/searchVisitor.htm");

			request.setParameter("USERNAME", "bsmith");
			request.setParameter("PASSWORD", "a");
			modelAndView = controller.searchVisitor(request, response);
			assertTrue(modelAndView.getModel().containsValue("Invalid Username / Password."));
			assertEquals("/index.jsp", modelAndView.getViewName());
		} catch (Exception exception) {
			fail("Exception");
		}
	}
	
	/**
	 * Negative test case of invalid user for method searchVisitor
	 */
	@Test
	public void testSearchVisitor_Negative_EmptyValues() {
		try {
			request = new MockHttpServletRequest("GET", "/searchVisitor.htm");

			request.setParameter("USERNAME", "");
			request.setParameter("PASSWORD", "");
			modelAndView = controller.searchVisitor(request, response);
			assertTrue(modelAndView.getModel().containsValue("Invalid Username / Password."));
			assertEquals("/index.jsp", modelAndView.getViewName());
		} catch (Exception exception) {
			//fail("Exception");
			exception.printStackTrace();
		}
	}
	
	/**
	 * Exception test case to test the method newVisitor
	 */
	@Test
	public void testSearchVisitor_Exception() {
		boolean gotFERS = false;
		try {
			request = new MockHttpServletRequest("GET", "/searchVisitor.htm");
			modelAndView = controller.searchVisitor(null, response);
		} catch (Exception e) {
			if (e instanceof FERSGenericException) {
				gotFERS = true;
			}
		}	
		assertTrue(gotFERS);
	}
	
	/**
	 * Exception test case to test the method newVisitor
	 */
	@Test
	public void testSearchVisitor_Exception2() {
		boolean gotFERS = false;
		try {
			request.setParameter("USERNAME", "bsmith");
			request.setParameter("PASSWORD", "password");
			request = new MockHttpServletRequest("GET", "/searchVisitor.htm");
			modelAndView = controller.searchVisitor(request, null);
		} catch (Exception e) {
			if (e instanceof FERSGenericException) {
				gotFERS = true;
			}
		}	
		assertTrue(gotFERS);
	}
	
	/**
	 * Exception test case to test the method newVisitor
	 */
	@Test
	public void testSearchVisitor_Exception3() {
		boolean gotFERS = false;
		try {
			request = new MockHttpServletRequest("GET", "/searchVisitor.htm");
			modelAndView = controller.searchVisitor(null, null);
		} catch (Exception e) {
			if (e instanceof FERSGenericException) {
				gotFERS = true;
			}
		}	
		assertTrue(gotFERS);
	}
}
