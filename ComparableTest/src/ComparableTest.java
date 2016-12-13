import java.util.*;
public class ComparableTest {
  public static void main(String[] args) {
	 TreeSet studentSet = new TreeSet();
	 studentSet.add(new Student("Mike", "Hauffmann",101,4.0));
	 studentSet.add(new Student("John", "Lynn",102,2.8 ));
	 studentSet.add(new Student("Jim", "Max",103, 3.6));
	 studentSet.add(new Student("Kelly", "Grant",104,2.3));
    Object[] studentArray = studentSet.toArray();
    Student st;
    for(Object obj : studentArray){
      st = (Student) obj;
      System.out.println("ID: " + st.studentID() +"\t" + "GPA: " + st.GPA() +
	"\t" + "Name: " +st.firstName()+ " " +st.lastName());
    }
  }
}
