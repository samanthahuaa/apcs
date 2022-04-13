/**
TNPG: Hot Cake (Ariel Fuchs + Skelly Ducker, Samantha Hua + Poppy, Nada Hameed + Ray)
APCS pd07
HW 90 -- our implementation of deque
2022-04-13
time spent: 0.7hrs
**/

public interface Deque<ORANGE>{

  // returns the size of the deque
  public int size();

  // whether or not the deque is empty
  public boolean isEmpty();

  //whether or not the deque contains a particular element
  public boolean contains(ORANGE o);

  // returns the first element in the deque
  public ORANGE getFirst();

  // returns the last element in the deque
  public ORANGE getLast();

  // adds a new element to the start of the deque
  public void addFirst(ORANGE o);

  // adds a new element to the end of the deque
  public void addLast(ORANGE o);

  // removes the element at the front of the deque
  public ORANGE removeFirst();

  // removes the element at the end of the deque
  public ORANGE removeLast();

}
