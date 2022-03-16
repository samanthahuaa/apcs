// Clyde Sinclair
// APCS pd0
// HW76 -- implement linked list
// 2022-03-14m
// time spent: 1 hrs
// # of kts's used: 2


/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data

 DISCO:
 - we do not call _head after initializing tmp
 - tracing and visualizing how we want the algorithm to work helps us implement it into our code

 QCC:
 - what's the significance of the boolean/String return types of remove/add?
 - why is add at index a void method, and without an index a boolean method

 ALGO ADD:
 - we walk to the node before the index and then create a new node with the car newVal and the cdr of the
 next node. we then change the cdr of the node before the index to point to the new node we created with
 newVal.

 ALGO REM:
 - we walk to the node before the index, and then we change the cdr of the previous node to the node after
 the node at the index.
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    LLNode tmp = new LLNode( newVal, _head );
    _head = tmp;
    _size++;
    return true;
  }

  public void add(int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    if (index == 0){
      LLNode tmp = new LLNode( newVal, _head );
      _head = tmp;
      _size++;
      return;
    }
    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index-1; i++ ){
      tmp = tmp.getNext();
}

    LLNode newTon = new LLNode (newVal, tmp.getNext());
    tmp.setNext(newTon);

    _size++;

    return;
  }

  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    String retVal;
    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //store target node's cargo
    String oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    LLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }

  public String remove(int index){
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

      LLNode tmp = _head; //create alias to head

      //walk to desired node, which is the node before the one that we want to remove
      for( int i=0; i < index-1; i++ )
        tmp = tmp.getNext();

      String oldVal = tmp.getCargo();
      tmp.setNext(tmp.getNext().getNext());

      return oldVal;
  }

  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println("REMOVE\n");
    System.out.println( james );

    james.remove(1);

    System.out.println( james );

    System.out.println("ADD\n");
    james.add(0, "donut");

    System.out.println( james );

  }

}//end class LList
