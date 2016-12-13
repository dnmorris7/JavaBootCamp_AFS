package com.accenture.adf.newcodington.module10.sample;

/**
 * Topic : Inheritance
 * 
 * Description :
 * 
 * 	The ParkingTryIt.java file will be used during the Try It tasks in the Inheritance module.
 * 	Ensure that you have created the Vehicle and Car classes before running this program
 *	The error in line 16 is due to the Car class not being available.This will recede after the Car class is created
 */
public class ParkingTryIt {

	public static void main(String[] args) {
		// Creating a Car object
		Car car1 = new Car();
		
		// displaying the Car properties
		
		System.out.println("number of doors = "+car1.getDoors());
		System.out.println("number of seats = "+car1.getSeats());
		System.out.println("number of wheels = "+car1.getWheels());
		
		// TODO Invoke the drive method for car1 
		car1.drive();

	}

}
