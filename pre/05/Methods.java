public class Methods {

  public static void main(String[] args) {
    System.out.println(isDivisible(6,3));
    System.out.println(isTriangle(1,2,12));
    System.out.println(ack(1,0));
  }

  //exercise 2
  public static boolean isDivisible(int n, int m) {
    if (n%m == 0){
      return true;
    } else {
      return false;
    }
  }

  //exercise 3
  public static boolean isTriangle(int a, int b, int c) {
    if ((a>b+c) || (b>a+c) || (c>a+b)) {
      return false;
    } else {
      return true;
    }
  }

  //exercise 8
  public static int ack(int m, int n) {
    if (m==0) {
      return n+1;
    } else if (n==0 && m>0) {
      return ack(m-1,1);
    } else {
      int input = ack(m,n-1);
      return ack(m-1,input);
    }
  }

}
