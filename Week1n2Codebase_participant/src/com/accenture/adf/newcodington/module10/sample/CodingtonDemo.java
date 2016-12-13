package com.accenture.adf.newcodington.module10.sample;

import com.accenture.adf.newcodington.module11.sample.Theater;

/**
 * Topic : Inheritance
 * 
 * Instructions:
 * 
 * 	The CodingtonDemo.java file will be used during the 
 * 	Show It tasks in the Inheritance module.
 * 	Ensure that you have created the Place, Building and Theater classes 
 * 	before running this program
 *	
 */
public class CodingtonDemo {

	public static void main(String[] args) {
		
		// Creating a Theater object
		Theater theater1 = new Theater();
		
		// Display the area using the showArea method	
		theater1.showArea(500);
		
		// The code in the comments below needs to be used during Composition demo
	/*	
		Event events = new Event();
		events.setEventName("Rose Parade");events.setDescription("Floats, Music and More");
		events.setEventType("Tour");events.setDuration(5);
		events.setTicketPrice(100);
		// Setting an Event
		theater1.setEvents(events);
		// invoke the showEvents method
	 */		
		theater1.showEvents();
	}

}
