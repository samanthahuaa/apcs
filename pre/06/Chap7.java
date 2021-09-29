public class Chap7 {
  public static void main(String[] args) {
    System.out.println(Power(5,4));
    System.out.println(Factorial(5));
    System.out.println(myexp(0.1,5));
    System.out.println(check(1));

    //It seems that the accuracy peaks at a certain point. It started at 7 digits similar, peaked at 16 digits and went all the way down to 0.
    for (double i=0.1; i<=100; i *= 10) {
      System.out.println(check(i));
    }
    //Accuracy decreases as i decreases. At a certain point, myexp calculates a negative number whereas Math.exp has a
    for (double i=-0.1; i>=-100; i *= 10) {
      System.out.println(check(i));
    }
  }

  //exercise 3
  public static double Power(double x, int n){
    double total = x;
    for (int i=1; i<n; i++) {
      total *= x;
    }

    return total;
  }

  //exercise 4
  public static double Factorial(int n) {
    double total = 1;
    while (n>0) {
      total *= n;
      n--;
    }
    return total;
  }

  //exercise 5
  public static double myexp(double x, int n) {
    double total = 1;
    // Number 1
    // for (int i=1; i<n; i++) {
    //   total += Power(x,i)/Factorial(i);
    // }

    //Number 2
    double top = 1;
    double bottom = 1;
    double boop = 1;
    for (int i=1; i<n; i++) {
      // boop *= (x/i);
      boop = (top *= x)/(bottom *= i);
      total += boop;
    }
    return total;
  }

  public static String check(double x) {
    return (x+"\t"+myexp(x,10)+"\t"+Math.exp(x));
  }
}
