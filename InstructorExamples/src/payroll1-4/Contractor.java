package mypayroll;

public class Contractor extends Person{
	private boolean permanent;
	private double hourlyRate;
	
	public Contractor(String n, int a, Address add, boolean p, double hr){
		super(n,a,add);
		permanent=p;
		setHourlyRate(hr);
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	public String toString(){
		return super.toString() + ":" + getHourlyRate() +
				":" + permanent;
	}
}
