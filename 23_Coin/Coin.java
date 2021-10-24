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
  }


  /***
      Coin(String,String) --
      precond:
      postcond:
  ***/
  public Coin( String s, String nowFace ) {
	name = s;
	upFace = nowFace;
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
	double probability = Math.random()*bias;
	if(bias >= 0.5){
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
	return this.Coin + ": " + name + " -- " + upFace;
  }

}//end class
