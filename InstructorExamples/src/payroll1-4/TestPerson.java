package mypayroll;

public class TestPerson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address a = new Address("123 spooner", "Quoahog", "54321");
		
		Person p1 = new Person("Stewie", 1, a);
		
		System.out.println("PERSON: "+p1);
		
		Person e = new Employee("Lois",41,a,30000);
		Person c = new Contractor("Peter",42,a,false,21);
		
		System.out.println("EMPLOYEE: " + e);
		System.out.println("CONTRACTOR: " + c);
	}

}
