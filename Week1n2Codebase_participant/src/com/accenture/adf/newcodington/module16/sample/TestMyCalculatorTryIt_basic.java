package com.accenture.adf.newcodington.module16.sample;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Testcase to demonstrate unit tests for MyCalculatorTryIt
 */
public class TestMyCalculatorTryIt_basic extends TestCase {

	MyCalculatorTryIt_basic calculator;

	protected void setUp() throws Exception {
		super.setUp();
		
		// TODO 1: Create a new MyCalculatorTryIt_basic instance

	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	/**
	 * Positive testcase for addNumbers method
	 */
	public void testAddNumbers_Positive() {
		int num1 = 23;
		int num2 = 34;
		try {
			assertEquals(57, calculator.addNumbers(num1, num2));
		} catch (ArithmeticException ex) {
			fail("No exception should be thrown");
		}
	}

	// TODO 2: Create a method called testSubtractNumbers_Positive()
	//         HINT: Can copy the testAddNumbers_Positive() method and refactor; be sure to 
	//               include the @Test annotation
	
	// TODO 3: Declare two variables of type int and assign them numeric values
	// TODO 4: Invoke the assertEquals() method to test the subtractNumbers() method, where the 
	//         first parameter is the correct calculation followed by the call to subtractNumbers() method
	//         passing the int variables
	// TODO 5: Create the subtractNumbers() method in MyCalculatorSeeIt.java to make this test pass 
	

	// TODO  6: Create a method called testMultiplyNumbers_Positive()
	//          NOTE: Be sure to include the @Test annotation
	
	// TODO 7: Declare two variables of type int and assign them numeric values
	// TODO 8: Invoke the assertEquals() method to test the multiplyNumbers() method, where the 
	//          first parameter is the correct calculation followed by the call to multiplyNumbers() method
	//          passing the int variables
	// TODO 9: Create the multiplyNumbers() method in MyCalculatorSeeIt.java to make this test pass

	
	// TODO 10: Create a method called testDivideNumbers_Positive()
	//          NOTE: Be sure to include the @Test annotation
	
	// TODO 11: Declare two variables of type int and assign them numeric values
	// TODO 12: Invoke the assertEquals() method to test the divideNumbers() method, where the 
	//          first parameter is the correct calculation followed by the call to divideNumbers() method
	//          passing the int variables
	// TODO 13: Create the divideNumbers() method in MyCalculatorSeeIt.java to make this test pass

}
