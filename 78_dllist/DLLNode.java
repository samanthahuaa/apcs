/**
TNPG: Hot Cake: Samantha Hua + Poppy, Nada Hameed + Ray, Ariel Fuchs + Skelly Duckler
APCS pd07
HW78 - Double Up
2022-03-017h
time spent: 2.25 hrs.
num of KtS consumed: 3

DISCO:
 - Visualizing what you want to happen with diagrams helps formulate ideas on how
 to actually implement the method
 - adding a new node at the beginning of a list vs the end of a list. they require
 different values to become null and you must account for them seperately
QCC:
 - is there a better way to organize our code? it feel messy and at times, difficult
 to understand the procedure
 - a series of SOP statements are extremely helpful in understanding whether the
 code works as intended
ALGO ADD:
 - if the new node is being placed at the beginning of the list, simply call the
 add() method. (it's algorithm includes checking if the head is null (there are
 no terms in the list) and if so simply adding a new node to the list. if not, the
 node after the one you are adding has a prevValue of the newNode and the newNode
 has a next value of the previous head)
 - if the new node is not being placed at the front of the list, then you walk to the
 node right before the one you are adding. create a new node with the value inputted,
 a null nextNode value, and a prevNode value of the node before the index.
 set the prevNode value of the node after the index to the new node you have just created.
 assign the appropriate nextNode values for the node before the index and the new node
 you have just created.

ALGO REM:
 - if you are removing the first item in a list, remove the node and change the
 prevNode of the new head to null (unless the new head is already null).
 - if you  are removing a node at any other point in the list, change the prevNode
 value of the node after the one you are trying to delete to point to the node before
 the one you are deleting. also change the nextNode value of the node before the one
 you are trying to delete to point to the node after the one you are deleting.
**/

/*****************************************************
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class DLLNode
{
    //instance vars
    private String _cargo;    //cargo may only be of type String
    private DLLNode _nextNode; //pointer to next DLLNode
    private DLLNode _prevNode; // pointer to previous DLLNode

    // constructor -- initializes instance vars
    public DLLNode( String value, DLLNode next, DLLNode prev) {
    	_cargo = value;
	    _nextNode = next;
      _prevNode = prev;
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }

    public DLLNode getPrev() { return _prevNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo ) {
      String foo = getCargo();
      _cargo = newCargo;
      return foo;
    }

    public DLLNode setNext( DLLNode newNext ) {
    	DLLNode foo = getNext();
    	_nextNode = newNext;
    	return foo;
    }

    public DLLNode setPrev( DLLNode newPrev ) {
    	DLLNode foo = getPrev();
    	_prevNode = newPrev;
    	return foo;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }


    //main method for testing
    public static void main( String[] args )
    {

    	//Below is an exercise in creating a linked list...

    	//Create a node
    	DLLNode first = new DLLNode( "cat", null, null );

    	//Create a new node after the first
    	first.setNext( new DLLNode( "dog", null, null ) );
      DLLNode temp = first;
      first.getNext().setPrev(temp);

    	//Create a third node after the second
    	first.getNext().setNext( new DLLNode( "cow", null, null ) );
      temp = first.getNext();
      first.getNext().getNext().setPrev(temp);

      System.out.println(first.getNext().getPrev()); //prints out cat
      System.out.println(first.getNext().getNext().getPrev()); //prints out dog
    }//end main

}//end class DLLNode
