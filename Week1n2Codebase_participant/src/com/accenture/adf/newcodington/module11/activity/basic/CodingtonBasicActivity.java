package com.accenture.adf.newcodington.module11.activity.basic;


/** 
 * CODINGTON class for displaying information about Rides hosted in Park and Zoo
 * The code here depicts how a parent class variable can be used to manipulate objects of various subclasses classes
 * also, how it can  invoke methods on an child object without knowing that object’s type
 */
public class CodingtonBasicActivity {
	
	/**
	 * 
	 * Topic: Polymorphism in Java
	 * 
	 * Instructions:
	 * 
	 * 1. Call assignRideCategory method of Park class
	 * 2. Display RidesDetails by calling getRideDetails() method in SYSOUT <br/>
	 * 3. Call assignRideCategory method of Zoo class
	 * 4. Display RidesDetails by calling getRideDetails() method in SYSOUT
	 */ 
	//Main method for entry point of CodingtonBasic program
	public static void main(String[] args) {
		
		//RIDESHOSTING interface reference assigned to a Park object
		RidesHosting rides1 = new Park(); 
		
		// TODO 1 - Call assignRideCategory method of the Park object using the variable rides1 
		
		// TODO 2 - Display RidesDetails by calling getRideDetails() method in SYSOUT
		
		
		
		//RIDESHOSTING interface reference assigned to a Zoo object		
		RidesHosting rides2 = new Zoo(); 
		
		// TODO 3 - Call assignRidesCategory method of the Zoo object using the variable rides2
		
		// TODO 4 - Display RidesDetails by calling getRideDetails() method in SYSOUT	
	}

}
