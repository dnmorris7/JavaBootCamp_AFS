
package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.adf.businesstier.controller.EventController;

/**
 * Junit test class for EventController 
 *
 */
public class TestEventController {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private ModelAndView modelAndView;
	private EventController controller;

	/**
	 * Sets up initial objects required in other methods
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		modelAndView = new ModelAndView();
		controller = new EventController();
		response = new MockHttpServletResponse();
		request = new MockHttpServletRequest("GET", "/catalog.htm");
	}

	/**
	 * Deallocate the objects after execution of every method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
	}

	/**
	 * Test case to test the positive scenario for getAvailableEvents  method
	 */
	@Test
	public void testGetAvailableEvents_Positive() {
		try {
			modelAndView = controller.getAvailableEvents(request, response);
			assertEquals("/eventCatalog.jsp",modelAndView.getViewName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Failed due to: " +e.getMessage());
		}

		/**
		 * @TODO: Call getAvailableEvents methods and assert
		 * it for appropriate model view name
		 */		
	}

	/**
	 * Executes the negative scenario for getAvailableEvents method
	 */
	@Test
	public void testGetAvailableEvents_Exception1() {
		try {
			modelAndView = controller.getAvailableEvents(null, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
				assertEquals(e.getMessage(),"Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder");
		}
		
	}

	@Test
	public void testGetAvailableEvents_Exception2() {
		try {
			modelAndView = controller.getAvailableEvents(request, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
				assertEquals(e.getMessage(),"Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder");
		}
		
	}
	@Test
	public void testGetAvailableEvents_Exception3() {
		try {
			modelAndView = controller.getAvailableEvents(null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
				assertEquals(e.getMessage(),"Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder");
		}
		
	}
	
}
