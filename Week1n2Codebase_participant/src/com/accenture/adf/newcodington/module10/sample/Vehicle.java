package com.accenture.adf.newcodington.module10.sample;

public class Vehicle {
int doors, seats, wheels;



public Vehicle() {
	super();
	
	this.doors = 4;
	this.seats = 5;
	this.wheels = 4;
}

public Vehicle(int doors, int seats, int wheels) {
	super();
	this.doors = doors;
	this.seats = seats;
	this.wheels = wheels;
}

public int getDoors() {
	return doors;
}

public void setDoors(int doors) {
	this.doors = doors;
}

public int getSeats() {
	return seats;
}

public void setSeats(int seats) {
	this.seats = seats;
}

public int getWheels() {
	return wheels;
}

public void setWheels(int wheels) {
	this.wheels = wheels;
}

public void drive(){
	System.out.println("Vehicle is driving.");
	
}

}
