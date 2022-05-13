import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {
  ArrayList<Integer> queueT;
  int endIndexOfPriority;

  public ArrayPriorityQueue() {
    queueT = new ArrayList();
    endIndexOfPriority = 0;
  }

  public boolean checkPriority(int x) {
    return (x < 10) == 0;
  }

  public boolean isEmpty() {
    return (queueT.size() == 0);
  }

  public void add(int x) {
    if (checkPriority(x) == true) {
      queueT.add(endIndexOfPriority, x);
    }
    else {
      queueT.add(x);
    }
  }

  public int peekMin() {

  }

  public int removeMin() {

  }

}
