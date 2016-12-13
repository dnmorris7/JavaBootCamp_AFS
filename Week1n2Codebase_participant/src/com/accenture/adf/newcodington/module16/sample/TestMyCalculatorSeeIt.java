package com.accenture.adf.newcodington.module16.sample;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Testcase to demonstrate unit tests for MyCalculatorSeeIt
 */
public class TestMyCalculatorSeeIt extends TestCase {

	MyCalculatorSeeIt calculator;

	protected void setUp() throws Exception {
		super.setUp();
		
		// TODO 1: Create a new MyCalculatorSeeIt instance

	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	/**
	 * Positive testcase for addNumbers method
	 */
	public void testAddNumbers_Positive() {
		
	// TODO 2: Declare two variables of type int and assign them numeric values
	// TODO 3: Invoke the assertEquals() method to test the addNumbers() method, where the 
	//         first parameter is the correct total followed by the call to addNumbers() method
	//         passing the int variables
	//         NOTE: Be sure to surround the statement with the try-catch clause for catching
	//	             any ArithmeticExceptions and use the fail() method to display the error message
	// TODO 4: Create the addNumbers() method in MyCalculatorSeeIt.java to make this test pass
	
	}

	
/**
 *  Negative jUnit testcases that checks results exceeding 8 digits for MyCalculatorSeeIt
 *  
 */
	
	// TODO 5: Create a method called testAddNumbers_Negative()
	// TODO 6: Declare two variables of type int and assign them numeric values, one of the values 
	//          should be 99999999
	// TODO 7: Invoke the assertEquals() method to test the addNumbers() method, where the 
	//          first parameter is the correct total followed by the call to addNumbers() method
	//          passing the int variables
	//          NOTE: Be sure to surround the statement with the try-catch clause for catching
	//	              any ArithmeticExceptions and use the assertEquals() method to display the error message
	// TODO 8: Modify the addNumbers() method in MyCalculatorSeeIt.java to make this test pass


}
