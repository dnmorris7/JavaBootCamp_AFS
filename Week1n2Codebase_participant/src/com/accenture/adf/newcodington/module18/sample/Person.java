/**
 * 
 */
package com.accenture.adf.newcodington.module18.sample;

import java.io.Serializable;

/**
 * Person class is a Serializable class holding person related data
 * 
 */
public class Person implements Serializable {
	/**
	 * Members to capture the Person related data line name, address, etc<br>
	 */
	private static final long serialVersionUID = -5062857108261354303L;
	private String name = "";
	private String address = "";
	private Integer number = new Integer(0);
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + ", number="
				+ number + "]";
	}


}
