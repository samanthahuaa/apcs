/***
TNPG: Hot Cake: Samantha Hua + Poppy, Ariel Fuchs + Skelly Duckler, Nada Hameed + Ray
APCS
HW81: Thank You, Next - using an iterator
2022-03-24
time spent: 0.6 hrs

 * class ItrWork
 *  SKELETON
 * Facilitates familiarization with iterators
 **/

/***
    DISCO
    - any changes to an alias of L still creates changes to L
    - remove() in an iterator does not remove the last element of the list
      -> instead, it removes the last element that was returned by the iterator
    - List.java is an interface and does not have a constructor, so when we initialize new instances
    of a list, we have to call LList or ArrayList, which are classes with constuctors.

    QCC
    - what's the significance of using an iterator instead of iterating through the code without one?

    SUMMARY THE FIRST:
      - foundA and foundB only differ in their approach (foreach loop and Iterator), but both would
      iterate through the list to see whether the key is in the list.
      - oddsA and oddsB would iterate through a list and add all of the odd integers into a separate
      list that gets returned.
      - removeEvens edits the list by iterating through it and deleting the even integers.

    SUMMARY THE SECOND:
    - foundA and foundB use different approaches to iterate through the list to see if it has the
    key.
    - oddsA and oddsB iterate through the list and add all the odd integers into a new list that's
    returned.
    - removeEvens does the same thing as oddsB, but it directly modifies the original List, by
    removing all of the even numbers.

**/




import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key,
                                List<Integer> L )
  {
    for (Integer item : L) {
      if (item == key) {
        return true;
      }
    }
    return false;

  }

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key,
                                List<Integer> L )
  {
    Iterator temp = L.iterator();
    while (temp.hasNext()) {
      if (temp.next() == key) {
        return true;
      }
    }
    return false;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsA( List<Integer> L )
  {
    List<Integer> temp = new ArrayList();
    for (Integer item : L) {
      if ((item % 2) == 1) {
        temp.add(item);
      }
    }
    return temp;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsB( List<Integer> L )
  {
    Iterator temp = L.iterator();
    List<Integer> tempy = new ArrayList();
    while(temp.hasNext()) {
      Integer tumpy = (Integer)temp.next();
      if ((tumpy % 2) == 1) {
        tempy.add(tumpy);
      }
    }
    return tempy;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {
    Iterator temp = L.iterator();
    while(temp.hasNext()) {
      Integer tumpy = (Integer)temp.next();
      if ((tumpy % 2) == 0) {
        temp.remove();
      }
    }
  }


  public static void main( String [] args )
  {

    //var type: List   obj type: ?
    List<Integer> L = new ArrayList();

    for( int i = 0; i < 10; i++ )
      L.add(i);


    // TASK: write code to print the contents of L...

    // a) using a FOREACH loop


    // b) explicitly using an iterator

    System.out.println(L);

    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) ); //returns true
    System.out.println("13 in L? -> " + foundA(13,L) ); //returns false

    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) ); //returns true
    System.out.println("13 in L? -> " + foundB(13,L) ); //returns false

    System.out.println(L);

    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for( int n : A ){
       System.out.println(n);
     } //1,3,5,7,9

    System.out.println("\nTesting oddsB..."); //1,3,5,7,9
    List<Integer> B = oddsB(L);
    for( int n : B ){
      System.out.println(n);
    }

    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);
    /*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class ItrWork
