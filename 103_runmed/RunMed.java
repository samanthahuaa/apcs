/*
Hot Cake: Nada Hameed, Samantha Hua, and Ariel Fuchs
APCS pd.7
HW103 -- Erica's Friends, Hugo, and The One in the Middle
2022-05-18
time spent: 1.8hrs

ALGO:
1. have two heaps: a max heap (for smol values) and a min heap (for the BIG vals)
2. set the first inputted value as the root of the max heap
3. add the values with the condition that if they are greater than the root of
the max heap, they belong in the min heap
4. balance the trees by comparing their heights and ensuring the heights have a
difference of <2
    if the heaps are unbalanced, remove the root of the larger heap and add it to
    the other
    keep doing this until the heaps are balanced
5. take the root of the heap that is larger (if they are the same heights, take the
average of the roots (use int division))

DISCO:
 * a height method was really helpful in the ALHeap classes so we can check
 which heap is larger.
 * when adding the first two values, we compare them, making the smaller one the root of the
 max heap and the larger one the root of the min heap, maintaining the invariant that the
 values in minheap are always larger than the values in maxheap.

 QCC:
 * we decided to return values that are in the array, not averages of values in the array.
*/
public class RunMed{
  // inst vars
  private ALHeapMax lilVals;
  private ALHeapMin bigVals;

  // constructor
  public RunMed() {
    lilVals = new ALHeapMax();
    bigVals = new ALHeapMin();
  }

  // getMedian() returns median or throws NoSuchElementException()
  public int getMedian() {
    //sizes of the heaps
    int lilHeight = lilVals.size();
    int bigHeight = bigVals.size();

    //root values of the heaps
    int a = lilVals.peekMax();
    if (bigHeight == 0) {
      return a;
    }
    int b = bigVals.peekMin();

    //heaps are equal size --> take average of the roots
    if (lilHeight == bigHeight) {

      return a;
    }
    // max heap is bigger than min heap
    else if (lilHeight > bigHeight) {
      return a;
    }
    // min heap is bigger than max heap
    else {
      return b;
    }
  }

  // add(Integer newVal) adds newVal to appropriate heap, balances if necessary
  public void add (Integer newVal){
    int lilHeight = lilVals.size();
    int bigHeight = bigVals.size();

    if (lilHeight == 0) {
      lilVals.add(newVal);
      return;
    }
    else if (lilHeight == 1 && bigHeight == 0) {
      if (lilVals.peekMax() > newVal) {
        // have the greater value be the root for the min heap
        int temp = lilVals.peekMax();
        lilVals.removeMax();
        bigVals.add(temp);
        lilVals.add(newVal);
      } else {
        bigVals.add(newVal);
      }
      return;
    }

    //adding the new val
    // the new val is greater than the root of the max heap
    if (newVal > lilVals.peekMax()){
      bigVals.add(newVal);
    } else {
      lilVals.add(newVal);
    }


    //balancing
    while(Math.abs(lilHeight - bigHeight) >= 2){
      //update the values
      lilHeight = lilVals.size();
      bigHeight = bigVals.size();

      // if max heap is bigger, remove the root and add it to min heap
      if((lilHeight - bigHeight) >= 2){
        int a = lilVals.peekMax();
        lilVals.removeMax();
        bigVals.add(a);
      }
      // if min heap is bigger, remove the root and add it to max heap
      else {
        int b = bigVals.peekMin();
        bigVals.removeMin();
        lilVals.add(b);
      }
    }
  }

}
