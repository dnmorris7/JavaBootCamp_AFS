package mypayroll;

/*
 @author David Morris
 @date 6/5/2015*/

/*
 This demonstrates that we need dynamic binding.
 Having Employees being a straight extension creates problems with our constructors. 
 I cannot dynamically change my test object from contractor to employee without
 recollecting his basic information.*/
public class TestPerson {
	public static void main(String[] args) {
		Address a = new Address("800 Marcy Drive", "Springfield", "90210");
		Address b = new Address("424 Marcy Drive", "Springfield", "90210");
		assert (a.getCity() != null) : "Error in Get City";
		System.out.println(a.toString());

		Person p = new Employee("Mark", 42, a, 25.60);
		System.out.println(p.toString());
		Person e = new Contractor("Edward", 34, b, 30.00, false);
		System.out.println(e.toString());
	/*	// @error
		p = new Contractor(28.00, false);*/
	}
}
