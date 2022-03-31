/***
TNPG: Hot Cake: Ariel Fuchs + Skelly Duckler, Samantha Hua + Poppy, Nada Hameed + Ray
APCS PD07
HW 85 -- Leon Leonwood Stack
time spent: 0.8hrs

DISCO:
- we have to import LinkedList
- in the main method, we have to specify the type of the stack when we initialize it

QCC:
- in what scenarios would it be better to have an ALStack versus a LLStack?

 * class Stckr
 * SKELETON
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 **/

public class Stckr
{
  public static void main( String[] args )
  {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /*
    Stack<Integer> hotCakes = new ALStack<Integer>(5);
    hotCakes.push(1);
    hotCakes.push(2);
    hotCakes.push(3);
    hotCakes.push(4);
    hotCakes.push(5);
    System.out.println("finished adding");

    hotCakes.pop();
    hotCakes.pop();
    hotCakes.pop();
    hotCakes.pop();
    hotCakes.pop();
    hotCakes.pop();
    System.out.println("finished popping no more cake");
    */

    Stack<Integer> hotCakes = new LLStack<Integer>();
    hotCakes.push(1);
    hotCakes.push(2);
    hotCakes.push(3);
    hotCakes.push(4);
    hotCakes.push(5);
    System.out.println("finished adding");

    hotCakes.pop();
    hotCakes.pop();
    hotCakes.pop();
    hotCakes.pop();
    hotCakes.pop();
    hotCakes.pop();
    System.out.println("finished popping no more cake");
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //...

  }//end main

}//end class
