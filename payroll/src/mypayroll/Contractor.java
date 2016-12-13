package mypayroll;

public class Contractor extends Person {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
boolean permanent;
double hourlyRate;

public Contractor(String name, int age, Address address, double hourlyRate, boolean permanent) {
	super(name, age, address);
	// TODO Auto-generated constructor stub
	this.hourlyRate=hourlyRate;
	this.permanent=permanent;
}

/*public Contractor(double d, boolean b) {
	
	this.hourlyRate=hourlyRate;
	this.permanent=permanent;
}
*/
@Override
public String toString() {
	return super.toString()+ "Contractor [permanent=" + permanent + ", hourlyRate=" + hourlyRate
			+ "]";
}

public boolean isPermanent() {
	return permanent;
}

public void setPermanent(boolean permanent) {
	this.permanent = permanent;
}


}
