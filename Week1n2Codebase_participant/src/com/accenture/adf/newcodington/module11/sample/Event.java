package com.accenture.adf.newcodington.module11.sample;

/**
 * Topic: Inheritance
 * 
 * Instructions:
 * 
 * The Event class is to be created and updated in the participant folder by the
 * faculty during See It tasks for the module. This class is a solution for the
 * task
 * 
 */
public class Event {

	// Encapsulated data fields for EVENT class
	private String eventName;
	private String description;
	private int duration;
	private String eventType;
	private int ticketPrice;

	// GETTER and SETTER methods for EVENT class
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

}
