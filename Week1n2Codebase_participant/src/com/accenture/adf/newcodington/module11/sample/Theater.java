package com.accenture.adf.newcodington.module11.sample;

import java.util.ArrayList;

/**
 * Topic: Inheritance
 * 
 * Instructions:
 * 
 * The Theater class is to be created and updated in the participant folder by
 * the participant during Show It tasks for the module. This class is a solution
 * for the task. It acquires properties of a Building through inheritance
 */
public class Theater extends Building {
	
	private ArrayList<String> activeTheaterGroups=null;

	public Theater() {
		super();
		activeTheaterGroups=new ArrayList<String>(); // initializing collection in constructor
		activeTheaterGroups.add("GROUP1");
		activeTheaterGroups.add("GROUP2");
		setTheaterEvents();
	}

	public ArrayList<String> getActiveTheaterGroups() {
		return activeTheaterGroups;
	}

	public void setActiveTheaterGroups(ArrayList<String> activeTheaterGroups) {
		this.activeTheaterGroups = activeTheaterGroups;
	}

	// defining Theater Events by composing EVENT object
	private void setTheaterEvents() {
		Event show1 = new Event();
		show1.setEventName("Balarena");
		show1.setEventType("Dance");
		show1.setDuration(5);
		show1.setDescription("1 minute show");
		show1.setTicketPrice(100);

		setEvents(show1);
	}

	/**
	 * Overriding method from the Building class
	 * 
	 * @param size
	 */
	public void showArea(int size) {
		System.out.println("Theater area : " + size * 12);
	}

	// Override the showEvents method to be used during Non-Access Modifiers:
	// abstract See It
	/*
	 * public void showEvents() {
	 * System.out.println("Theater events ready to be hosted !!"); }
	 */

	// Override the showEvents method to be used during Composition See It
	public void showEvents() {
		Event e = getEvents();

		System.out
				.println("----------------- THEATER EVENT DETAILS -----------------\n");
		System.out.println("Event name :" + e.getEventName());
		System.out.println("Event Type :" + e.getEventType());
		System.out.println("Event Description :" + e.getDescription());
		System.out.println("Event Duration :" + e.getDuration());
		System.out.println("Event Ticket Price :" + e.getTicketPrice());
		System.out
				.println("-------------------------------------------------\n\n");

	}
}
