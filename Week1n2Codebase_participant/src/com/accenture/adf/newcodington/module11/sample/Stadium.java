package com.accenture.adf.newcodington.module11.sample;

/**
 * class STADIUM takes properties of BUILDING
 */
public class Stadium extends Building {

	// Encapsulated data field for Stadium
	private String[] gamesPlayed = { "" };

	public Stadium() // default constructor for Stadium class
	{
		gamesPlayed = new String[] { "CRICKET", "BASEBALL", "RUGBY" }; // Initializing
																		// with
																		// default
																		// constructor
		setGamesPlayed();
	}

	public String[] getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(String[] gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	// defining STADIUM Events by composing EVENT object for sports
	// functionality
	private void setGamesPlayed() {
		Event bbLeague1 = new Event();
		bbLeague1.setEventName("BaseBallLeague1");
		bbLeague1.setDescription("Knockout series");
		bbLeague1.setEventType("SPORTS");
		bbLeague1.setDuration(3);
		bbLeague1.setTicketPrice(150);

		setEvents(bbLeague1);
	}

	// Method to display all the Events for the domain class
	public void showEvents() {
		Event scheduledEvent = getEvents();
		System.out
				.println("----------------- STADIUM EVENT DETAILS -----------------");
		System.out.println("Name :" + scheduledEvent.getEventName());
		System.out.println("Type :" + scheduledEvent.getEventType());
		System.out.println("Duration :" + scheduledEvent.getDuration());
		System.out.println("Instructions:" + scheduledEvent.getDescription());
		System.out.println("Price :" + scheduledEvent.getTicketPrice());
		System.out
				.println("-------------------------------------------------\n\n");
	}

	/**
	 * overriding method from Building class
	 * 
	 * @param size
	 */
	public void showArea(int size) {
		System.out.println("Stadium area: " + size * 200);
	}

}
