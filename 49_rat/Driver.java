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
 * How can we implement this into other projects, when would we want to put an interface into compliance with a class?
 * How many test cases is sufficent to prove that class Rational is in compliance with the Comparable interface

**/

public class Driver {
	public static void main(String[] args){
		Rational hewwo = new Rational(1, 2);
		Rational byebye = new Rational(1, 2);
		Rational greetings = new Rational(3, 4);
		Rational salutations = new Rational(1, 4);
		String uhoh = new String("*pretending to be a rational!");
		int imposter = 5;

		System.out.println(hewwo.equals(byebye)); //true
		System.out.println(hewwo.equals(greetings));//false
		System.out.println(salutations.equals(uhoh));//error and false
		System.out.println(hewwo.equals(imposter));//error and false
	}
}
