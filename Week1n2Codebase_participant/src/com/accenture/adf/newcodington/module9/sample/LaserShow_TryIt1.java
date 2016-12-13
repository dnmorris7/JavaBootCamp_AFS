package com.accenture.adf.newcodington.module9.sample;

/**
 * 
 * LaserShow is about a special show in the New Codington Museum
 * 
 * Topic: Demo on usage of static variables and static block
 * 
 */
public class LaserShow_TryIt1{

	private static final String showType;
	private static final String showName;
	
	static{
		showType="Multiplex ";
		showName="Laser3000";
	}
	
	public static void main(String[] args){
		System.out.println("Static Block Iniatialized: " +  showType + showName);
	}
}
	//TODO 1. Create a public class 'LaserShow_TryIt1' with a main() method
	
	//TODO 2. Create a public, static method called main() that has one parameter 
	//          that is a String array called 'args' and doesn't return any values
	
	//TODO 3. Declare a private static final string variable for show type between class declaration and main() method
	
	//TODO 4. On next line, declare a private static final string variable for show name
	
	//TODO 5. On next line, create a static block and initialize the show type and show name with appropriate values
	
	//TODO 6. Print "Static block initialized" to console from static block
	
	//TODO 7. In the main() method, print value of show type and show name to the console
	
	//TODO 8. Save the file