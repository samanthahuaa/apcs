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

import java.util.ArrayList;

public class ALQueue<QUASAR> implements Queue<QUASAR>{
  //inst vars
  private ArrayList<QUASAR> _queue;

  public ALQueue() {
    _queue = new ArrayList<QUASAR>();
  } // O(1)

  public QUASAR peekFront() {
    return _queue.get(0);
  }

  public boolean isEmpty() {
    return _queue.size() == 0;
  }

  public void enqueue( QUASAR s )
  {
    _queue.add(s);
    return;
  }// O(1) because the algo does not iterate through the queue. it just adds a
  // new element to the end


  //means of removal
  public QUASAR dequeue( )
  {
    if (_queue.isEmpty()) return null;
    QUASAR blah = _queue.get(0);
    _queue.remove(0);
    return blah;
  } // O(n)

  public static void main(String[] args){
    ALQueue<Integer> hotCakes = new ALQueue<Integer>();
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
