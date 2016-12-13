package com.accenture.adf.newcodington.module12.sample;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;




/**
 * 
 * Topic : Collections
 * 
 * Instructions : 1. Activity to implement Set collection of Java Collections
 * Framework 2. Code as per the TODOs
 * 
 */

public class SetTryIt {

	/**
	 * Type code to create a set of names.<br/>
	 * Also try adding a few duplicate entries to this set.<br/>
	 * Type code to print all elements loaded in SET in console
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 1 Type code to create a set of names.
		// Also try adding a few duplicate entries to this set.
		Set<String> set = new HashSet<String>();
		set.add("Casey");
		set.add("Carrie");
		set.add("Cody");
		set.add("Hudson");
		set.add("Limbaugh");
		set.add("Carrigan");
		set.add("Atma");
		set.add("Locromise");
		set.add("Venova");

		// set.add(1);
		// TODO 2 Type code to print all elements loaded in SET in console
		for (Iterator<String> i = set.iterator(); i.hasNext();)
			System.out.println(i.next());

	System.out.println(set);
	
	}
}