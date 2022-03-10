// Hot Cake: Nada Hameed, Samantha Hua, and Ariel Fuchs
//APCS pd7
//HW72 -- QuickSort
//2022-03-09w
//time spent: 1.5h + class time

/***
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):
 * The algorithm begins by running partition on the entire array with the pivot
 index of 0. Partition is run on the resulting halves of the array simulateously.
 IF the array being QuickSorted on is an array of 1, we know that it has
 reached it's final position. If not, the array if divided into two using the
 final PvtPos and recursed.

 * 2a. Worst pivot choice and associated run time:
 * The worst pivot choice is the index of the extremes of the array (max and min).
 This would be bad because it would force the algorithm to repeat itself for
 every value of n. This is why the run time efficiency is O(n^2)

 * 2b. Best pivot choice and associated run time:
 * The best pivot choice is the index of the median value in the array. This is
 because it would allow for an even sorting of both halves. The run time would
 be O(nlogn) similar to mergesort. This is because we divide and conquer in a
 similar fashion.

 * 3. Approach to handling duplicate values in array:
 * We aren't sure because our algorithm is fully finished but we are considering
 deleting and then readding the duplicate values at the end. However, this would
 affect big oh because the algo would need to loop through the array once more.
 **/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------

  /**
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   */
  public static void qsort( int[] d )
  {
    int start = 0;
    int end = d.length-1;

    qsortHelper(d, start, end);

  }

  //you may need a helper method...

  public static void qsortHelper( int[] d , int start, int end)
  {
    if (start + 1 == end || start > end) {
      // an array of one is always sorted
      return;
    }

    int finalPvtPos = partition(d, start, end, 0);

    //left side of partition
    if (finalPvtPos != 0 ) {
      qsortHelper(d, start, finalPvtPos-1);
    }

    //right side of partition
    if (finalPvtPos != d.length) {
      qsortHelper(d, finalPvtPos+1, end);
    }

  }

  public static int partition( int arr[], int loPos, int hiPos, int pvtPos)
  {
    int v = arr[pvtPos];

    swap( pvtPos, hiPos, arr);
    int s = loPos;

    for( int i = loPos; i < hiPos; i++ ) {
      if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;}
    }
    swap(s,hiPos,arr);

    return s;
  }//end partition

  //main method for testing
  public static void main( String[] args )
  {

    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)

    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)

    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main

}//end class QuickSort
