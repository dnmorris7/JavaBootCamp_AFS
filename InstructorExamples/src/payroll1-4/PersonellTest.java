package mypayroll;

public class PersonellTest {

	Person[] persons=new Person[3];
	int numOfPersons;
	
	public void add(Person p){
		if(numOfPersons<persons.length){
			persons[numOfPersons++]=p;
		}
		else{
			System.out.println("Array Full");
		}
	}
	
	public void printPerson(){
		for(Person per : persons){
			System.out.println(per);
		}
	}
	
	public static void main(String[] args){
		Address a = new Address("123 spooner", "Quoahog", "54321");
		
		Person p1 = new Person("Stewie", 1, a);
		
		Person e = new Employee("Lois",41,a,30000);
		Person c = new Contractor("Peter",42,a,false,21);
		Contractor c2 = new Contractor("Quagmire",37,a,true,15);
		
		PersonellTest pt = new PersonellTest();
		pt.add(p1);
		pt.add(e);
		pt.add(c);
		pt.add(c2);
		
		pt.printPerson();
	}
}
