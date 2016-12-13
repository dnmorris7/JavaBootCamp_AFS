package com.accenture.adf.newcodington.module11.activity.advanced;
/**
 * The Zoo class an be used to represent Zoos at the NewCodington city.
 * It inherits from the RidesHosting interface
 */
public class Zoo implements RidesHosting {

	private int noOfAnimals=0;
	private String[] animalNames={""};
	private Safari safari=null; // The safari class is composed in the Zoo class.
	private int zooRide=0;
	private int zooRideLocation=0;
	
	public void assignRideCategory() {
		// assign ride category. The Zoo generally hosts high thrill rides
		zooRide=RidesHosting.HIGH_THRILL;
	}
	
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

	public Safari getSafari() {
		return safari;
	}

	public void setSafari(Safari safari) {
		this.safari = safari;
	}

	public int getZooRide() {
		return zooRide;
	}

	public void setZooRide(int zooRide) {
		this.zooRide = zooRide;
	}

	/**
	 * Method to display ride details based on ride type
	 */
	public String getRideDetails() {
		String rideDetails="";
		if(zooRide==1)
		{
			rideDetails="Low Thrill Rides for Childern";
		}
		if(zooRide==2)
		{
			rideDetails="High Thrill Rides for Teens and Adults";
		}
		return rideDetails;
		
	}
	
	/**
	 * Method for assigning RIDETYPE based on the zooRide
	 */
	public void assignRideLocation() {
		
		// TODO: assign the RidesHosting CONSTANT for location to the member variable for 
		//       ride location			
	}
	
	/**
	 * Method for getting RIDETYPE based on the parkRide
	 */
	public String getRideLocation() {
		String rideTypeLocation="";
		
		// TODO 2: Test for parkRideLocation value and assign the appropriate string to 
		//         rideTypeLocation indicating whether it's an Indoor, Outdoor or Virtual ride
		
		// TODO 3: return the value for rideTypeLocation
		
		return null;
	}
	

}
