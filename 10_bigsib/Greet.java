/*
Flaming Hot Cheetos (Perry (Salaj Jr.), Courtney (Timothy), Samantha (me) (Poppy)
APCS
HW10 -- Methods that return values that can be used by other methods
2021-10-4
*/
/*
DISCOVERIES
You can call other methods inside a System.out.println statement. (It won't just print out the name of the method)
UNRESOLVED QUESTIONS
No questions as of now.
*/

public class Greet {
    public static void main( String[] args ){
        System.out.println( BigSib.greet("Crosby") );
        System.out.println( BigSib.greet("Stills") );
        System.out.println( BigSib.greet("Nash") );
    }
}
