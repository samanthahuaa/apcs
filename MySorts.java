import java.util.ArrayList;
public class Sorts {

  /* bubbleSort
     * Starting from the 2 leftmost elements in the array, check to see
     if the element on the left is greater than the one on the right. If so,
     swap the two values. Move on to the next index and check.
     Continue to do this until you reach to the rightmost
     elements. This will complete 1 pass. Continue to pass through the array
     until the number of passes reaches the array length (in total, the number
     of passes is 1 less than the length of the array because passCtr is intialized at 1.)
  */
  public static void bubbleSortV( ArrayList<Comparable> data )
 {

   for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
     System.out.println( "commencing pass #" + passCtr + "..." );

     //iterate thru first to next-to-last element, comparing to next
     for( int i = 0; i < data.size()-1; i++ ) {

       //if element at i > element at i+1, swap
       if ( data.get(i).compareTo(data.get(i+1) ) > 0 )
         data.set( i, data.set(i+1,data.get(i)) );

       //System.out.println(data); //diag: show current state of list
     }
   }

 } // bubble

  /* insertionSort
    * Compare the leftmost two values and check if the one on the right is greater
    than the one on the left. If not, swap. These values make up the "sorted region".
    Look at the third value and compare it to the sorted region. Swap until the three
    values are sorted (the sorted region expands to the size of 3). Keep adding new
    values from the unsorted region and sorting them so that the sorted region expands.
    Do this until all values have been sorted.
    * key: a one item array is always sorted
  */

  public static void insertionSortV(ArrayList<Comparable> data) {
    int counter = 0;
    int numCompare = 0;
    for(int partition = 1; partition < data.size(); partition++) {
      //partition marks first item in unsorted region

      // System.out.println( "\npartition: " + partition + "\ndataset: "); //diag
      // System.out.print( data +"\n");


      //traverse sorted region from right to left
      for(int i=partition; i > 0; i--) {
        numCompare += 1;
        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if (data.get(i).compareTo(data.get(i-1)) < 0) {
          // System.out.println( "swap indices "+(i-1)+" & "+i+"..." ); //diag
	        data.set( i, data.set(i-1,data.get(i)) );

          counter += 1;
        }
        else
          break;
      }
    }
      System.out.println("Number of swaps: " + counter);
      System.out.println("Number of comparisons: " + numCompare);
  } // insertion

/* selectionSort
   * Iterate through the array to determine the smallest value. Set it equal to
   the first index of the array. Iterate through the array again, this time only
   looking at the values that you do not know for certain to be sorted (the values
   you have not set yet). Continue iterating and swapping until the last value
   has been sorted.
*/

  public static void selectionSortV(ArrayList<Comparable> data) {
    int maxPos;
    int counter = 0;
    int numCompare = 0;

        for( int pass = data.size()-1; pass > 0; pass-- ) {
          // System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
          maxPos = 0;
          for( int i = 1; i <= pass; i++ ) {
            // System.out.println( "maxPos: " + maxPos );//diag
            // System.out.println( data );//diag
            numCompare += 1;
            if ( data.get(i).compareTo( data.get(maxPos) ) > 0 )
              maxPos = i;

          }
          data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
          counter += 1;
          // System.out.println( "after swap: " +  data );//diag
        }
        System.out.println("Number of swaps: " + counter);
        System.out.println("Number of comparisons: " + numCompare);
  } // selection


} // end class
