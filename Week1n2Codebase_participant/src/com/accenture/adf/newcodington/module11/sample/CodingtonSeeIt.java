package com.accenture.adf.newcodington.module11.sample;

/**
 * Class for providing all BusinessProcess logic
 * for all implementations in CODINGTON application
 */
public class CodingtonSeeIt {	

	/** 
	 * Method to create objects for Theater and Stadium classes
	 */
	public void createObjects() {		
		//TODO 1: Create Theater object by instantiating with with theater variable
		//TODO 2: Call displayEvents() methods by passing theater variable to it
		//TODO 3: Call displayArea() methods by passing theater and integer variables to it
		
		//TODO 4: Create Stadium object by instantiating with with stadium variable
		//TODO 5: Call displayEvents() methods by passing stadium variable to it
		//TODO 6: Call displayArea() methods by passing stadium and integer variables to it				 
	}	
	
	/**
	 * Method to input building and display events
	 * tagged for the place
	 * --> Example to demonstrate POLYMORPHISM
	 * @param building
	 * 
	 */
	public void displayEvents(Building building) {
		building.showEvents();		
	}
	
	/**
	 * Method to calculate the area depending on 
	 * type of object passed
	 * @param building
	 * @param size
	 */
	public void displayArea(Building building, int size) {
		building.showArea(size);
	}
	
	/** Main method to demonstrate POLYMORPHISM 
	 * @param args
	 */
	public static void main(String[] args) {
		CodingtonSeeIt cbp = new CodingtonSeeIt();
		cbp.createObjects();
	}	

}
