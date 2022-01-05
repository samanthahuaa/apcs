// TNPG: AllBread (Samantha Hua, Ivina Wang, Jack Chen)
// APCS pd7
// HW52 -- implementing selection sort
// 2022-01-05w
// time spent: 0.8 hrs

/******************************
 *   class SelectionSort -- implements SelectionSort algorithm
 *
 * ALGO:
 * We iterated through each item of the array to check if it was the least value,
 and if it wasn't, we would swap it with the least value.
 * DISCO:
 * You can use foreach loop to create new array list and populate the array with
 the same values as the original target.
 * To prevent checking values you already know to be sorted, we utilized maxPos as
 the starting index of where to start checking. We can do this because maxPos
 corresponds with how many numbers we know to be sorted
 * QCC:
 * q0: How many passes to sort n elements?
 * a0: n - 1 passes
 * q1: What do you know after pass p?
 * a1: The first p elements are in their sorted positions
 * q2: How do you know if sorted?
 * a2: After you reach the last item in the array and complete all neccessary swaps
 * q3: What does a pass boil down to?
 * a3: To perform a swap.
 * We think that BubbleSort's best case scenario would be if the array was already
  sorted, and that its worst case scenario would be if the array was in descending order
 * Same thing for SelectionSort. Worst case scenario is any array that is not already sorted
  because the algorithm iterates through every item regardless. With every pass there is
  at most one swap so the order of the numbers do not matter.
 ******************************/


import java.util.ArrayList;

public class SelectionSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi )
  {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSortV( ArrayList<Comparable> data )
  {
    //note: this version places greatest value at "rightmost" end

    //maxPos will point to position of SELECTION (greatest value)
    int maxPos;

    for (int pass = 0; pass < data.size(); pass ++ ) {
      System.out.println( "\nbegin pass " + (pass) );//diag
      maxPos = pass;

      for (int i = maxPos; i < data.size(); i ++) {

        System.out.println( data );//diag

        if (data.get(maxPos).compareTo(data.get(i)) > 0) {
          maxPos = i;
        }

        System.out.println( "maxPos: " + maxPos );//diags

      } // for loop

        Comparable currentleast = data.get(maxPos);
        Comparable origposition = data.get(pass);

        data.set(pass, currentleast);
        data.set(maxPos, origposition);

      System.out.println( "after swap: " +  data );//diag
    } // for loop
  }//end selectionSort


  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    selectionSortV( data );

    return data;
  }//end selectionSort


  public static void main( String [] args )
  {

    /*===============for VOID methods=============
    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    selectionSortV(glen);
    System.out.println( "ArrayList glen after sorting:\n" + glen );

    ArrayList coco = populate( 10, 1, 1000 );
    System.out.println( "ArrayList coco before sorting:\n" + coco );
    selectionSortV(coco);
    System.out.println( "ArrayList coco after sorting:\n" + coco );


      ============================================*/


      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = selectionSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = selectionSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      /*==========for AL-returning methods==========
      ============================================*/

  }//end main

}//end class SelectionSort
