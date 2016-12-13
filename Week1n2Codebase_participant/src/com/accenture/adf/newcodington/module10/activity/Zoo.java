package com.accenture.adf.newcodington.module10.activity;

/**
 * Topic: Inheritance
 * 
 * Description :
 * 	Zoo class overrides the methods inherited from the interface RidesHosting
 * 	Zoo hosts High Trill rides
 * 	The variable zooride is used to represent different types of rides
 * 	The zooride value is 1 if the rides is a Low Thrill ride for Children 
 *  and 2 if the ride is a High Thrill ride for teens and adults
 * 	The errors in the code code will recede once the code is complete
 */

public class Zoo implements RidesHosting// TODO 1 - implement RidesHosting

{
	private int noOfAnimals=0;
	private String[] animalNames={""};
	private int zooRide=0;
	public int getNoOfAnimals() {
		return noOfAnimals;
	}
	public void setNoOfAnimals(int noOfAnimals) {
		this.noOfAnimals = noOfAnimals;
	}
	public String[] getAnimalNames() {
		return animalNames;
	}
	public void setAnimalNames(String[] animalNames) {
		this.animalNames = animalNames;
	}
	public int getZooRide() {
		return zooRide;
	}
	public void setZooRide(int zooRide) {
		this.zooRide = zooRide;
	}
	
	// TODO 2 - generate the setters and getters for the instance variables. 
	
	/* TODO 3 - override assignRideCategory() method by assigning the 
	 * 			high thrill value to the zooRide instance variable. 
	 * 			Hint: use the HIGH_THRILL constant defined in the RideHosting interface
	 */
	@Override
	public void assignRideCategory(){
		zooRide = HIGH_THRILL;
	}
	// TODO 4 - override the getRideDetails() method
public String getRideDetails(){
	String rideDetail = "null";
	if (zooRide == LOW_THRILL)
		rideDetail = "Low Thrill Rides for Children";
	else if (zooRide == HIGH_THRILL)
		rideDetail = "High Thrill Rides for Teens and Adults";
	// TODO 4 - replace NULL with String variable "rideDetail" and return
	// from method.
	return rideDetail;
	
}
	// TODO 5 - create a string variable rideDetails and initialize it with null Value 
		
	/* TODO 6 - check the value of zooRide,
	 * 			assign the string "Low Thrill Rides for Children" to rideDetails if the zooRide is a low thrill ride and
	 * 			assign the string "High Thrill Rides for Teens and Adults" to rideDetails if zooRide is a high thrill ride
	 */
		 
	// TODO 7 - return the rideDetails
			
}
