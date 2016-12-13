package com.accenture.adf.newcodington.module13.sample;

/**
 * 
 * Topic: Error Handling using Try-Catch clause
 * 
 * Instructions: 1. Implement error handling using try-catch in the display()
 * method 2. Create a TryCatchDemo object in the main() method 3. Invoke the
 * display() method
 * 
 */

// TODO 1 Create a public class 'TryCatchDemo'
public class TryCatchDemo {
	// TODO 2 Create a public method called display() that returns void
	// a. Create a String variable and initialize it with a name
	// b. Use Integer.parseInt to convert this to a number
	// c. Print this integer
	// d. Handle the appropriate Exception(s) using the try-catch clause
	// e. Display "There is a problem with the number entered - " along with the
	// error message

	public static void display() {
		String var = "Name";
		
		try {
			int print = Integer.parseInt(var);
			System.out.println(print);
		} catch (NumberFormatException nfe) {
			System.err
			.println(nfe + " is not convertible to an Integer.");

		}
	}

	public static void main(String[] args) {
display();
	}
}
// TODO 2 Create a public method called display() that returns void
// a. Create a String variable and initialize it with a name
// b. Use Integer.parseInt to convert this to a number
// c. Print this integer
// d. Handle the appropriate Exception(s) using the try-catch clause
// e. Display "There is a problem with the number entered - " along with the
// error message

// TODO 3 Create a main method
// a. Create an object of TryCatchDemo class
// b. Use that object to call the display() method
