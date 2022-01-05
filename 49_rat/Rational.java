/**
TNPG: Frogs (Ivina Wang, Ruby Friedman, and Samantha Hua)
APCS
HW49-- Rational Standards Compliance
2021-12-22
time spent: 1.0 hr

DISCO:
 * How to use instanceof and implement a class into compliance with an interface.
 * You can type cast into a specific type of Object (ie Rational)
 * Driver files are helpful for creating test cases and then letting the error messages guide you.

QCC:
 * How can we implement this into other projects, when would we want to put an interface into compliance with>
 * How many test cases is sufficent to prove that class Rational is in compliance with the Comparable interfa>

**/

public class Rational implements Comparable {
	private int numerator;
	private int denominator;

	public Rational(){
		numerator = 0;
		denominator = 1;
	}

	public Rational(int a, int b){
		this();
		if (b == 0){
			System.out.println("error: cannot divide by 0 :(");
		}
		else {
			numerator = a;
			denominator = b;
		}
	}

	public String toString(){
		return numerator + "/" + denominator;
	}

	public double floatValue(){
		return (double) numerator/ denominator;
	}

	public void multiply(Rational a){
		numerator = this.numerator * a.numerator;
		denominator = this.denominator * a.denominator;
	}

	public void divide(Rational a){
		if ( a.numerator != 0 ) {
			numerator   = numerator   * a.denominator;
			denominator = denominator * a.numerator;
		}
		else {
		System.out.println( "error: cannot divide by 0 :(" );
		}
	}

	public static int gcd(int a, int b) {
		if (a == b) {
 			return a;
		}
		else if (a > b) {
			return gcd(a-b, b);
		}
		else {
			return gcd(a, b-a);
		}
	}

	public static int gcDENOMINATOR(int a, int b) {
		int result = a;
		int counter = 1;
		while (result % b != 0) {
			result = counter * a;
			counter += 1;
		}
		return result;
	}

	public void add(Rational a) {
		int common = gcDENOMINATOR(this.denominator, a.denominator);
		int mult0 = common/this.denominator;
		int mult1 = common/a.denominator;
		numerator = (mult0 * this.numerator) + (mult1 * a.numerator);
		denominator = common;
	}

        public void subtract(Rational a) {
                int common = gcDENOMINATOR(this.denominator, a.denominator);
                int mult0 = common/this.denominator;
                int mult1 = common/a.denominator;
                numerator = (mult0 * this.numerator) - (mult1 * a.numerator);
                denominator = common;
        }

	public int gcd() {
                if (this.numerator == this.denominator) {
                        return this.numerator;
                }
                else if (this.numerator > this.denominator) {
                        return gcd(this.numerator - this.denominator, this.denominator);
                }
                else {
                        return gcd(this.numerator, this.denominator-this.numerator);
                }
        }
	public void reduce() {
		numerator = this.numerator / gcd();
		denominator = this.denominator / gcd();
	}

	public int compareTo(Object a) {
		if (a instanceof Rational) {
			Rational b  = (Rational) a;
			int den = gcDENOMINATOR(this.denominator, b.denominator);
        	        int mult0 = den/this.denominator;
               		 int mult1 = den/b.denominator;
			int num0 = (mult0 * this.numerator);
			int num1 = (mult1 * b.numerator);
			if (num0 == num1) {
				return 0;
			}
			else if (num0 > num1) {
				return -1;
			}
			else {
				return 1;
			}
		}
		else {
			System.out.println("Ayo that's not a Rational!");
			return -1;
		}
	}

	public boolean equals(Object bob) {
		if (bob instanceof Rational) {
			if (compareTo((Rational) bob)== 0) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			System.out.println("Ayo that's not a Rational!");
			return false;
		}
	}

	public static void main(String[] args){
		Rational r = new Rational(2,3); //Stores the rational number 2/3
		System.out.println(r.toString());
		Rational s = new Rational(1,2); //Stores the rational number 1/2
		System.out.println(s.toString());
		Rational t = new Rational(4,18); //Stores the rational number 4/18
		System.out.println(t.toString());
		r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2
		System.out.println(r.toString());
		System.out.println(s.toString());
		t.reduce(); //Changes t to 2/9
		System.out.println(t.toString());

		r.subtract(s);  //Subtracts r from s, changes r to 4/6.  s remains 1/2
                System.out.println(r.toString());
                System.out.println(s.toString());
		r.reduce();
                System.out.println(r.toString()); //changes r to 2/3
		System.out.println(r.compareTo(s));// -1
		System.out.println(r.compareTo(r));// 0
		System.out.println(s.compareTo(r));//1
	}
}
