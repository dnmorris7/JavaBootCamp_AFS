package com.accenture.adf.newcodington.module11.sample;


/**
 * Class for providing all BusinessProcess logic
 * for all implementations in CODINGTON application
 */
public class CodingtonTryIt {	

	/**  
	 * Method to create objects for Theater, Stadium and Museum classes
	 */
	public void createObjects() {
		
		// NOTE: The following code is part of the SeeIt
		
		Theater theater = new Theater();
		displayEvents(theater);
		displayArea(theater, 30);
		
		Stadium stadium = new Stadium();
		displayEvents(stadium);	
		displayArea(stadium, 30);
		
		//TODO 7: Create Museum object by instantiating with with museum variable
		//TODO 8: Call displayEvents() methods by passing museum variables to it
		//TODO 9: Call displayArea() methods by passing museum variables to it	
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
		CodingtonTryIt cbp = new CodingtonTryIt();
		cbp.createObjects();
	}	

}
