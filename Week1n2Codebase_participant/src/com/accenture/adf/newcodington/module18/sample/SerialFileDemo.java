package com.accenture.adf.newcodington.module18.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 
 * Topic: Demo serialzing and deserializing a Person object
 * 
 * Instructions: Store the Person data into a .dat file
 * 
 * 1. Create a new instance of the person class and set the relevant data.<br/>
 * 2. Set the objPerson instance with your name, address and phone number.<br/>
 * 3. Create a file (Person.dat) and write the Person details<br/>
 * a. Utilize the FileOutputStream and ObjectOutputStream for this purpose
 * 
 */

public class SerialFileDemo {

	public static void main(String[] args) {
		// TODO 1 - Create a new instance of the person class and set the
		// relevant data.
		Person p = new Person();
		// TODO 2 - Set the instance with your name, address and phone number.
		p.setName("Abyss");
		p.setAddress("Heck");
		p.setNumber(666);

		// TODO 3 - Create a file (Person.dat) to write the Person details
		File f = new File("Person.dat");
		// TODO 4 - Write the Person instance to the ObjectOutputStream.
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(p);
			System.out.println("Person was written: " + p.toString()
					);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		try {
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		// TODO 5 - Close the OutputStream objects

	}

}
