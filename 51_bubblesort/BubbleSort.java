// Team Frogs (Ivina Wang, Samantha Hua, Ruby Friedman)
// APCS pd07
// HW51 -- implementing bubblesort
// 2022-01-04t
// time spent: 1.5  hrs

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 *
 * ALGO:
 * Start from the rightmost value and compare it to the val directly to the left of it. If the val to the left is greater
 * Swap the 2 vals and continue moving down the array to the right while comparing the next 2 vals.
 * After getting to the end repeat this method of passing until the array is fully sorted, which is when
 * number of vals in the array-1 passes are achieved
 *
 * DISCO
 * You cannot initialize a variable with the same name as an already initialized variable
 * Swapping 2 items at a time rather then creating a new array saves memory and time
 *
 * QCC
 * Why do we search from right to left rather then left to right, is there a benifit to this or is it just the convention?
 * Is this the most efficent method of sorting? If not then what is?
 * Is it worth it to change the algorithm so it doesnt look at values that are already guaranteed to be sorted?
 *
 * q0: If a pass requires no swaps, what do you know?
 * a0: The array is sorted
 * q1: After pass p, what do you know?
 * a1: the left most p values are sorted
 * q2: How many passes are necessary to completely sort?
 * a2: number of items in the array - 1
 *
 ******************************/

import java.util.ArrayList;

public class BubbleSort {

	//~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
	//precond:  lo < hi && size > 0
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
		//setup for traversal fr right to left
		for( int i = al.size()-1; i > 0; i-- ) {
			//pick an index at random
			randomIndex = (int)( (i+1) * Math.random() );
			//swap the values at position i and randomIndex
			al.set( i, al.set( randomIndex, al.get(i) ) );
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


	// VOID version of bubbleSort
	// Rearranges elements of input ArrayList
	// postcondition: data's elements sorted in ascending order
	public static void bubbleSortV( ArrayList<Comparable> data ) {
		int len = data.size();
		int passNum = 0;
		while (passNum < len) {
			for (int i = len-1;i>0;i--) {
				if (data.get(i).compareTo(data.get(i-1)) < 0){ //need to swap
					Comparable foo = data.get(i);
					data.set(i, data.get(i-1));
					data.set(i-1, foo);
				}
			}
			passNum += 1;
		}
	}


	// ArrayList-returning bubbleSort
	// postcondition: order of input ArrayList's elements unchanged
	// Returns sorted copy of input ArrayList.
	public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) {
		ArrayList<Comparable> result = new ArrayList<Comparable>();
		for (int i = 0; i<input.size();i++) {
			result.add(input.get(i));
		}
		bubbleSortV(result);
		return result;
	}


	public static void main( String [] args ) {
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );

      ArrayList glen1 = new ArrayList<Integer>();
      glen1.add(7);
      glen1.add(1);
      glen1.add(5);
      glen1.add(12);
      glen1.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen1 );
      ArrayList glenSorted = bubbleSort( glen1 );
      System.out.println( "sorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen1 );

      ArrayList coco1 = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco1 );
      ArrayList cocoSorted = bubbleSort( coco1 );
      System.out.println( "sorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco1 );
      System.out.println( coco1 );
  }//end main

}//end class BubbleSort
