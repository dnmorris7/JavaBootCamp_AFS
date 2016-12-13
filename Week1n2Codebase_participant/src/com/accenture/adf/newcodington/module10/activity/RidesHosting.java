package com.accenture.adf.newcodington.module10.activity;
/**
 * Interface for implementing common methods for PARK and ZOO classes
 */
public interface RidesHosting {

	// CONSTANTS to be used in the derived classes of RidesHosting
	int LOW_THRILL=1;
	int HIGH_THRILL=2;
	
	// Abstract methods to be overridden in sub classes
	public void assignRideCategory();
	public String getRideDetails();	
	
}
