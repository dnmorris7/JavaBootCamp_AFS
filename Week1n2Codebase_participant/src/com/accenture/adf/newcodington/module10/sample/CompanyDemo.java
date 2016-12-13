package com.accenture.adf.newcodington.module10.sample;
/**
 * Topic : Inheritance
 * 
 * Instructions:
 * 
 * 	The CompanyDemo.java file will be used during the 
 * 	Show IT tasks in the Inheritance module.
 * 	Ensure that you have created the Employee and Manager classes 
 * 	before running this program
 *	
 */
public class CompanyDemo {

	public static void main(String[] args) {
	
		// Creating a Manager object and populating the details
		Manager m1 = new Manager();
		m1.setId(101);
		m1.setEname("John");
		m1.setEmail("john.peter@accenture.com");
		m1.setNumberOfReportees(10);


		// TODO Print Manager details for m1

	}

}
