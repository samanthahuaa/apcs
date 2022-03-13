/**
TNPG: Hot Cake: Samantha Hua + Poppy, Nada Hameed + Ray, Ariel Fuchs + Skelly Duckler
APCS pd07
HW75 - Nodal Recall
2022-03-014m
time spent:
**/

/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode
{
  //instance vars
  private String car;
  private LLNode cdr;

  // constructor
  public LLNode( String value, LLNode next )
  {
    car = value;
    cdr = next;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return car;
  }

  public LLNode getNext()
  {
    return cdr;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    car = newCargo;
    return car;
  }

  public LLNode setNext( LLNode newNext )
  {
    cdr = newNext;
    return cdr;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    // we realized that the following code does not work repeatedly because it
    // overwrites data which can not be retreived
    // ex: we tested System.out.println(first) three times and the outputs were:
    // cat dog cow
    // cat
    // cat

    // String output = car + " ";
    //
    // while (cdr != null) {
    //   output += cdr.getCargo() + " ";
    //   cdr = cdr.getNext();
    // }
    // return output;

    // as a solution, we created a variable to track the current node we are
    // looking at and changed its value as we shifted to other parts of the tree.

    LLNode currentCdr = cdr;
    String output = car + " ";

    while (currentCdr != null) {
      output += currentCdr.getCargo() + " ";
      currentCdr = currentCdr.getNext();
    }

    return output;
  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    LLNode first = new LLNode( "cat", null );

    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );

    System.out.println(first);
    System.out.println(first);
    System.out.println(first);
    
    /* A naive list traversal, has side effects.... ??
       while( first != null ) {
       System.out.println( first );
       first = first.getNext();
       }
    */

    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    // the same  node gets overwritten so data from previous nodes would be lost.

    //...so better: ?
    // we decided to have a variable to store the value of the current node
    // we are looking at.
    //

  }//end main

}//end class LLNode
