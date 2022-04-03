/**
TNPG: Hot Cake: Samantha Hua + Poppy, Nada Hameed + Ray, Ariel Fuchs + Skelly Duckler
APCS pd07
HW87: The English Do Not Wait In Line for Soup
2022-04-03
time spent: 1.2hr

DISCO:
- NodeQueue acts very similar to LList but has different functionalities.
- we used _head to point to what was at the front of the queue,
  so we have to make sure that we change that each time we dequeue. we also decided
  that we would add new elements to the end of the queue.

QCC:
- How can we implement this in a way that doesn't require LLNode as a seperate file?
**/

public class NodeQueue<QUASAR> implements Queue<QUASAR>
{
  //instance vars
  int _size = 0;
  LLNode<QUASAR> _head;

  public NodeQueue() {
    _head = new LLNode<QUASAR>(null,null);
    _size = 0;
  }

  public QUASAR dequeue() {
    if (isEmpty()) {
      return null;
    }
    QUASAR firstElement = _head.getCargo();
    _head = _head.getNext();
    _size--;
    return firstElement;
  }

  public void enqueue( QUASAR x ) {
    LLNode<QUASAR> a = new LLNode<QUASAR>(x, null);

    if (_size == 0) {
      _head = a;
      // _head = a;
      // System.out.print("head: "+ _head.getCargo());
    }

    // while (temp.getNext() != null) {
    //   temp = temp.getNext();
    // }
    LLNode<QUASAR> test = _head;
    for (int i = 0; i < _size-1; i++) {
        test = test.getNext();
    }
    test.setNext(a);
    _size++;
    return;
  }

  public boolean isEmpty() {
      return _size == 0;
  }

  public QUASAR peekFront() {
    if (isEmpty()) {
      return null;
    }
    return _head.getCargo();
  }

  public static void main(String[] args) {
    NodeQueue<String> tastyStack = new NodeQueue<String>();

    tastyStack.enqueue("aoo");
    tastyStack.enqueue("boo");
    tastyStack.enqueue("coo");
    tastyStack.enqueue("doo");
    tastyStack.enqueue("eoo");
    tastyStack.enqueue("foo");
    tastyStack.enqueue("goo");
    tastyStack.enqueue("hoo");
    tastyStack.enqueue("ioo");
    tastyStack.enqueue("joo");
    tastyStack.enqueue("coocoo");
    tastyStack.enqueue("cachoo");

    //cachoo
    System.out.println( "peek: " + tastyStack.peekFront() );
    System.out.println( "dequeue: " + tastyStack.dequeue() );
    //coocoo
    System.out.println( "peek: " + tastyStack.peekFront() );
    System.out.println( "dequeue: " + tastyStack.dequeue() );
    //joo
    System.out.println( "peek: " + tastyStack.peekFront() );
    System.out.println( "dequeue: " + tastyStack.dequeue() );
    //ioo
    System.out.println( "peek: " + tastyStack.peekFront() );
    System.out.println( "dequeue: " + tastyStack.dequeue() );
    //hoo
    System.out.println( "peek: " + tastyStack.peekFront() );
    System.out.println( "dequeue: " + tastyStack.dequeue() );
    //goo
    System.out.println( "peek: " + tastyStack.peekFront() );
    System.out.println( "dequeue: " + tastyStack.dequeue() );
    //foo
    System.out.println( "peek: " + tastyStack.peekFront() );
    System.out.println( "dequeue: " + tastyStack.dequeue() );
    //eoo
    System.out.println( "peek: " + tastyStack.peekFront() );
    System.out.println( "dequeue: " + tastyStack.dequeue() );
    //doo
    System.out.println( "peek: " + tastyStack.peekFront() );
    System.out.println( "dequeue: " + tastyStack.dequeue() );
    //coo
    System.out.println( "peek: " + tastyStack.peekFront() );
    System.out.println( "dequeue: " + tastyStack.dequeue() );
    //boo
    System.out.println( "peek: " + tastyStack.peekFront() );
    System.out.println( "dequeue: " + tastyStack.dequeue() );
    //aoo
    System.out.println( "peek: " + tastyStack.peekFront() );
    System.out.println( "dequeue: " + tastyStack.dequeue() );

    //stack empty by now; SOP(null)
    System.out.println( "peek: " + tastyStack.peekFront() );
    System.out.println( "dequeue: " + tastyStack.dequeue() );
  }

}
