// AllBread (Ivina Wang, Samantha Hua, Jack Chen)
// APCS pd7
// HW53 -- implementing insertion sort
// 2022-01-06r
// time spent: 0.7 hrs

/******************************
 * class InsertionSort -- implements InsertionSort algorithm
 *
 * ALGO:
 * An outer for loop that iterates through each element in the input array
 * An inner for loop that compares each element to the one that comes before import junit.framework.TestCase;
    * If the element with the smaller index is larger than the element with the larger index, they swap places
    * This process continues until the value with the smaller index is less than the element with the larger index
 * DISCO
 * A one item array is always sorted
 * The SOP statements are useful for seeing intermediate steps
 * QCC
 * We think that this method of sorting is less efficient than Selection sort because more swaps are performed
 * q0: How many passes to sort n elements?
 * a0: n-1
 * q1: What do you know after pass p?
 * a1: the leftmost p+1 values are sorted
 * q2: How will you know when sorted?
 * a2: when you sort the last value in the array -->  when you reach n-1 passes
 * q3: What constitues a pass?
 * a3: adding a value to the sorted region and sorting it
 * q4: What must you track?
 * a4: the size of the sorted/unsorted region
 ******************************/


import java.util.ArrayList;

public class InsertionSort
{
  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void insertionSortV( ArrayList<Comparable> data )
  {
    for(int partition = 1; partition < data.size(); partition++) {
      //partition marks first item in unsorted region

      System.out.println( "\npartition: " + partition + "\ndataset: "); //diag
      System.out.print( data +"\n");


      //traverse sorted region from right to left
      for(int i=partition; i > 0; i--) {

        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if (data.get(i).compareTo(data.get(i-1)) < 0) {
          System.out.println( "swap indices "+(i-1)+" & "+i+"..." ); //diag

          Comparable currentleast = data.get(i);
          Comparable origposition = data.get(i - 1);

          data.set(i - 1, currentleast);
          data.set(i, origposition);
        }
        else
          break;
      }
    }
  }//end insertionSortV


  // ArrayList-returning insertionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable>
    insertionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    insertionSortV( data );

    //return working ArrayList
    return data;
  }//end insertionSort


  public static void main( String [] args )
  {
      /*===============for VOID methods=============
      System.out.println("\n*** Testing sort-in-place (void) version... *** ");
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      insertionSortV(glen);
      System.out.println( "\nArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      insertionSortV(coco);
      System.out.println( "\nArrayList coco after sorting:\n" + coco );

      ============================================*/

      System.out.println( "*** Testing non-void version... *** " );
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = insertionSort( glen );
      System.out.println( "\nsorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "\nArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = insertionSort( coco );
      System.out.println( "\nsorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "\nArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
      /*==========for AL-returning methods==========

      ============================================*/

  }//end main

}//end class InsertionSort
