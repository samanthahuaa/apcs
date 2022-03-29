/*
Hot Cake: Nada Hameed, Samantha Hua, Ariel Fuchs
APCS pd.7
HW83: Stacks on Stacks
2022-03-28
time spent: 0.5 hrs
*/

/***
 * class Latkes
 * v1
 * SKELETON
 * Implements a stack of Strings using an encapsulated array
 **/

/***
    DISCO
      - isFull and isEmpty are very simple methods when we use _stackSize
      - To summarize stack, we are only able to touch the top element of the stack.

    QCC
      -Do we push/pop at the beginning or the end of the array?
        We think it is more efficient to do so at the end of the array to reduce
        run time. We believe it also performs the same thing as pushing/popping
        at the end of an array. We would just consider the end of the array to be
        the first element of the stack
 **/


public class Latkes
{
  private String [] _stack;
  private int _stackSize;


  //constructor
  public Latkes( int initCapacity )
  {
    _stack = new String[initCapacity];
    _stackSize = 0;
  }// O(1) because it just allocates new memory for _stack


  //means of insertion
  public void push( String s )
  {
    if (isFull() == true) return;
    _stack[_stackSize] = s;
    _stackSize++;
    return;
  }// O(1) because the algo does not iterate through the stack. it just adds a
  // new element to the end


  //means of removal
  public String pop( )
  {
    if (isEmpty() == true) return "The stack is empty";
    _stack[_stackSize - 1] = null;
    _stackSize--;
    return "Success!";
  }// O(1) because the algo does not iterate through the stack. it just removes a
  // new element to the end


  //chk for emptiness
  public boolean isEmpty()
  {
    return _stackSize == 0;
  }// O(1) because it is not dependent on the size of the stack.


  //chk for fullness
  public boolean isFull()
  {
    return _stackSize == _stack.length;
  }// O(1) because it is not dependent on the size of the stack

  // public void printTheThingOut() {
  //   for (int i=0; i < _stackSize; i++) {
  //     System.out.println(_stack[i]);
  //   }
  // }
  //main method for testing
  public static void main( String[] args )
  {

    Latkes tastyStack = new Latkes(10);

    tastyStack.push("aoo");
    tastyStack.push("boo");
    tastyStack.push("coo");
    tastyStack.push("doo");
    tastyStack.push("eoo");
    tastyStack.push("foo");
    tastyStack.push("goo");
    tastyStack.push("hoo");
    tastyStack.push("ioo");
    tastyStack.push("joo");
    tastyStack.push("coocoo"); // stack is full
    tastyStack.push("cachoo"); // stack is full

    // tastyStack.printTheThingOut();
    //cachoo
    System.out.println( tastyStack.pop() );
    //coocoo
    System.out.println( tastyStack.pop() );
    //joo
    System.out.println( tastyStack.pop() );
    //ioo
    System.out.println( tastyStack.pop() );
    //hoo
    System.out.println( tastyStack.pop() );
    //goo
    System.out.println( tastyStack.pop() );
    //foo
    System.out.println( tastyStack.pop() );
    //eoo
    System.out.println( tastyStack.pop() );
    //doo
    System.out.println( tastyStack.pop() );
    //coo
    System.out.println( tastyStack.pop() );
    //boo
    System.out.println( tastyStack.pop() );
    //aoo
    System.out.println( tastyStack.pop() );

    //stack empty by now; SOP(null)
    System.out.println( tastyStack.pop() );
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes
