package com.accenture.adf.newcodington.module26.sample;

// TODO 1 Implement HelloSeeIt interface.
public class HelloSeeItImpl implements HelloSeeIt{

// TODO 2 Create a Default Constructor and print a message from it.
	public HelloSeeItImpl() {
		System.out.println("Hello See It Implementation Begun");
	}	


// TODO 3 Override sayHello method. Return the name with a  greeting.
	public String sayHello(String message){
		String helloMessage = "Hello there, " +message +".  ";
		return helloMessage;	
		}


}
