/**
TNPG: Hot Cake - Samantha Hua, Ariel Fuchs, Nada Hameed
APCS pd07
HW102 - Heap On Heapin' On (ALHeap)
2022-05-17
time spent: 2hrs.

DISCO:
* We did not end up using the minOf method in our code, though maybe it could've been helpful.

QCC:
 * Print statements are helpful when trying to debug our code.
 * Our removeMin method does not work, and returns the leaf (index) - the while loop that we
 use in that method is only iterated through once, and we were unable to resolve the issue.

 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 */

import java.util.ArrayList;

public class ALHeap {

  // instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor --- inits empty heap
   */
  public ALHeap() {
    _heap = new ArrayList<Integer>();
  }

  /**
   * toString() --- overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   */
  public String toString() {
    return  _heap.toString();
  }// O(n) --> traverse through the whole ArrayList to print everything out

  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty() {
    return _heap.size() == 0;
  }// O(1)

  /**
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   */
  public Integer peekMin() {
    return _heap.get(0);
  }// O(1)

  /**
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * ALGO:
   * <your clear && concise procedure here>
   */
  public void add(Integer addVal) {
    _heap.add(addVal);
    // if there is only one node in the tree, return. no need to compare
    if (_heap.size() == 1) {
      return;
    }
    int newValIndex = _heap.size() - 1;
    int parent = (newValIndex - 1) / 2;

    while (_heap.get(parent) > _heap.get(newValIndex)) {
      //swap the parent and new val
      swap(parent, newValIndex);
      if(parent == 0){
        return;
      }
      //create new index vals for parent and newValIndex
      newValIndex = parent;
      parent = (newValIndex - 1) / 2;
    }

  }// O(log(n)) because in the worst case scenario you have to float through half
  // of the tree

  /**
   * removeMin() --- means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * ALGO:
   * replace the root with a leaf
   * go down the tree and compare it to the children to ensure it maintains heapness
      swap with the smaller child (if it exists)
   * keep going until the newly added leaf is no longer larger than its children
   */
  public Integer removeMin() {
    if(isEmpty())
      return -1;
    // replace the root with a leaf
    int retVal = _heap.get(0);
    // set the root to be a leaf
    _heap.set(0,_heap.remove(_heap.size() - 1));

    // indexes of vals we want to compare
    int leaf = 0;
    while (minChildPos(leaf) > -1) {
      swap(minChildPos(leaf),leaf);
      leaf = minChildPos(leaf);
      // System.out.println(minChildPos(leaf));
      // System.out.println(leaf);
    }
    return retVal;
  }// O(?)

  /**
   * minChildPos(int) --- helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   */
  private int minChildPos(int pos) {
    boolean leftChildExists = ((2 * pos) + 1) < _heap.size();
    boolean rightChildExists = ((2 * pos) + 2) < _heap.size();

    int leftChild = (2 * pos) + 1;
    int rightChild = (2 * pos) + 2;

    if (leftChildExists) {
      if (rightChildExists) {
        if (_heap.get(leftChild) < _heap.get(rightChild)) {
          if (_heap.get(leftChild) < _heap.get(pos)) {
            return leftChild;
          } else {
            return pos;
          }
        } else {
          if (_heap.get(rightChild) < _heap.get(pos)) {
            return rightChild;
          } else {
            return pos;
          }
        }
      }
      if (_heap.get(pos) < _heap.get(leftChild)) {
        return pos;
      }
      return leftChild;
    }
    return -1;
/*
    // left and right children both exist, left is less than right
    if (leftChildExists && rightChildExists && _heap.get(pos) > _heap.get(leftChild) && _heap.get(leftChild) < _heap.get(rightChild)) {
      return leftChild;
    }
    // left and right children both exist, right is less than or equal to left
    else if (leftChildExists && rightChildExists && _heap.get(pos) > _heap.get(rightChild) && _heap.get(leftChild) >= _heap.get(rightChild)) {
      return rightChild;
    }
    // if only left child exists and it is less than pos
    else if (leftChildExists && _heap.get(pos) > _heap.get(leftChild)) {
      return leftChild;
    }
    // if only rightChild child exists and it is less than pos
    else if (rightChildExists && _heap.get(pos) > _heap.get(rightChild)) {
      return rightChild;
    }
    else if (rightChildExists == false && leftChildExists == false) {
      return -1;
    }
    else {
      return pos;
    }
    */
  }// O(?)

  // ~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer minOf(Integer a, Integer b) {
    if (a.compareTo(b) < 0)
      return a;
    else
      return b;
  }

  // swap for an ArrayList
  private void swap(int pos1, int pos2) {
    _heap.set(pos1, _heap.set(pos2, _heap.get(pos1)));
  }

  // main method for testing
  public static void main(String[] args) {
     ALHeap pile = new ALHeap();

     pile.add(2);
     System.out.println(pile);
     pile.add(4);
     System.out.println(pile);
     pile.add(6);
     System.out.println(pile);
     pile.add(8);
     System.out.println(pile);
     pile.add(10);
     System.out.println(pile);
     pile.add(1);
     System.out.println(pile);
     pile.add(3);
     System.out.println(pile);
     pile.add(5);
     System.out.println(pile);
     pile.add(7);
     System.out.println(pile);
     pile.add(9);
     System.out.println(pile);

     System.out.println("removing " + pile.removeMin() + "...");
     System.out.println(pile);
     System.out.println("removing " + pile.removeMin() + "...");
     System.out.println(pile);
     System.out.println("removing " + pile.removeMin() + "...");
     System.out.println(pile);
     System.out.println("removing " + pile.removeMin() + "...");
     System.out.println(pile);
     System.out.println("removing " + pile.removeMin() + "...");
     System.out.println(pile);
     System.out.println("removing " + pile.removeMin() + "...");
     System.out.println(pile);
     System.out.println("removing " + pile.removeMin() + "...");
     System.out.println(pile);
     System.out.println("removing " + pile.removeMin() + "...");
     System.out.println(pile);
     System.out.println("removing " + pile.removeMin() + "...");
     System.out.println(pile);
     System.out.println("removing " + pile.removeMin() + "...");
     System.out.println(pile);
     System.out.println("removing " + pile.removeMin() + "...");
     System.out.println(pile);
     /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
  }// end main()

}// end class ALHeap
