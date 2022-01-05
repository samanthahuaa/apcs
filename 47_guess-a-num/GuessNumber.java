// Team Frogs (Ruby Friedman, Ivina Wang, Samantha Hua)
// APCS pd07
// HW47 -- Guess Again
// 2021-12-15
// time spent: 0.5 hrs

/***
 * class GuessNumber -- fun fun fun!
 *
 * eg, sample interaction with end user:
 *
 * Guess a # fr 1-100: 50
 * Too high
 * Guess a # fr 1-49: 25
 * Too low
 * Guess a # fr 26-49: 38
 * Correct! It took 3 guesses
 ***/

/***
    DISCO:
    * If your plan is succint and accurate, the implementation of it should be quick and painless.
    * return; allows the method to finish running in a void method without breaking.
    * The base case is very similar for both iterative and recursive methods.

    QCC:
    * How do we prevent the user from inputing out of bound inputs, (ex: range is 30-70 and user inputs 75)
    * If while (true) keeps running until a return or break, what does while (false) do?
    * Why is it better to have a while (true) statement as opposed to a conditional?

 ***/
import java.util.Scanner;

public class GuessNumber {

  //instance vars
  private int _lo, _hi, _guessCtr, _target;
  Scanner sc = new Scanner( System.in );


  /*==================================================
    constructor -- initializes a guess-a-number game
    pre:
    post: _lo is lower bound, _hi is upper bound,
    _guessCtr is 1, _target is random int on range [_lo,_hi]
    ==================================================*/
  public GuessNumber( int a, int b ) {
    _lo = Math.min(a,b);
    _hi = Math.max(a,b);
    _guessCtr = 1;
    //pick random number in range [a,b]
    _target = (int) (Math.random()*(_hi - _lo)) + _lo;

  }


  /*==================================================
    void playRec() -- Prompts a user to guess until guess is correct.
    Uses recursion.
    ==================================================*/
  public void playRec() {
    System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
    int guess = sc.nextInt();

    //3 cases: we either found it, too hi, too lo
    if (_target == guess) {
      System.out.println("Correct! It took "+_guessCtr+" guesses");
      return;
    }
    else if (_target > guess) {
      System.out.println("Too low");
      _lo = guess + 1;
      _guessCtr++;
      playRec();
    }
    else if (_target < guess) {
      System.out.println("Too high");
      _hi = guess - 1;
      _guessCtr++;
      playRec();
    }
  }


  /*==================================================
    void playIter() -- Prompts a user to guess until guess is correct.
    Uses iteration.
    ==================================================*/
  public void playIter() {

    int guess;

    while( true ) {
      System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
      guess = sc.nextInt();
      //3 cases: we either found it, too hi, too lo
      if (_target == guess) {
 	System.out.println("Correct! It took "+_guessCtr+" guesses");
      	return;
      }
      else if (_target > guess) {
        System.out.println("Too low");
        _lo = guess + 1;
      }
      else if (_target < guess) {
        System.out.println("Too high");
        _hi = guess - 1;
      }
      _guessCtr++;
    }
  }


  //wrapper for playRec/playIter to simplify calling
  public void play() {
    //use one or the other below:
   // playRec();
    playIter();
  }


  //main method to run it all
  public static void main( String[] args )
  {
    //instantiate a new game
    GuessNumber g = new GuessNumber(1,100);

    //start the game
    g.play();
  }

}//end class GuessNumber
