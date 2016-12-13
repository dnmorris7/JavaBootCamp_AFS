package com.accenture.adf.newcodington.module11.activity.advanced;
/** 
 * Interface for implementing common methods for PARK and ZOO classes
 */
public interface RidesHosting {

	// CONSTANTS to be used in the derived classes of RidesHosting.
	// They represent the different category of rides that could be hosted at a place
	int LOW_THRILL=1;
	int HIGH_THRILL=2;
	
	// CONSTANTS to be used in the derived classes of RideHosting.
	// They represent the different ride location types
	
	// TODO 1: Create CONSTANTS of type int for INDOOR, OUTDOOR, and VIRTUAL and assign
	//         a numeric value to each CONSTANT
	
		
	// Abstract methods to be overridden in sub classes
	public void assignRideCategory();
	public String getRideDetails();	
	
	// TODO 2: Add an abstract method declaration to assign a ride location that doesn't
	//         have a return value
	
	// TODO 3: add an abstract method declaration to get the ride location and return it 
	//         as a String
	
}
