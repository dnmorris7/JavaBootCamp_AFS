package com.accenture.adf.newcodington.module11.activity.basic;
/** 
 * Interface for implementing common methods for PARK and ZOO classes
 */
public interface RidesHosting {

	// CONSTANTS to be used in the derived classes of RidesHosting.
	// They represent the different category of rides that could be hosted at a place
	int LOW_THRILL=1;
	int HIGH_THRILL=2;
		
	// Abstract methods to be overridden in sub classes
	public void assignRideCategory();
	public String getRideDetails();	
	
}
