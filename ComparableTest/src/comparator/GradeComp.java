package comparator;

import java.util.*;
public class GradeComp implements Comparator {
  public int compare(Object o1, Object o2) {
	 if (((Student)o1).GPA == ((Student)o2).GPA)
		return 0;
	 else if (((Student)o1).GPA < ((Student)o2).GPA)
		return -1;
	 else
		return 1;
	}
}