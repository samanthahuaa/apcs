/**
TNPG: Hot Cake (Ariel Fuchs + Skelly Ducker, Samantha Hua + Poppy, Nada Hameed + Ray)
APCS pd07
HW91: Deque the Halls
2022-04-13
time spent: 0.8hrs

TNPG: Hot Cake (Ariel Fuchs + Skelly Ducker, Samantha Hua + Poppy, Nada Hameed + Ray)
APCS pd07
HW 90 -- our implementation of deque
2022-04-13
time spent: 0.7hrs
**/

import java.util.LinkedList;

public class LLDeque<ORANGE> implements Deque<ORANGE>{

  // inst vars
  LinkedList<ORANGE> _deque;

  public LLDeque() {
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

  public void clear() {
    _deque = new LinkedList<ORANGE>();
    return;
  } // O(1)

}
