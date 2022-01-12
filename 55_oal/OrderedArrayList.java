// TNPG: AllBread (Ivina Wang, Samantha Hua, Jack Chen)
// APCS pd07
// Lab02 -- utilizing ArrayList, designing and implementing a wrapper class
// 2022-01-11
// Time spent: 0.6 hrs

/**********************************************
 * DISCO:
 * Big O tracks the # of times the program repeats itself
 * Bubble sort can be of the vanilla flavor or exit-early flavor
 * Big O can have the same classification for the best and worst cases
 * QCC:
 * If the best and worst case are the same scenario, is it considered a moot case?
 * If a method is inside another method with a different Big O classification,
  which one determines the big O classification as a whole?
 **********************************************/


import java.util.ArrayList;

public class OrderedArrayList
{

  // instance of class ArrayList, holding objects of type Integer
  // (i.e., objects of a class that implements interface Integer)
  private ArrayList<Integer> _data;


  // default constructor
  // initializes instance variables
  public OrderedArrayList()
  {
    _data = new ArrayList<Integer>();
  }


  //pass-tru functionality
  public String toString()
  {
    return _data.toString();
  }


  //pass-tru functionality
  /* -- remove
  * Big O classification of O(n)
  * Best Case: index is the last element
  * In the Best Case, the elements would not have to be shifted to the left
  * Worst Case: index is at the beginning, index is occupied
  * In the Worst Case, all the elements would have to be moved over to the left

  */
  public Integer remove( int index )
  {
    return _data.remove(index);
  }



  //pass-tru functionality
  /* -- size
  * Time complexity of O(1)
  * Point is moot, there is no best or worst case scenario because it has a time complexity
  of O(1). This means that regardless of the size of the array the method will take
  the same amount of time.
  */
  public int size()
  {
    return _data.size();
  }

  //pass-tru functionality
  /* -- get
  * Time complexity of O(1)
  * Point is moot, there is no best or worst case scenario because it has a time complexity
  of O(1). This means that regardless of the size of the array the method will take
  the same amount of time.
  */
  public Integer get( int index )
  {
    return _data.get(index);
  }

  /* -- set
  * Time complexity of O(1)
  * Point is moot, there is no best or worst case scenario because it has a time complexity
  of O(1). This means that regardless of the size of the array the method will take
  the same amount of time.
  */
  public int set( int index, int newVal )
  {
    int temp = _data[index];
    _data[index] = newVal;
    return temp;
  }


  //modified functionality
  //insert at appropriate location to maintain sortedness
  /* -- add (boolean)
  * Time complexity of O(1)
  * Point is moot, there is no best or worst case scenario because it has a time complexity
  of O(1). This means that regardless of the size of the array the method will take
  the same amount of time.
  * Big O classification can be O(n) if there is no more space in the array. It
  would then have to copy the contents of the previous array into a new one that
  is one index greater.
  */

  public boolean add( Integer newVal )
  {
    //call exactly 1 of the helper methods below...  your favorite?

    addLinear(newVal);
    //addBinary(newVal);
    return true;
  }

  /* -- add (void)
  * Big O classification of O(n)
  * Best Case: index is the last element, index unoccupied
  * Best Case does not involve having to shift elements
  * Worst Case: index is the first element, index occupied
  * In the Worst Case, every element after the first would have to be shifted
  */
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



  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a linear search to find appropriate index
  /* -- addLinear (void)
  * Best Case: newVal is the least value, classification of O(1)
  * In the Best case, it would not have to iterate through the entire array
  to add the newVal where it belongs
  * Worst Case: newVal is the greatest value, classification of O(n)
  * You would have to iterate through the entire array before you can insert
  */
  public void addLinear(Integer newVal)
  {
    for( int p = 0; p < _data.size(); p++ ) {
      if ( newVal.compareTo( _data.get(p) ) < 0 ) {
        //newVal < oal[p]
        _data.add( p, newVal );
        return; //Q:why not break?
      }
    }
    _data.add( newVal ); //newVal > every item, so add to end
  }


  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a binary search to find appropriate index
  /* -- addBinary (void)
  * Best Case: index is the middle element, classification of O(1)
  * The target is always found in the first search so the method exits early.
  * Worst Case: index is on either extreme, classification of O(log2(n))
  * You have to utilize the maximum number of iterations so that the alogrithm can
  iterate through the array log2(n) times where n is the size of the array.
  */
  public void addBinary(Integer newVal)
  {
    //initialize high, low, midpt indices
    int lo = 0;
    int med = 0;
    int hi = _data.size()-1;

    while ( lo <= hi ) { //running until target is found or bounds cross

      med = (lo + hi) / 2;
      int x = _data.get(med).compareTo( newVal );

      if ( x == 0 ) {
        //equal value found, insert here
        _data.add( med, newVal );
        return;
      }
      else if ( x > 0 )
        //newVal < med, so look at lower half of data
        hi = med - 1;
      else
        //newVal > med, so look at upper half of data
        lo = med + 1;
    }
    // If you made it this far, newVal is not present.
    // So insert at lo.
    _data.add( lo, newVal );
    //Q: How do you know lo is correct insertion index?
  }


}//end class OrderedArrayList
