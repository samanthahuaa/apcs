/**
TNPG: Frogs (Ivina Wang, Ruby Friedman, and Samantha Hua)
APCS
HW35-- Refactoring
2021-11-15
time spent: 1.0 hrs
DISCO:
 * Importing java.util.Array allows us to use pre-coded methods
   that we could create ourselves.
 * We can make a method to create a copy of an existing array with
   a certain length. (helper method copyOf)
 * When you print an array it prints out the data type and adress of
   the array in the memory.
QCC:
 * How does java.util.Array decide which methods to simplify when you
   can code them all yourself?
 * How does the computer know what we are reffering to when we import
   java.util.Array? Where are we importing it from?
**/

public class Loopier {
  private static int counter = -1;

  public static int[] randArray(int[] x) {
    for (int i=0; i<x.length; i++) {
      x[i] = (int) (Math.random() * 20);

    }
    return x;
  }

  public static String makeString(int[] x) {
    String ans = "[";
    for (int i = 0; i<x.length;i++) {
        ans+= x[i] + ", ";
    }
    ans = ans.substring(0, ans.length()-2);
    ans += "]";
    return ans;
  }

  public static int linSearch(int[] a, int target) {
    for (int i=0; i <a.length; i++) {
      if (a[i] == target) {
        return i;
      }
    }
    return -1;
  }
  public static int[] copyOf(int[] array, int len) {
    int[] ans = new int[len];
    for (int i = 0; i < len; i++) {
      ans[i] = array[i];
    }
    return ans;
  }
  public static int linSearchR(int[] a, int target) {
    if (a.length == 0) {
      return counter;
    } else if (a[a.length-1] == target) {
      counter = a.length - 1;
    }
    int[] b = copyOf(a, a.length-1);
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
      int[] b = copyOf(a, a.length-1);
      return 1 + freqRec(b, target);
    }
    int[] b = copyOf(a, a.length-1);
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
