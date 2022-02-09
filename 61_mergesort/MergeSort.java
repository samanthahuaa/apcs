/***
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  merge:
  * Initialize 2 counters that are equal to 0, one for each array.
  * Given 2 arrays, compare the values in the index of the counter in both of them.
  * Add lower value to final array.
  * Increment counter of the array of the lower value by 1.
  * Keep comparing until the end of one of the arrays has been reached.
  * Add all remaining values of the other array.
  * Return the final array.
  sort:
  * Initialize 2 arrays with sizes of 1 that have the first and second value of the input array.
  * In a for loop, merge the two arrays and set the result equal to the first array by using a temporary array.
  * Also in the for loop, set the second array's value equal to the next value in the given array.
  * Keep merging the two arrays until you reach the end of the given array.
  * Return the first array.
  ***/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
    int aCounter = 0;
    int bCounter = 0;
    int[] finalArray = new int[a.length + b.length];
    for (int finalCounter = 0; finalCounter < (a.length + b.length); finalCounter++) {
      if (bCounter == b.length) {
        finalArray[finalCounter] = a[aCounter];
        aCounter++;
        }
      else if (aCounter == a.length) {
        finalArray[finalCounter] = b[bCounter];
        bCounter++;
        }
      else {

        if (a[aCounter] < b[bCounter]) {
          finalArray[finalCounter] = a[aCounter];
          aCounter++;
        }
        else {
          finalArray[finalCounter] = b[bCounter];
          bCounter++;
        }

      }
    }

    return finalArray;
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
    int[] firstArray = new int[1];
    firstArray[0] = arr[0];
    int[] secondArray = new int[1];
    for (int i = 0; i < arr.length - 1; i++) {
      secondArray[0] = arr[i + 1];
      int[] tempArray = merge(firstArray, secondArray);
      firstArray = tempArray;
    }
    return firstArray;

  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args )
  {
      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );

      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(sort(arr4),sort(arr6)) );



  }//end main()

}//end class MergeSort
