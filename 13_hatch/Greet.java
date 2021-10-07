/*
Frogs on Fire: Andrew Piatetsky and Samantha Hua
APCS
HW13 -- Using a Constructor to Simplify the Process
2021-10-06
*/
/*
Discoveries:
Constructors must be in the class that it is for.
You can pass arguments into constructors
QCC:
What's a real life example of the usage of a constructor?
*/
public class Greet {
  
  public static void main( String[] args ) {
    String greeting;

    BigSib richard = new BigSib("Word up");
//     richard.setHelloMsg("Word up ");

    greeting = richard.greet("freshman");
    System.out.println(greeting);

  } 
} 
