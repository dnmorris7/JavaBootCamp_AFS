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
	//thissss

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
		modelAndView = null;
		controller = null;
		response = null;
		request = null;
	}

	/**
	 * Test case to test the positive scenario for getAvailableEvents  method
	 */
	@Test
	public void testGetAvailableEvents_Positive() {
		
		/**
		 * @TODO: Call getAvailableEvents methods and assert
		 * it for appropriate model view name
		 */		
	}

	/**
	 * Executes the negative scenario for getAvailableEvents method
	 */
	@Test
	public void testGetAvailableEvents_Negative() {
		
		/**
		 * @TODO: Call getAvailableEvents methods  by passing request as null
		 * and assert it for appropriate model view name
		 */		
	}

}
