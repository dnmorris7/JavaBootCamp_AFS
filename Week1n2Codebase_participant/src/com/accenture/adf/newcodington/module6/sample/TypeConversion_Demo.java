package com.accenture.adf.newcodington.module6.sample;

/**
 * 
 * TypeConversion demonstrates implicit and explicit conversions 
 * 
 * Topic: Demo on implicit and explicit conversions
 * 
 * Instructions:
 * Create a public class named 'TypeConversion_Demo' with a main() method that will perform
 * implicit and explicit conversions for the following primitive types
 * 		a. byte
 * 		b. short
 * 		c. char
 *		d. int 
 *		e. float
 *		f. double
 *		g. long
 * 
 */

public class TypeConversion_Demo {
	
	public static void main(String[] args){
		
		byte byteVar = 127; 		//Assign a value between -128 till 127 (inclusive)
		short shortVar = 32767; 	//Assign a value between -32,768 till 32,767 (inclusive)
		char charVar = 65535; 		//Assign a value between 0 till 65,535 (inclusive)
		int intVar = 2147483647;			//Assign a value between -2,147,483,648 till 2,147,483,647 (inclusive)		
		float floatVar = 1.0E38f; //32-bit floating point with single precision
		double doubleVar = 1.0E308; //64-bit floating point with double precision
		long longVar = 9223372036854775807L;		//Assign a value between -9,223,372,036,854,775,808 till 9,223,372,036,854,775,807 (inclusive)
		
		//Original values
		System.out.println("-------Original Values----------\n");
		System.out.println("byte value: " + byteVar);
		System.out.println("short value: " + shortVar);
		System.out.println("char value: " + charVar);
		System.out.println("int value: " + intVar);
		System.out.println("float value: " + floatVar);
		System.out.println("double value: " + doubleVar);
		System.out.println("long value: " + longVar);
		
		//Implicit conversions
		System.out.println("\n-------Implicit Conversions----------\n");
		
		int tempInt = shortVar;
		
		System.out.println("short casted to int: " + tempInt);
		
		tempInt = charVar;
		
		System.out.println("char casted to int: " + tempInt);
		
		tempInt = byteVar;
		
		System.out.println("byte casted to int: " + tempInt);
		
		float tempFloat = intVar;
		
		System.out.println("int casted to float: " + tempFloat);
		
		tempFloat = shortVar;
		
		System.out.println("short casted to float: " + tempFloat);
		
		tempFloat = charVar;
		
		System.out.println("char casted to float: " + tempFloat);
		
		tempFloat = longVar;
		
		System.out.println("long casted to float: " + tempFloat);
		
		double tempDouble = longVar;
		
		System.out.println("long casted to double: " + tempDouble);
		
		tempDouble = floatVar;
		
		System.out.println("float casted to double: " + tempDouble);
		
		long tempLong = intVar;
		
		System.out.println("int casted to long: " + tempLong);		
		
		//Explicit Cast
		System.out.println("\n-------Explicit Cast----------\n");
		
		byte tempByte = (byte) charVar; //Remove explicit casting (byte) and check the result
		
		System.out.println("char value: '" + charVar + "' converted as byte becomes: " + tempByte);			
		
		short tempShort = (short) charVar; //Remove explicit casting (short) and check the result
		
		System.out.println("char value: '" + charVar + "' converted as short becomes: " + tempShort);			
		
		char tempChar = (char) shortVar; //Remove explicit casting (char) and check the result
		
		System.out.println("short value: " + shortVar + " converted as char becomes: '" + tempChar + "'");		
		
		tempInt = (int) floatVar; //Remove explicit casting (int) and check the result
		
		System.out.println("float value: " + floatVar + " converted as int becomes: " + tempInt);			
		
		tempFloat = (float) doubleVar; //Remove explicit casting (float) and check the result
		
		System.out.println("double value: " + doubleVar + " converted as float becomes: " + tempFloat);				
		
		tempLong = (long) floatVar; //Remove explicit casting (long) and check the result
		
		System.out.println("float value: " + floatVar + " converted as long becomes: " + tempLong);	
		
	}
	
	
}
