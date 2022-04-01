/***
Hot Cake: Ariel Fuchs + Skelly Duckler, Nada Hameed + Ray, Samantha Hua + Poppy
APCS PD07
HW86 -- What a Racket
2022-04-01
time spent: 2hrs

DISCOS:
- evaluate returns a String (not an array of Strings) value that's at the top of the stack
- we created different if statements based on the operation
- order of the items is important in subtract (and divide), but not add or multiply because they are communative

QCC:
- why did we not have to implement functionality for divide?
- we had a lot of errors regarding converting types

 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. We remove the whitespaces from the input
 *   2. We parse through the input from the right to the left
 *   3. If the chracter is not a ( then we simply add it onto the stack. This is
 because the ( signifies the completion of a equation
 *   4. If it is an operation, we identify it and perform the corresponding math
 on the numbers that follow until we reach the )
 *   5.If the stack has one item in it that is an integer, we return that value.
 *
 * STACK OF CHOICE: ALStack by personal repo
 * b/c it was easiest for us to visualize
 **/

public class Scheme
{
  /***
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/
  public static String evaluate( String expr )
  {
    //remove whitespace from input
    String[] noWhitespace = expr.split(" ");

    //create Stacks
      // holds the values of the input
      //noWhitespace.length
    ALStack main = new ALStack<String>();
    //   // holds the integers being operated on
    // ALStack lil = new ALStack(noWhitespace.size);

    for(int i = noWhitespace.length; i > 0; i--){

      String blah = noWhitespace[i];
      if (blah.equals("(")) {
        //remove the "("
        main.pop();

        String operator = main.pop().toString();

        //addition
        if (operator.equals("+")) {
          int total = Integer.parseInt(main.peekTop());
          while(!main.peekTop().equals(")")) {
            total += Integer.parseInt(main.peekTop());
          }
          //remove ")"
          main.pop();
          main.push(total);
        }
        //subtraction
        else if (operator.equals("-")) {
          int total = Integer.parseInt(main.peekTop());
          while(!main.peekTop().equals(")")) {
            total -= Integer.parseInt(main.peekTop());
          }
          //remove ")"
          main.pop();
          main.push(total);
        }
        //multiplication
        else if (operator.equals("*")) {
          int total = Integer.parseInt(main.peekTop());
          while(!main.peekTop().equals(")")) {
            total *= Integer.parseInt(main.peekTop());
          }
          //remove ")"
          main.pop();
          main.push(total.toString());
        }
      }
      else if (main.size == 1 && main.peekTop().isNumber()) {
        return main.peekTop();
      }
      else {
        main.push(blah);
      }
    }
  }//end evaluate()

  // private static int division(ALStack a) {
  //   int total = 0;
  //   for (int i = 0; i < ALStack.size; i++) {
  //     total /= a.pop();
  //   }

  /***
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   **/
  // public static String unload( int op, Stack<String> numbers )
  // {
  //
  // }//end unload()



  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
    try {
      Integer.parseInt(s);
      return true;
    }
    catch( NumberFormatException e ) {
      return false;
    }
  }


  //main method for testing
  public static void main( String[] args )
  {

      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main()

}//end class Scheme
