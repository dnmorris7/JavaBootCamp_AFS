package mypayroll;

public class Person {
	private String name;
	private int age;
	private Address address;
	
	public Person(String n, int a, Address add){
		name=n;
		age=a;
		address=add;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString(){
		return this.getName()+":"+this.getAge()+":"+
				this.address;
	}
}
