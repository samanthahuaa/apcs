/**
TNPG: Frogs (Ivina Wang, Ruby Friedman, and Samantha Hua)
APCS
HW41-- Be Rational
2021-12-1
time spent: .5 hrs

DISCO:
* We can map out our plan of action before coding to create
  a more productive workflow
* Breaking down a alrger varaible into smaller parts makes it easier
  to deal with; ex. numerator and denominator
* Type casting is helpful when converting an int to a floating
  point value

QCC:
* What would happen if we set the denominator to 0- ignoring the
  error message
* How would we implement addition and subtraction of the fractions?
* How would be implement a simplify function (ex. 2/6 -> 1/3)?

**/

public class Rational{
    private int numerator;
    private int denominator;
    public Rational(){
      numerator = 0;
      denominator = 1;
    }
    public Rational(int a, int b){
      numerator = a;
      if (b == 0){
        System.out.println("error: cannot divide by 0 :(");
        numerator = 0;
        denominator = 1;
      }
      else {
        denominator = b;
      }
    }
    public String toString(){
      return numerator + "/" + denominator;
    }
    public double floatValue(){
      return ((double) numerator)/((double) denominator);
    }
    public void multiply(Rational a){
      numerator *= a.numerator;
      denominator *= a.denominator;
    }
    public void divide(Rational a){
      numerator *= a.denominator;
      denominator *= a.numerator;
    }
    public static void main(String[] args){
      Rational r = new Rational(2,3); //Stores rational number 2/3
      Rational s = new Rational(1,2); //Stores rational number 1/2
      System.out.println(r.toString());
      System.out.println(s.toString());
      // r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains 1/2
      // System.out.println(r.toString());
      // System.out.println(s.toString());
      r.divide(s);
      System.out.println(r.toString()); // should be 4/3
      System.out.println(s.toString()); // should be 1/2

      Rational a = new Rational(1,0);
      System.out.println(a.toString()); //should be 0/1

      System.out.println(r.floatValue());
      System.out.println(s.floatValue());
    }
}
