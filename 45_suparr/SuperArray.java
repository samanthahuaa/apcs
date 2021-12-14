// Team Frogs (Ruby Friedman, Ivina Wang, Samantha Hua)
// APCS pd07
// HW45 -- Array of Titanium
// 2021-12-09
// Time Spent: 0.75 hrs

/***************************
 * class SuperArray version 2.0
 * Wrapper class for array. Facilitates
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 ***************************/

/**
DISCO:
 * You can create a instance of SuperArray of type ListInt, but you CANNOT
   create an instance of ListInt of type SuperArray. This is because ListInt
   cannot be instantiated because ListInt is abstract.
 * When using an instance of SuperArray of type ListInt you cannot use any methods
   that are in SuperArray but not ListInt.
 * Using an interface ensures that all instances of that class contain specific
   methods. An interface can be used across an inheritance tree.

QCC:
 * When would you choose to implement an interface rather then a superclass or extended
   class?
 * Can you extend a class and implement an interface at the same time?

*/
public class SuperArray implements ListInt
{

  private int[] _data;  //underlying ("encapsulated") container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
    _size = 0;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String foo = "[";
    for( int i = 0; i < _size; i++ ) {
      foo += _data[i] + ",";
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length()-1 );
    foo += "]";
    return foo;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] temp = new int[ _data.length * 2 ];
    for( int i = 0; i < _data.length; i++ )
      temp[i] = _data[i];
    _data = temp;
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    int temp = _data[index];
    _data[index] = newVal;
    return temp;
  }


  //adds an item after the last item
  public void add( int newVal )
  {
    add( _size, newVal );
  }


  //inserts an item at index
  public void add( int index, int newVal )
  {
    //first expand if necessary
    if ( _size >= _data.length )
      expand();
    for( int i = _size; i > index; i-- ) {
      _data[i] = _data[i-1]; //each slot gets value of left neighbor
    }
    _data[index] = newVal;
    _size++;
  }


  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  public void remove( int index )
  {
    for( int i = index; i < _size - 1; i++ ) {
      _data[i] = _data[i+1];
    }
    _size--;
  }


  //return number of meaningful items in _data
  public int size()
  {
    return _size;
  }



  //main method for testing
  public static void main( String[] args ) {
      ListInt hewwo = new SuperArray();
      System.out.print("Empty ListInt test:");
      System.out.println(hewwo);
      hewwo.add(5);
      hewwo.add(4);
      hewwo.add(3);
      hewwo.add(2);
      hewwo.add(1);
      System.out.print("Populated ListInt test:");
      System.out.println(hewwo);

      hewwo.add(3, 45);
      System.out.print("Add 45 at index 3:");
      System.out.println(hewwo);

      System.out.print("Remove the value at index 2:");
      hewwo.remove(2);
      System.out.println(hewwo);

      System.out.print("Meaningful values in this array:");
      System.out.println(hewwo.size());

//    hewwo.set(1, 8); Creates a cannot find symbol error because this method is not in ListInt

  }//end main()


}//end class
