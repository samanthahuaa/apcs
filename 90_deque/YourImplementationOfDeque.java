/**
TNPG: Hot Cake (Ariel Fuchs + Skelly Ducker, Samantha Hua + Poppy, Nada Hameed + Ray)
APCS pd07
HW 90 -- our implementation of deque
2022-04-13
time spent: 0.7hrs

DISCO:
 - We implemented this like a wrapper class and used a lot of the functionality
 provided by LinkedList
 - Having a plan is very important. Without it we would be lost ducklings.

QCC:
 - When would it be preferable to use ArrayList instead of LinkedList?
 - Would we ever need to have some sort of capacity limit for a deque? (We implemented it without capacity)
**/

import java.util.LinkedList;

public class YourImplementationOfDeque<ORANGE> implements Deque<ORANGE>{

  // inst vars
  LinkedList<ORANGE> _deque;

  public YourImplementationOfDeque() {
    _deque = new LinkedList<ORANGE>();
  }

  public int size(){
    return _deque.size();
  } // O(1)

  public boolean isEmpty(){
    return _deque.size() == 0;
  } // O(1)

  public ORANGE getFirst() {
    if (_deque.isEmpty()) return null;
    return _deque.get(0);
  } // O(1)

  public ORANGE getLast() {
    if (_deque.isEmpty()) return null;
    return _deque.get(size() -1);
  } // O(1)

  public void addFirst(ORANGE o) {
    _deque.addFirst(o);
    return;
  } // O(1)

  public void addLast(ORANGE o) {
    _deque.addLast(o);
    return;
  } // O(1)

  public ORANGE removeFirst() {
    if (_deque.isEmpty()) return null;
    ORANGE dummy = _deque.get(0);
    _deque.remove(0);
    return dummy;
  } // O(n)

  public ORANGE removeLast() {
    if (_deque.isEmpty()) return null;
    ORANGE dummy = _deque.get(size()-1);
    _deque.remove(size()-1);
    return dummy;
  } // O(n)

  public boolean contains(ORANGE o){
    for(int i = 0; i < _deque.size(); i++){
      if(_deque.get(i).equals(o)){
        return true;
      }
    }
    return false;
  } // O(n)

  public static void main(String[] args) {
    // adding at the back and removing at the front
    // after adding --> 12345
    // should print out 12345 null
    YourImplementationOfDeque<Integer> hotCakes = new YourImplementationOfDeque<Integer>();
    hotCakes.addLast(1);
    hotCakes.addLast(2);
    hotCakes.addLast(3);
    hotCakes.addLast(4);
    hotCakes.addLast(5);
    System.out.println("finished adding");

    System.out.println(hotCakes.removeFirst());
    System.out.println(hotCakes.removeFirst());
    System.out.println(hotCakes.removeFirst());
    System.out.println(hotCakes.removeFirst());
    System.out.println(hotCakes.removeFirst());
    System.out.println(hotCakes.removeFirst());
    System.out.println("finished dequeuing no more cake");

    // adding at the front and removing from the back
    // after adding --> 54321
    // should print out 12345 null
    YourImplementationOfDeque<Integer> hotterCake = new YourImplementationOfDeque<Integer>();
    hotCakes.addFirst(1);
    hotCakes.addFirst(2);
    hotCakes.addFirst(3);
    hotCakes.addFirst(4);
    hotCakes.addFirst(5);
    System.out.println("finished adding");

    System.out.println(hotCakes.removeLast());
    System.out.println(hotCakes.removeLast());
    System.out.println(hotCakes.removeLast());
    System.out.println(hotCakes.removeLast());
    System.out.println(hotCakes.removeLast());
    System.out.println(hotCakes.removeLast());
    System.out.println("finished dequeuing no more cake");
  }
}
