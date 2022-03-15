/**
TNPG: Hot Cake: Samantha Hua + Poppy, Nada Hameed + Ray, Ariel Fuchs + Skelly Duckler
APCS pd07
HW76 - LList
2022-03-014m
time spent: 1.5 hr.
We used 1 KtS
**/

/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/
// We discussed our approach to thsi homwework which included our methods in
// LLnode to guide us and to traferse LList but some of our large question
// remained unanswered. We were unsure how to connect _head in a way that was
// effective. We discussed LLnode methods to access values inside the nodes of
// our list.
public class LList implements List // interface def must be in this dir
{

    // instance vars
    private LLNode _head;
    private int _size;
    // private LLNode next;

    // constructor -- initializes instance vars
    public LList() {
        _size = 1;
        _head = new LLNode(null, null);
    }

    // --------------v List interface methods v--------------

    public boolean add(String newVal) {

        LLNode temp = _head;
        if (temp.getCargo() == null) {
            temp.setCargo(newVal);
        } else {
            while (temp != null) {
                temp = temp.getNext();
            }

            temp.setNext(new LLNode(newVal, null));

        }
        _size++;
        return true;
    }

    public String get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        return temp.getCargo();
    }

    public String set(int index, String newVal) {
        String oldVal = "";
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        else {
            LLNode test = _head;
            for (int i = 0; i < index; i++) {
                test = test.getNext();
            }
            oldVal += test.getCargo();
            test.setCargo(newVal);
            return oldVal;
        }
    }

    // return number of nodes in list
    public int size() {
        return _size;
        /*
         * int ctr = 0;
         * LLNode temp = _head;
         * while (temp.getNext() != null) {
         * temp = temp.getNext();
         * ctr++;
         * }
         * return ctr;
         */
    }

    // --------------^ List interface methods ^--------------

    // override inherited toString
    public String toString() {
        // YOUR CODE HERE
        return null;
    }

    // main method for testing
    public static void main(String[] args) {
        LList james = new LList();
        System.out.println(james);
        System.out.println("size: " + james.size());
        james.add("beat");
        System.out.println(james);
        /*
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * System.out.println( "size: " + james.size() );
         * james.add("a");
         * System.out.println( james );
         * System.out.println( "size: " + james.size() );
         * james.add("need");
         * System.out.println( james );
         * System.out.println( "size: " + james.size() );
         * james.add("I");
         * System.out.println( james );
         * System.out.println( "size: " + james.size() );
         * System.out.println( "2nd item is: " + james.get(1) );
         * james.set( 1, "got" );
         * System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
         * System.out.println( james );
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         */
    }

}// end class LList
