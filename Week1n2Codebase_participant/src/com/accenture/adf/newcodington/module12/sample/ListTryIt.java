package com.accenture.adf.newcodington.module12.sample;

import java.util.List; //awt is a GUI package. 
import java.util.ArrayList;

/**
 * Topic : Collections
 * 
 * Instructions : 1. Activity to implement List collection of Java Collections
 * Framework 2. Code as per the TODOs
 * 
 * 
 */

public class ListTryIt {

	/**
	 * Type code to create a list of names. Use ArrayList.<br/>
	 * Type code to print this list
	 */
	public static void main(String[] args) {

		// TODO 1 Type code to create a list of names. Use ArrayList.
		List<Object> list = new ArrayList<Object>();
		// List list = new ArrayList();

		list.add(new Thread());
		list.add(5.6);
		list.add("Casey");
		list.add("Carrie");
		list.add("Cody");
		list.add("Hudson");
		list.add("Limbaugh");
		list.add("Carrigan");
		list.add("Atma");
		list.add("Locromise");
		list.add("Venova");

		// TODO 2 Type code to print this list
		for (Object o : list) {
			System.out.println(o);

		}

	}
}
