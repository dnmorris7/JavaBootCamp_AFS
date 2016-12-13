package com.accenture.adf.newcodington.module12.sample;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Topic : Collections
 * 
 * Instructions : 1. Activity to implement Map collection of Java Collections
 * Framework 2. Code as per the TODOs
 * 
 */

public class MapTryIt {

	/**
	 * Type code to create a HashMap of key value pairs<br/>
	 * where key is id of type String and value is a name
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		// TODO 1 Type code to create a HashMap of key value pair
		// where key is id of type String and value is a name
		int[] i= {3,4,5};
	
		//map.put("event1", "HIGH THRILL_RIDE - PARK");
	//	map.put(4, new Object());
		map.put(i, 6.7);
		//map.put("event1", "HIGH CHILL - PARK");
		// I Can RETRIEVE KEYS
		Set<Object> keys = map.keySet();
		Collection values = map.values();
		// TODO 2 Type code to print this map
System.out.println(map.get(i));
		System.out.println(map.toString());
		System.out.println(keys);
		System.out.println(values.toString());
	}
}