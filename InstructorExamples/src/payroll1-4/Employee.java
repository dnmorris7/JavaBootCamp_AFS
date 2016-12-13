package mypayroll;

public class Employee extends Person{
	private double salary;
	
	public Employee(String n, int a, Address add, double s){
		super(n,a,add);
		salary=s;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String toString(){
		return super.toString() + ":" + this.getSalary();
	}
	
}
