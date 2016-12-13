package mypayroll;

import java.io.Serializable;

public class Person implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String name;
int age;
Address address;


public Person(String name, int age, Address address){
	super();
	this.name = name;
	this.age = age;
	this.address = address;
}


@Override
public String toString() {
	return "Person [name=" + name + ", age=" + age + ", address=" + address
			+ "]";
}


public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
