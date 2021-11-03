public class preIncrementOperator {
  public static void main(String[] args) {
    // int x = 5;
    // System.out.println(x);
    // System.out.println(x++);
    // System.out.println(x);
    // System.out.println(x--);
    // System.out.println(x);
    // System.out.println(--x);
    // System.out.println(x);

    int i = 0;
    int x = 0;
    x = i++ +3;
    System.out.println(x);
    System.out.println(i);
    x = --x + i++ + x;
    System.out.println(x);
    System.out.println(i);

    int j = 0;
    int k = 0;
    j = ++k +3;
    System.out.println(j);
    System.out.println(k);
  }

}
