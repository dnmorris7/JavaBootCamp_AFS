package com.accenture.adf.newcodington.module11.activity.basic;
/**
 * The Park class an be used to represent parks at the NewCodington city.
 * It inherits from the RidesHosting interface
 */
public class Park implements RidesHosting {

	private int parkRide=0;
	private int rideType=0;
			
	public void assignRideCategory() {
		// assign ride category. The Park generally hosts low thrill rides
		parkRide=RidesHosting.LOW_THRILL;
	}	
	/**
	 * Method for getting RIDEDETAILS based on the parkRide
	 */
	public String getRideDetails() 
	{	
		String rideDetails="";
		
		if(parkRide==RidesHosting.LOW_THRILL) {
			rideDetails="Low Thrill Rides for Childern";
		}
		if(parkRide==RidesHosting.HIGH_THRILL) {
			rideDetails="High Thrill Rides for Teens and Adults";
		}
	return rideDetails;		
	}	
}
