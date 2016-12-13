package com.accenture.adf.newcodington.module11.activity.basic;
/**
 * The Zoo class an be used to represent Zoos at the NewCodington city.
 * It inherits from the RidesHosting interface
 */
public class Zoo implements RidesHosting {

	private int noOfAnimals=0;
	private String[] animalNames={""};
	private Safari safari=null; // The safari class is composed in the Zoo class.
	private int zooRide=0;
	
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
		if(zooRide==RidesHosting.LOW_THRILL) {
			rideDetails="Low Thrill Rides for Childern";
		}
		if(zooRide==RidesHosting.HIGH_THRILL) {
			rideDetails="High Thrill Rides for Teens and Adults";
		}
		return rideDetails;
		
	}
}
