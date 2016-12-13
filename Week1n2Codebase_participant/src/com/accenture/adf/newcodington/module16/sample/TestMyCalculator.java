package com.accenture.adf.newcodington.module16.sample;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Testcase to demonstrate unit tests for MyCalculatorSeeIt
 */
public class TestMyCalculator extends TestCase {

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

	// TODO 5: Create a method called testSubtractNumbers_Positive()
	//         HINT: Can copy the testAddNumbers_Positive() method and refactor; be sure to 
	//               include the @Test annotation
	
	// TODO 6: Declare two variables of type int and assign them numeric values
	// TODO 7: Invoke the assertEquals() method to test the subtractNumbers() method, where the 
	//         first parameter is the correct calculation followed by the call to subtractNumbers() method
	//         passing the int variables
	// TODO 8: Create the subtractNumbers() method in MyCalculatorSeeIt.java to make this test pass 
	

	// TODO  9: Create a method called testMultiplyNumbers_Positive()
	//          NOTE: Be sure to include the @Test annotation
	
	// TODO 10: Declare two variables of type int and assign them numeric values
	// TODO 11: Invoke the assertEquals() method to test the multiplyNumbers() method, where the 
	//          first parameter is the correct calculation followed by the call to multiplyNumbers() method
	//          passing the int variables
	// TODO 12: Create the multiplyNumbers() method in MyCalculatorSeeIt.java to make this test pass

	
	// TODO 13: Create a method called testDivideNumbers_Positive()
	//          NOTE: Be sure to include the @Test annotation
	
	// TODO 14: Declare two variables of type int and assign them numeric values
	// TODO 15: Invoke the assertEquals() method to test the divideNumbers() method, where the 
	//          first parameter is the correct calculation followed by the call to divideNumbers() method
	//          passing the int variables
	// TODO 16: Create the divideNumbers() method in MyCalculatorSeeIt.java to make this test pass

	
/**
 *  Negative jUnit testcases that checks results exceeding 8 digits for MyCalculatorSeeIt
 *  
 */
	
	// TODO 17: Create a method called testAddNumbers_Negative()
	// TODO 18: Declare two variables of type int and assign them numeric values, one of the values 
	//          should be 99999999
	// TODO 19: Invoke the assertEquals() method to test the addNumbers() method, where the 
	//          first parameter is the correct total followed by the call to addNumbers() method
	//          passing the int variables
	//          NOTE: Be sure to surround the statement with the try-catch clause for catching
	//	              any ArithmeticExceptions and use the assertEquals() method to display the error message
	// TODO 20: Modify the addNumbers() method in MyCalculatorSeeIt.java to make this test pass


	// TODO 21: Create a method called testSubtractNumbers_Negative()
	// TODO 22: Declare two variables of type int and assign them numeric values, one of the values 
	//          should be -99999999
	// TODO 23: Invoke the assertEquals() method to test the subtractNumbers() method, where the 
	//          first parameter is the correct calculation followed by the call to subtractNumbers() method
	//          passing the int variables
	// TODO 24: Modify the subtractNumbers() method in MyCalculatorSeeIt.java to make this test pass


	// TODO 25: Create a method called testMultiplyNumbers_Negative()
	// TODO 26: Declare two variables of type int and assign them numeric values that multiplied
	//          together should exceed 8 digits
	// TODO 27: Invoke the assertEquals() method to test the multiplyNumbers() method, where the 
	//          first parameter is the correct calculation followed by the call to multiplyNumbers() method
	//          passing the int variables
	// TODO 28: Modify the multiplyNumbers() method in MyCalculatorSeeIt.java to make this test pass

	

	// TODO 29: Create a method called testMultiplyNumbers_Negative()
	// TODO 30: Declare two variables of type int and assign them numeric values whose result when    
	//           divided should exceed 8 digits
	// TODO 31: Invoke the assertEquals() method to test the divideNumbers() method, where the 
	//          first parameter is the correct calculation followed by the call to divideNumbers() method
	//          passing the int variables
	// TODO 32: Modify the divideNumbers() method in MyCalculatorSeeIt.java to make this test pass

}
