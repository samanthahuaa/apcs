/*
Flaming Hot Cheetos (Perry (Salaj Jr.), Courtney (Timothy), Samantha (me) (Poppy)
APCS
HW12 -- Passing methods into other classes + Utilizing return statements in methods + new function
2021-10-05
*/
/*
Discoveries
\n will create a new line in the output even if it's in quotations
the new function doesn't seem to create another file but it runs the same way as the funcion it calls
QCC
What is the new function good for? In what situations would it be better to use new rather than the actual file itself?
*/

public class Greet {
  public static void main( String[] args ) {
    String greeting;

    BigSib richard = new BigSib();
    richard.setHelloMsg("Word up");

    greeting = richard.greet("freshman");
    System.out.println(greeting);

  } //end main()
} //end Greet
