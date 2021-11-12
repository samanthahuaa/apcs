import java.util.Arrays;

public class Loopier {
  public static int[] randArray(int[] x) {
    for (int i=0; i<x.length; i++) {
      x[i] = (int) (Math.random() * 2147483647);
    }
    return x;
  }

  public static String makeString(int[] x) {
    return Arrays.toString(x);
  }

  public static int linSearch(int[] a, int target) {

  }



  public static void main(String[] args) {
    int[] y = new int[5];
    System.out.println(makeString(randArray));
  }
}
