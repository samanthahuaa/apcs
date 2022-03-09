/**
TNPG: Hot Cake: Samantha Hua + Poppy, Nada Hameed + Ray, Ariel Fuchs + Skelly Duckler
APCS pd07
HW72 - So So Fast - Fast Select
2022-03-09m
time spent: 1.75 hrs + class time


DISCO:
- Fast select can use a method similar to binary search
- we can use s as our pivot
QCC:
- our group was discussing the significance of s, and considering how it may represent the final position of the value at index c
- when we used the sorting visualizer, we saw that the algo sort of changed the range of the sorted region to always be around half of the previous sorted region
EXECUTION TIME:
- O(logn) -> we consistently divide the array in half

- best case: the element we're looking for is near the middle
- worst case: the element we're looking for is at the extremes
**/

public class FastSelect{
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
   * int mysterion(int[],int,int,int)
   * DESCRIP
   *
   * @param arr
   * @param a
   * @param b
   * @param c
   * @return int
   *
   */
  public static int partition( int[] arr, int start, int end, int c)
  {
    int v = arr[c];
    swap(c, end, arr);
    int s = start;
    for (int i = start; i < end; i++){
      if (arr[i] < v){
        swap(s, i, arr);
        s++;
      }
    }
    swap(end, s, arr);
    return s;
  }//end mysterion

  // public int smallestElement(int[] arr, int start, int end, int y){
  //   // int c = 0;
  //   // partition(arr, 0, arr.length-1, c);
  // }

  public static int smallestElement(int[] arrayCake, int y){
    int start = 0;
    int end = arrayCake.length-1;
    int pivot = end / 2;

    pivot = partition(arrayCake, start, end, pivot);
    while (pivot != y){
      if (pivot > y){
        end = pivot - 1;
        pivot = end - 1;
      }
      else{
        start = pivot;
        pivot = start + 1;
      }
      pivot = partition(arrayCake, start, end, pivot);
    }

    return arrayCake[y-1];
  }
  //main method for testing
  public static void main( String[] args )
  {

    // init test arrays of magic numbers
    // int[] arr1 = {8,21,17,69,343};
    // int[] arr3 = {1,28,33,4982,37};
    // int[] arr4 = {5,4,17,9000,6};
    // int[] arr5 = {3,0,16,599,1024};

    System.out.println("-----------");

    int[] test = {5, 4, 3, 2, 1};
    printArr(test);
    System.out.println(smallestElement(test, 4));
    System.out.println(smallestElement(test, 3));
    System.out.println(smallestElement(test, 2));
    System.out.println(smallestElement(test, 1));

    System.out.println("-----------");

    int[] test2 = {7, 5, 1, 12, 3};
    printArr(test2);
    System.out.println(smallestElement(test2, 4));
    System.out.println(smallestElement(test2, 3));
    System.out.println(smallestElement(test2, 2));
    System.out.println(smallestElement(test2, 1));

    System.out.println("-----------");

    //best case
    int[] test3 = {7, 5, 1, 12, 3};
    printArr(test3);
    System.out.println(smallestElement(test3, 1));

    System.out.println("-----------");

    //worst case
    int[] test4 = {7, 5, 1, 12, 3};
    printArr(test4);
    System.out.println(smallestElement(test4, 2));

  }//end main

}
