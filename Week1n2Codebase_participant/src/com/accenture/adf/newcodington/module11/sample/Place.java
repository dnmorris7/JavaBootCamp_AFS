package com.accenture.adf.newcodington.module11.sample;

/**
 * Topic: Inheritance
 * 
 * Instructions:
 * 
 * The Place class is to be created and updated in the participant folder by the
 * faculty during See It tasks for the module.This class is a solution for the
 * task The Place class dictates the the behavior for the Theater and Building
 * class.
 */

public abstract class Place {

	// Encapsulated data fields of PLACE object
	private String placeName;
	private String capacity;
	private String placeDescription;
	private int workingHours;

	// Declaring an Event variable. Event class is now composed in Place
	private Event events;

	// GETTER and SETTER methods for Place class attributes
	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getPlaceDescription() {
		return placeDescription;
	}

	public void setPlaceDescription(String placeDescription) {
		this.placeDescription = placeDescription;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	// Getter and Setter for Event object
	public Event getEvents() {
		return events;
	}

	public void setEvents(Event events) {
		this.events = events;
	}

	// Abstract method to be overridden in Subclasses .
	public abstract void showEvents();

}
