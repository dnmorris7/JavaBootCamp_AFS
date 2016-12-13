package comparator;

import java.util.*;
public class NameComp implements Comparator {
  public int compare(Object o1, Object o2) {
    return
      (((Student)o1).firstName.compareTo(((Student)o2).firstName));
  }
}