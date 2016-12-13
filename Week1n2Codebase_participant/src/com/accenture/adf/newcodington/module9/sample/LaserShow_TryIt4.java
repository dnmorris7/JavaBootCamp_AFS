package com.accenture.adf.newcodington.module9.sample;


/**
 * 
 * LaserShow is about a special show in the New Codington Museum
 * 
 * Topic: Demo on usage of getter and setter methods
 * 
 * Copy and paste the code for 'LaserShow_TryIt3' after all the TODO's and make the following changes
 * 
 */

public class LaserShow_TryIt4{
@Override
	public String toString() {
		return "LaserShow_TryIt4 [showName=" + showName + ", gogglesRequired="
				+ gogglesRequired + ", duration=" + duration + ", numSeats="
				+ numSeats + "]";
	}



public String getShowName() {
		return showName;
	}



	public void setShowName(String showName) {
		this.showName = showName;
	}



	public boolean isGogglesRequired() {
		return gogglesRequired;
	}



	public void setGogglesRequired(boolean gogglesRequired) {
		this.gogglesRequired = gogglesRequired;
	}



	public double getDuration() {
		return duration;
	}



	public void setDuration(double duration) {
		this.duration = duration;
	}



	public int getNumSeats() {
		return numSeats;
	}



	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}


private String showName;
private boolean gogglesRequired;
private double duration;
private int numSeats;



public LaserShow_TryIt4(){
	System.out.println("Default Constructor Invoked.");	
	showName="[Show Name]";
	gogglesRequired=false;
	duration = 999;
	numSeats = 150;
}



public LaserShow_TryIt4(String showName, boolean gogglesRequired,
		double duration, int numSeats) {
	super();

	this.showName = showName;
	this.gogglesRequired = gogglesRequired;
	this.duration = duration;
	this.numSeats = numSeats;
	System.out.println("Parametized Constructor Invoked: \r" + "Show Name: "+ this.showName +
			" | Goggle Requirement: " + this.gogglesRequired + " | Duration: " + this.duration +" minutes. | Number of Seats: " + this.numSeats);
}


public static void main(String[] args) {
	LaserShow_TryIt4 m1 = new LaserShow_TryIt4();
	LaserShow_TryIt4 m2 = new LaserShow_TryIt4("Laser3000", true, 58, 150);
	
	
		System.out.println(m1.toString());
		System.out.println(m2.toString());

		m2.setShowName("The Lazer Collection");
		System.out.println(m2.toString());
}
}

	//TODO 1. Change the class name from 'LaserShow_TryIt3' to 'LaserShow_TryIt4'
	
	//TODO 2. Change all the references of 'LaserShow_TryIt3' to 'LaserShow_TryIt4' (for example constructors)
	
	//TODO 3. Create get() and set() methods for each of the non static variables with 
    //        appropriate parameters and return types after parameterized constructor
	
	//TODO 4. All set() methods assign parameter values to their respective instance variables
	
	//TODO 5. All get() methods will return the current value of the respective instance variable
	
	//TODO 6. Print all the variable values using respective get() methods to console in the 
    //        main() method using the class instance created
	
	//TODO 7. Choose any or all of the instance variables to change values using set methods and 
    //        repeat TODO 4 to observe the changes
	
	//TODO 8. Save the file