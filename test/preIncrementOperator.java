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
    System.out.println("1st assignment");
    System.out.println(x); //3
    System.out.println(i); //1
    x = --x + i++ + x;
    System.out.println("2nd assignment");
    System.out.println(x); //5 (2+1+2)
    System.out.println(i); //2

    int j = 0;
    int k = 0;
    j = ++k +3;
    System.out.println(j); //4
    System.out.println(k); //1
  }

}
