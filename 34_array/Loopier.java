/**
TNPG: Frogs (Ivina Wang, Ruby Friedman, and Samantha Hua)
APCS
HW34--A Pirate's Life for Me
2021-11-13
time spent: 1.0 hour

DISCO:
 - Array.toString() allows you to print out the contents of an array that is human-readable.
 - Arrays.copyOf() creates a copy of an array and allows you to select how much of the array you want to copy
 - <nameOfArray>.length returns the length of an array. Unlike <nameOfString>.length() there are no parentheses
 - To hardcode the contents of an array upon intialization you use {} (ex: int[] z = {1,2,3})

QCC:
 - How do you make a copy of an array with a start index that isn't 0 using copyOf? Is this even possible?
 - Is using a instance variable in a recursive loop discouraged?
**/

import java.util.Arrays;

public class Loopier {
  private static int counter = -1;

  public static int[] randArray(int[] x) {
    for (int i=0; i<x.length; i++) {
      x[i] = (int) (Math.random() * 20);

    }
    return x;
  }

  public static String makeString(int[] x) {
    return Arrays.toString(x);
  }

  public static int linSearch(int[] a, int target) {
    for (int i=0; i <a.length; i++) {
      if (a[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public static int linSearchR(int[] a, int target) {
    if (a.length == 0) {
      return counter;
    } else if (a[a.length-1] == target) {
      counter = a.length - 1;
    }
    int[] b = Arrays.copyOf(a, a.length-1);
    return linSearchR(b, target);
  }

  public static int freq( int[] a, int target ) {
    int frequency = 0;
    int i = 0;
    while (i<a.length) {
      if (a[i] == target) {
        frequency++;
      }
      i++;
    }
    return frequency;
  }

  public static int freqRec( int[] a, int target ) {
    if (a.length == 0) {
      return 0;
    } else if (a[a.length-1] == target) {
      int[] b = Arrays.copyOf(a, a.length-1);
      return 1 + freqRec(b, target);
    }
    int[] b = Arrays.copyOf(a, a.length-1);
    return freqRec(b, target);
  }

  public static void main(String[] args) {
    int[] y = new int[10];
    System.out.println(makeString(randArray(y)));
    System.out.println(linSearch(y, 5));
    System.out.println(linSearchR(y, 5));
    System.out.println(freq(y,5));
    System.out.println(freqRec(y,5));
  }
}
