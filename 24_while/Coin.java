/*
Square Roots (Samantha Hua and Ruiwen (Raven) Tang)
APCS
HW24 -- Get It While You Can
2021-10-25
time spent: 0.5 hour

DISCO
- We can use || to ensure that the while loop continues to run if one of the conditionals is false.
- Creating counter variables are helpful for referencing that data and for creating boolean expressions with that data.
- We can pass Objects into methods (ex: our equals() method called upon natasha)
- If you use a method in a conditional, it runs the method (ex: bob.flip() in our while loop ran bob.flip when we compared it to "heads" in the if statement)
- If y is less than 65536, "matchCounter % 2005 == 0" is the determining boolean expression in terms of how many matching iterations are needed to complete the while loop.
- When we ran Driver multiple times, we noticed that for the same values of x and y, there were the same number of matches but not the exact same number of heads. 

QCC
- When do we need to use "this"? What are some examples where it would be useful? 
- Can we pass in parameters to the main() method?
- Would it be more beneficial to have a helper method to complete the series of coin pair flips? We decided to put everything in the main method for simplicity.

POST-v0 MODS
- We wrote + utilized the reset() method to streamline our code.

*/

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
	reset("heads", 0.5);
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
	flipCtr = 0;
	tailsCtr = 0;
	headsCtr = 0;
	upFace = s;
	bias = d;
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
