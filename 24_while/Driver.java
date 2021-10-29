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

public class Driver { 
  public static void main( String[] args ) {
	  Coin bob = new Coin();
	Coin natasha = new Coin();
	  int x = 100;
	  int y = 120;
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
