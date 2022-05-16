import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {
  ArrayList<Integer> queueT;
  int endIndexOfPriority;

  // O(1)
  public ArrayPriorityQueue() {
    queueT = new ArrayList();
    endIndexOfPriority = 0;
  }

  // O(1)
  public boolean checkPriority(int x) {
    return (x < 10);
  }

  // O(1)
  public boolean isEmpty() {
    return (queueT.size() == 0);
  }

  // O(n) in the worst case scenario
  public void add(int x) {
    if (checkPriority(x) == true) {
      queueT.add(endIndexOfPriority, x);
    }
    else {
      queueT.add(x);
    }
  }

  // O(n)
  public int peekMin() {
    int currentMin = queueT.get(0);
      for( int val: queueT){
            if( val < currentMin  ){
                currentMin = val;
            }

        }
        return currentMin;
  }

  // O(n)
  public int removeMin() {
    int index = queueT.indexOf(peekMin());
    if (checkPriority(queueT.get(index))) {
      endIndexOfPriority--;
    }
    return queueT.remove(index);
  }

  // O(n)
  public String toString(){
    return queueT.toString();
  }

  public static void main(String[] args){
    ArrayPriorityQueue a = new ArrayPriorityQueue();
      a.add(5);
      a.add(3);
      a.add(14);
      a.add(7);
      a.add(18);
      a.add(11);
      System.out.println("a: "+  a);

      System.out.println();
      System.out.println("min: " + a.peekMin());
      System.out.println("removeMin: " + a.removeMin());
      System.out.println("min: " + a.peekMin());
      System.out.println("removeMin: " + a.removeMin());
      System.out.println("min: " + a.peekMin());
      System.out.println("removeMin: " + a.removeMin());

      System.out.println();
      System.out.println("a: "+  a);
  }
}
