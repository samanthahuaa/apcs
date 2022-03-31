import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE>
{
  private LinkedList<PANCAKE> _stack;
  private int _stackSize;


  //constructor
  public LLStack()
  {
    //we aren't limited by initial capacity because in a linked list,
    //you can add as many nodes as you want
    _stack = new LinkedList<PANCAKE>();
    _stackSize = 0;
  }// O(1) because it just allocates new memory for _stack


  //means of insertion
  public void push( PANCAKE s )
  {
    if (isFull() == true) return;
    _stack.add(_stackSize, s);
    _stackSize++;
    return;
  }// O(1) because the algo does not iterate through the stack. it just adds a
  // new element to the end


  //means of removal
  public String pop( )
  {
    if (isEmpty()) return "The stack is empty";
    PANCAKE blah = _stack.get(_stackSize - 1);
    _stack.set(_stackSize - 1, null);
    _stackSize--;
    return blah.toString();
  }// O(1) because the algo does not iterate through the stack. it just removes a
  // new element to the end

  public String peekTop() {
    if (isEmpty()) return "empty";
    return (_stack.get(_stackSize - 1)).toString();
  }

  //chk for emptiness
  public boolean isEmpty()
  {
    return _stackSize == 0;
  }// O(1) because it is not dependent on the size of the stack.


  //chk for fullness
  public boolean isFull()
  {
    return _stackSize == _stack.size();
  }
}
