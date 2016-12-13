package com.accenture.adf.newcodington.module11.sample;


/**
 * Class Museum takes properties of BUILDING
 */
public class Museum extends Building {

	// Encapsulated data field for Museum
	private String[] museumActivities = { "" };

	/**
	 * Default constructor for Museum
	 */
	public Museum() {
		museumActivities = new String[]{"DOLLS","ACTOR","SPORTS"};		
	}

	public String[] getMuseumEvents() {
		return museumActivities;
	}	

	/**
	 * Defining Museum Events by composing EVENT object for museum functionality 
	 */
	public void setMuseumEvents() {		
		Event show1=new Event();
		show1.setEventName("ToyShow");
		show1.setEventType("Dance");
		show1.setDuration(5);
		show1.setDescription("1 minute show");
		show1.setTicketPrice(100);
		
		setEvents(show1);		
	}

	// Method to display all the Events for the domain class
	public void showEvents() {
		//TODO 1: Create event object by instantiating it with object named scheduledEvent and assign
		//		  value by calling getEvents() method
		//TODO 2: Print event name by calling getEventName() method on scheduledEvent object using System.out.println
		//TODO 3: Print event name by calling getEventType() method on scheduledEvent object using System.out.println
		//TODO 4: Print event name by calling getDuration() method on scheduledEvent object using System.out.println
		//TODO 5: Print event name by calling getDescription() method on scheduledEvent object using System.out.println
		//TODO 6: Print event name by calling getSchedule() method on scheduledEvent object using System.out.println
		//TODO 7: Print event name by calling getTicketPrice() method on scheduledEvent object using System.out.println		
	}

	/**
	 * Overriding method from Building class
	 * 
	 * @param size
	 */
	public void showArea(int size) {
		//TODO: Print the area by multiplying the size variable with 100 and using System.out.println		
	}

}
