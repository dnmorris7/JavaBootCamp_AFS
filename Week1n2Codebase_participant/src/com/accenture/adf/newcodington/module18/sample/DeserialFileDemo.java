package com.accenture.adf.newcodington.module18.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 
 * Topic: Demo serialzing and deserializing a Person object
 * 
 * Instructions: Read Person data from the DAT file 1. Load the Person.dat file
 * into a File object <br/>
 * 2. Deserialize the Person.dat file to display the stored data <br/>
 * 3. Display the name, address and phone number from the Person instance
 * restored. a. Utilize the FileInputStream and ObjectInputStream for this
 * purpose 4. Use try-catch block for IO and ClassNotFound exceptions
 * 
 */

public class DeserialFileDemo {

	public static void main(String[] args) {
		// Loading the Person.dat file into a File object
		File fromFile = new File("Person.dat");

		// TODO 1 - Deserialize the Person.dat file to retrieve the stored data.
		// Utilize the FileInputStream and OutputInputStream objects for this
		// purpose
		ObjectInputStream ois = null;
		// TODO 2 - Display the name, address and phone number from the Person
		// instance restored.

		try {
			ois = new ObjectInputStream(new FileInputStream(fromFile));
			Person p2 = ((Person)ois.readObject());
			System.out.println("Person 2: \r"+p2.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO 3 - Close the input stream objects

	}
}
