package com.accenture.adf.newcodington.module16.sample;

/**
 * MyCalculatorTryIt domain class
 */
public class MyCalculatorTryIt_advanced {

	/**
	 * Method to accept two integers for calculating total
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws ArithmeticException
	 */
	
	public int addNumbers(int a, int b) throws ArithmeticException {

		// Perform calculation
		int res = a + b;

		// Is the result entered numbers out of range?
		if (res > 99999999.0 || res < -99999999){
			throw new ArithmeticException("-Error-");}
		else{
		return res;}
	}


	/**
	 * Method to accept two integers for calculating difference
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws ArithmeticException
	 */
	public int subtractNumbers(int a,int b)throws ArithmeticException{
		int result= a-b;
		if(result<-99999999||result>99999999){
			 throw new ArithmeticException("Result out of Range");
		 }
		 else{
			 return result;
		 }
		
	}

	// TODO 4: Create a method called subtractNumbers with two parameters of type int
	// TODO 5: Subtract the two int parameters and pass the result to a declared variable
	// TODO 6: Return the result


	/**
	 * Method to accept two integers for calculating product
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws ArithmeticException
	 */
	public int multiplyNumbers(int a,int b)throws ArithmeticException{
		int result=a*b;
		if(result<-99999999||result>99999999){
			 throw new ArithmeticException("Result out of Range");
		 }
		 else{
			 return result;
		 }
	}

	// TODO 7: Create a method called multiplyNumbers with two parameters of type int
	// TODO 8: Multiply the two int parameters and pass the result to a declared variable
	// TODO 9: Return the result
	

	/**
	 * Method to accept two integers for calculating quotient
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws ArithmeticException
	 */
	public int divideNumbers(int a, int b)throws ArithmeticException{
		int result=a/b;
		if(result<-99999999||result>99999999){
			 throw new ArithmeticException("Result out of Range");
		 }
		 else{
			 return result;
		 }
	}

	// TODO 10: Create a method called divideNumbers with two parameters of type int
	// TODO 11: Divide the two int parameters and pass the result to a declared variable
	// TODO 12: Return the result

/**
 * Update methods to test for 8-digit boundary conditions
 * 	
 */
	
	// TODO 13: Update addNumbers() method to test if calculated result is larger than 8-digit 
	//          positive value or less than 8-digit negative value
	// TODO 14: Throw a new Arithmetic exception if the result is out of range
	
	// TODO 15: Update subtractNumbers() method to test if calculated result is larger than 8-digit 
	//          positive value or less than 8-digit negative value
	// TODO 16: Throw a new Arithmetic exception if the result is out of range
	
	// TODO 17: Update multiplyNumbers() method to test if calculated result is larger than 8-digit 
	//          positive value or less than 8-digit negative value
	// TODO 18: Throw a new Arithmetic exception if the result is out of range
	
	// TODO 19: Update divideNumbers() method to test if calculated result is larger than 8-digit 
	//          positive value or less than 8-digit negative value
	// TODO 20: Throw a new Arithmetic exception if the result is out of range
	
}
