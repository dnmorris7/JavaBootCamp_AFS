package com.accenture.adf.newcodington.module11.activity.advanced;


/**
 * Codington class for displaying information about Rides hosted in Park and Zoo
 * The code here depicts how a parent class variable can be used to manipulate objects of various subclasses classes
 * also, how it can  invoke methods on an child object without knowing that object’s type
 */
public class CodingtonAdvancedActivity {
	/**
	 * 
	 * Topic: Polymorphism in Java
	 * 
	 * Instructions:
	 * 
	 * 1. Call assignRideCategory method of Park class <br/>
	 * 2. Display RidesDetails by calling getRideDetails() <br/>
	 * 3. Call assignRideCategory method of Zoo class <br/>
	 * 4. Display RidesDetails by calling getRideDetails() <br/> 
	 */ 
	//Main method for entry point of CodingtonAdvanced program

	public static void main(String[] args) {
		
		//RIDESHOSTING interface for implementing PARK towards POLYMORPHISM
		RidesHosting rides1; // TODO assign PARK Object
		 
		// TODO 1 - Call assignRideCategory method using the rides1 instance
		
		// TODO 2 - Display RidesDetails by calling getRideDetails() method	using System.out.println method	
		
		// TODO 3 - Call assignRideLocation method using the rides1 instance
		
		// TODO 4 - Display RidesLocation by calling getRideLocation() method using System.out.println method				
		
		//RIDESHOSTING interface for implementing ZOO towards POLYMORPHISM		
		RidesHosting rides2; // TODO assign ZOO Object
		
		// TODO 5 - Call assignRideCategory method using the rides2 instance
		
		// TODO 6 - Display RidesDetails by calling getRideDetails() method	using System.out.println method
		
		// TODO 7 - Call assignRideLocation method using the rides2 instance
		
		// TODO 8 - Display RidesLocation by calling getRideLocation() method using System.out.println method
	
	}

}
