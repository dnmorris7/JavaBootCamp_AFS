package com.accenture.adf.newcodington.module10.activity;

/**
 * Park Class
 */
public class Park implements RidesHosting// TODO 1 - implement RidesHosting
											// interface
{
	int parkRide = 0;

	public void assignRideCategory() {
		// TODO 2 Assign low thrill to the parkRide variable.
		parkRide = LOW_THRILL;
	}

	/**
	 * Override getDetails method to display category of Ride based on PARKRIDE
	 * attribute Provide code to test parkRide and load
	 * "Low Thrill Rides for Children" into String variable rideDetails if
	 * parkRide = 1 and store value "High Thrill Rides for Teens and Adults" if
	 * parkRide = 2
	 */
	public String getRideDetails() {

		/*
		 * TODO 3 - Provide code to test parkRide and load
		 * "Low Thrill Rides for Children" into String variable rideDetails if
		 * parkRide=1 and store value "High Thrill Rides for Teens and Adults"
		 * if parkRide = 2
		 */
		String rideDetail = "null";
		if (parkRide == LOW_THRILL)
			rideDetail = "Low Thrill Rides for Children";
		else if (parkRide == HIGH_THRILL)
			rideDetail = "High Thrill Rides for Teens and Adults";
		// TODO 4 - replace NULL with String variable "rideDetail" and return
		// from method.
		return rideDetail;
	}

}
