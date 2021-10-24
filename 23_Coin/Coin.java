/*
Square Roots (Samantha Hua and Ruiwen (Raven) Tang)
APCS
HW23 -- What Does Equality Look Like?
2021-10-23
time spent: 0.7 hour

DISCO
- We should read ahead before we start coding in order to minimize confusion. 
(For the toString() method we were trying to complete tasks that we are not capable of doing given the things we have learned in class.)
- Even though we didn't use "this," we learned that it is used by an object to reference itself.
- We realized we needed to set upFace to heads in all of the constructors in order for our code to behave the way we wanted it to.
- If bias does not have a value set in the constructor, its value will automatically be 0 meaning that the probability of the coin flipping to heads would be 0 regardless of what Math.random() is.
- If Math.random()*bias is not multiplied by two, the probability of the coin flipping to heads would still be 0. This is because the max value for Math.random() is 0.999 so when multiplied by 0.5(the value we set for bias), probability will never reach 0.5.

QCC
- Is it possible to call upon an object's name?
	ex: ClassName ObjectName = new ClassName(); a function that would return ObjectName
- Is there a more organized way to determine probability using bias? (especially when there are more than 2 options to choose from)
- Does "Coin other" as an input refer to another object? How do we know which Object it is referring to? How can it reference an instance of a Class inside an instance of the same Class?
*/

/***
 *  class Coin
 *  by Clyde "Thluffy" Sinclair
 *  SKELETON
 ***/

public class Coin {

  //attributes aka instance vars
	double value; //stores monetary worth
	String upFace; 
	String name;
	int flipCtr;
	int headsCtr;
	int tailsCtr;
	double bias;

  /***
   *  Coin() -- default constuctor
   *  precond:
   *  postcond:
   ***/
  public Coin() {
	upFace = "heads";
	bias = 0.5;
  }


  /***
      Coin(String) -- overloaded constructor
      precond: input is one of
      "penny",
      "nickel",
      "dime",
      "quarter",
      "half dollar",
      "dollar"
      postcond:
  ***/
  public Coin( String s ) {
	name = s;
	upFace = "heads";
	bias = 0.5;
  }


  /***
      Coin(String,String) --
      precond:
      postcond:
  ***/
  public Coin( String s, String nowFace ) {
	name = s;
	upFace = nowFace;
	bias = 0.5;
  }

/* in order to compile our code 
  // Accessors...
  // ----------------------------
  public String getUpFace() {
  }
  public int getFlipCtr() {
	
  }
  public double getValue() {
  }
  public int getHeadsCtr() {
  }
  public int getTailsCtr() {
  }
  // ----------------------------
*/
  /***
   * assignValue() -- set a Coin's monetary value based on its name
   * precond:  input String is a valid coin name ("penny", "nickel", etc.)
   * postcond: instvar value gets appropriate value
   * Returns value assigned.
   ***/
  private double assignValue( String s ) {
	if(s == "penny"){
		value = 0.01;
	}
	else if(s == "nickel"){
		value = 0.05;
	}
	else if(s == "dime"){
		value = 0.10;
	}
	else if(s == "quarter"){
		value = 0.25;
	}
	else if(s == "half dollar"){
		value = 0.50;
	}
	else{
		value = 1.00;
	}
	return value; 
  }


  /***
      reset() -- initialize a Coin
      precond:  s is "heads" or "tails", 0.0 <= d <= 1.0
      postcond: Coin's attribs reset to starting vals
  ***/
  public void reset( String s, double d ) {

  }


  /***
   * String flip() -- simulates a Coin flip
   * precond:  bias is a double on interval [0.0,1.0]
   * (1.0 indicates always heads, 0.0 always tails)
   * postcond: upFace updated to reflect result of flip.
   * flipCtr incremented by 1.
   * Either headsCtr or tailsCtr incremented by 1, as approp.
   * Returns "heads" or "tails"
   ***/
  public String flip() {
	double probability = 2*Math.random()*bias;
// 	System.out.println(probability);
	if(probability >= 0.5){
		headsCtr += 1;
		upFace = "heads";
	}
	else{
		tailsCtr += 1;
		upFace = "tails";
	}
	flipCtr += 1;
	return upFace;
  }


  /***
   * boolean equals(Coin) -- checks to see if 2 coins have same face up
   * precond: other is not null
   * postcond: Returns true if both coins showing heads
   * or both showing tails. False otherwise.
   ***/
  public boolean equals( Coin other ) {
	if(upFace == other.upFace){
		return true;
	}
	else{
		return false;
	}
  }


  /***
   * String toString() -- overrides toString() provided by Java
   * precond: n/a
   * postcond: Return String comprised of name and current face
   ***/
  public String toString() {
	return name + " -- " + upFace;
  }

}//end class
