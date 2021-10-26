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

public class Driver { 
  public static void main( String[] args ) {
	  Coin bob = new Coin();
	Coin natasha = new Coin();
	  int x = 100000000;
	  int y = 1;
	  int totalHeads = 0;
	  int matchCounter = 0;
	  while(totalHeads < x || matchCounter < y || matchCounter < 65536 || matchCounter%2005 != 0){
		  if(bob.flip() == "heads"){
			  totalHeads += 1;
		  }
		  if(natasha.flip() == "heads"){
			  totalHeads += 1;
		  }
		  if(bob.equals(natasha)){
			  matchCounter += 1;
		  }
	  }
	  int totalFlips = bob.flipCtr + natasha.flipCtr;
	  System.out.println("Success!");
	  System.out.println("The total number of flips was: " + totalFlips);
	  System.out.println("The total amount of heads was: " + totalHeads);
	  System.out.println("The total number of matches was: " + matchCounter);
	  
	  
	  
    //build Objects from blueprint specified by class Coin

    //test default constructor
    /*
      Coin mine = new Coin();
      //test 1st overloaded constructor
      Coin yours = new Coin( "quarter" );
      //test 2nd overloaded constructor
      Coin wayne = new Coin( "dollar", "heads" );
	  
      //test toString() methods of each Coin
      System.out.println("mine: " + mine);
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);
	
      //test flip() method
      System.out.println("\nAfter flipping...");
      yours.flip();
      wayne.flip();
	  
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);
	  
      //test equals() method
      if ( yours.equals(wayne) ) {
        System.out.println( "Matchee matchee!" );
      }
      else {
        System.out.println( "No match. Firestarter you can not be." );
      }
	  */

  }//end main()

}//end class
