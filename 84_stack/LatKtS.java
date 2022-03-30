/*
Hot Cake: Samantha Hua, Nada Hameed, Ariel Fuchs
APCS
HW84: Stack: What Is It Good For?
2022-03-29
time spent: 1.5hrs.

DISCO:
  - continue is useful when you want the loop to go to the next iteration
  - outlining the algo beforehand is super helpful not only for writing code that
  makes sense but also for debugging

QCC:
  - is there a more efficient way to match up the characters in allMatched()?
  - is a similar algo to allMatched used for auto bracket completetion?
*/

/***
 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/

public class LatKtS
{

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
    Latkes temp = new Latkes(s.length());
    String returnStr = "";

    //making the input into a Stack
    for (int i = 0; i < s.length(); i++) {
      temp.push(s.substring(i,i+1));
    }

    //popping off the items in the stack
    for (int i=0; i<s.length(); i++) {
      returnStr += temp.pop();
    }
    return returnStr;
  }


  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s )
  {
    //open characters
    String open1 = "(";
    String open2 = "{";
    String open3 = "[";

    // closed characters
    String close1 = ")";
    String close2 = "}";
    String close3 = "]";

    int whichMatching = 0;

    Latkes temp = new Latkes(s.length());
    Latkes closers = new Latkes(s.length());

    //making the input into a Stack
    for (int i = 0; i < s.length(); i++) {
      temp.push(s.substring(i,i+1));
    }

    for (int j = 0; j < s.length(); j++) {
        // if it's a closing character, push it to the closers stack
        if (temp.peek().equals(close1) || temp.peek().equals(close2) || temp.peek().equals(close3)) {
          closers.push(temp.peek());
          temp.pop();
          continue;
        }

        // if it's a opener character, check which type of opener it is
        if (temp.peek().equals(open1)) {
          whichMatching = 1;
        } else if (temp.peek().equals(open2)) {
          whichMatching = 2;
        } else if (temp.peek().equals(open3)) {
          whichMatching = 3;
        }

        // knowing which is the matching character, if the closer and the opener
        // are matching, continue the loop or return false
        if (whichMatching == 1 && (closers.peek().equals(close1))) {
          closers.pop();
          temp.pop();
        } else if (whichMatching == 2 && (closers.peek().equals(close2))) {
          closers.pop();
          temp.pop();
        } else if (whichMatching == 3 && (closers.peek().equals(close3))) {
          closers.pop();
          temp.pop();
        } else {
          return false;
        }
        whichMatching = 0;
    }
    // if closers still has stuff in it, return false
    return closers.isEmpty();
  }


  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class
