package com.accenture.adf.newcodington.module7.activity;

/**
 * 
 * Travel Pass Activity is about verifying ticket IDs for an event in New Codington
 * 
 * Topic: Activity on error handling using assert
 * 
 * Instructions:
 * Copy and paste the code for 'EventPass_TryIt1' after all the TODO's and then make the following changes
 * 
 */

	//TODO 1. Change the class name from 'EventPass_TryIt1' to 'EventPass_Activity1'
	
	//TODO 2. Declare a private static final short variable for max available tickets that can be issued between class declaration and main() method	
	//		  a. Initialize max available to 500
	
	//TODO 3. Create a method to verify the following preconditions using assertions and on assertion failure print appropriate message to the console
	// 		  a. check if number of tickets is greater than zero and on failure print "Number of tickets should be greater than zero" message
	// 		  b. check if number of tickets is equal to the sum of number of children and number of adults and on failure 
	// 			print "Number of tickets issued should match number of children and number of adults attending the event" message
	
    //TODO 4. Create a method to verify the following postconditions called containsAll() that has ticket ID array as the parameter
    //        a. check for ticket ID's are less than maximum number of tickets that can be issued
    //        b. Move the do..while loop in to the method created to verify postconditions

    //TODO 5. Refactor the code that generates the ticket IDs into a new method called generateTicketID() 
    //        that will contain the following parameters: number of tickets, number of children
    //        number of adults, and ticket ID array that will also be the return type
    //        a. Invoke the checkPreconditions() method to test preconditions
    //        b. Generate ticket IDs using the for loop
    //        c. Invoke the containsAll() method to test the postconditions

    //TODO 6. In the main() method, invoke the method for ticket ID generation and return values into ticket ID array

    //TODO 7. Follow the instructions in the two TODO comments listed below
	
	//TODO 8. Save the file