package com.accenture.adf.newcodington.module11.activity.advanced;
/**
 * The Park class an be used to represent parks at the NewCodington city.
 * It inherits from the RidesHosting interface
 */
public class Park implements RidesHosting {

	private int parkRide=0;
	private int parkRideLocation=0;
			
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
		
		if(parkRide==RidesHosting.LOW_THRILL)
		{
			rideDetails="Low Thrill Rides for Childern";
		}
		if(parkRide==RidesHosting.HIGH_THRILL)
		{
			rideDetails="High Thrill Rides for Teens and Adults";
		}
	return rideDetails;		
	}	
	
	/**
	 * Method for assigning RIDETYPE based on the parkRide
	 */
	public void assignRideLocation() {
		
		// TODO 1: assign the RidesHosting CONSTANT for location to the member variable for 
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
