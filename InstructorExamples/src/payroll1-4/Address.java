package mypayroll;

public class Address {
	private String street, city, zip;
	
	public Address(String s, String c, String z){
		street=s;
		city=c;
		zip=z;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getZip() {
		return zip;
	}
	
	public String toString(){
		return this.getStreet()+":"+this.getCity()+":"+this.getZip();
	}
}
