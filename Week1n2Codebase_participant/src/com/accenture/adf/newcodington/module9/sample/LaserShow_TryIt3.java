package com.accenture.adf.newcodington.module9.sample;

/**
 * 
 * LaserShow is about a special show in the New Codington Museum
 * 
 * Topic: Demo on usage of parameterized constructor and local variables
 * 
 * Copy and paste the code for 'LaserShow_TryIt2' after all the TODO's and make the following changes
 * 
 */
public class LaserShow_TryIt3{
private String showName;
private boolean gogglesRequired;
private double duration;
private int numSeats;



public LaserShow_TryIt3(){
	System.out.println("Default Constructor Invoked.");	
	showName="[Show Name]";
	gogglesRequired=false;
	duration = 999;
	numSeats = 150;
}



public LaserShow_TryIt3(String showName, boolean gogglesRequired,
		double duration, int numSeats) {
	super();

	this.showName = showName;
	this.gogglesRequired = gogglesRequired;
	this.duration = duration;
	this.numSeats = numSeats;
	System.out.println("Parametized Constructor Invoked: \r" + "Show Name: "+ this.showName +
			" | Goggle Requirement: " + this.gogglesRequired + " | Duration: " + this.duration +" minutes. | Number of Seats: " + this.numSeats);
}


public static void main(String[] args) {
	LaserShow_TryIt3 m1 = new LaserShow_TryIt3();
	LaserShow_TryIt3 m2 = new LaserShow_TryIt3("Laser3000", true, 58, 150);
	
	
}

}
	//TODO 1. Change the class name from 'LaserShow_TryIt2' to 'LaserShow_TryIt3'
	
	//TODO 2. Change all the references of 'LaserShow_TryIt2' to 'LaserShow_TryIt3' (for example constructors)

	//TODO 3. Declare a private String variable for name of the show between class declaration and main() method

    //TODO 4. On the next line, declare a private double variable for duration of the show between class declaration and main() method
	
	//TODO 5. On the next line, declare a private integer variable for no of seats for the show
	
	//TODO 6. On the next line, declare a boolean variable for goggles required flag

	//TODO 7. Create a parameterized constructor taking duration, no of seats and gogglesRequired as parameters after default constructor
	
	//TODO 8. Assign values of parameters to the respective instance variables inside the parameterized constructor
	
	//TODO 9. Print "Parameterized constructor invoked" to console from parameterized constructor
	
	//TODO 10. Modify main() method to create at least two instances of 'LaserShow_TryIt3' using the parameterized constructor 
	
	//TODO 11. Pass appropriate arguments based on data type

	//TODO 12. Print values of all the instance variables using newly created 'LaserShow_TryIt3' instances
	
	//TODO 13. Save the file
