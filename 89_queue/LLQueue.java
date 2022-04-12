/*
Hot Cake: Nada Hameed, Samantha Hua, and Ariel Fuchs
APCS
HW89: Queue Two Ways
2022-04-11
time spent: 1.2hrs

DISCO:
  - This felt very similar to LLStack and ALStack
  - We don't need to check isFull because we can always add things onto the end of our queues.
  
QCC:
  - In ALQueue, how can we both enqueue and dequeue in constant time?
*/

import java.util.LinkedList;

public class LLQueue<QUASAR> implements Queue<QUASAR>{
  //inst vars
  LinkedList<QUASAR> _queue;

  public LLQueue() {
    _queue = new LinkedList<QUASAR>();
  } // O(1)

  public void enqueue( QUASAR s )
  {
    _queue.addLast(s);
    return;
  }// O(1) because the algo does not iterate through the stack. it just adds a
  // new element to the end


  //means of removal
  public QUASAR dequeue( )
  {
    if (_queue.isEmpty()) return null;
    QUASAR blah = _queue.get(0);
    _queue.remove(0);
    return blah;
  }// O(1) because the algo does not iterate through the stack. it just removes a
  // new element to the end

  public QUASAR peekFront() {
    if (_queue.isEmpty()) return null;
    return (_queue.getFirst());
  }// O(1)

  //chk for emptiness
  public boolean isEmpty()
  {
    return _queue.size() == 0;
  }// O(1) because it is not dependent on the size of the stack.

  public static void main(String[] args) {
    LLQueue<Integer> hotCakes = new LLQueue<Integer>();
    hotCakes.enqueue(1);
    hotCakes.enqueue(2);
    hotCakes.enqueue(3);
    hotCakes.enqueue(4);
    hotCakes.enqueue(5);
    System.out.println("finished adding");

    System.out.println(hotCakes.dequeue());
    System.out.println(hotCakes.dequeue());
    System.out.println(hotCakes.dequeue());
    System.out.println(hotCakes.dequeue());
    System.out.println(hotCakes.dequeue());
    System.out.println(hotCakes.dequeue());


    System.out.println("finished dequeuing no more cake");
  }
}
