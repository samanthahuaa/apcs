/**
TNPG: Hot Cake (Ariel Fuchs + Skelly Ducker, Samantha Hua + Poppy, Nada Hameed + Ray)
APCS pd07
HW91: Deque the Halls
2022-04-13
time spent: 0.8hrs
**/

public class MRKPirateBae {
  public static void main(String[] args) {
    // adding at the back and removing at the front
    // after adding --> 12345
    // should print out 12345 null
    LLDeque<Integer> hotCakes = new LLDeque<Integer>();
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
    LLDeque<Integer> hotterCake = new LLDeque<Integer>();
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

    hotCakes.addFirst(1);
    hotCakes.addFirst(2);
    hotCakes.addFirst(3);
    hotCakes.addFirst(4);
    hotCakes.addFirst(5);
    hotCakes.clear();
    System.out.println(hotCakes.getFirst()); // should be null
    System.out.println(hotCakes.getLast()); // should be null
    System.out.println(hotCakes.size()); // should be 0
    System.out.println("cleared");
  }
}
