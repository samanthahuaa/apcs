// Team Frogs (Ruby Friedman, Ivina Wang, Samantha Hua)
// APCS pd07
// HW43 -- encapsulation (basic SuperArray functionality)
// 2021-12-07

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

/**
DISCO:
 * How to increase the length of an array, or "expand" it.
 * Temporary variables allow us to store and return the old
   values in an array.
 * Using underlines in front of instance variables is the convention.

QCC:
 * How would we divide or subtract the capacity of an array rather than
   increasing it?
 * Why do we need the get(<index>) accessor?
 * What does making a method private change, how does it impact
   functionality? (ex: expand)
*/
public class SuperArray {
	private int[] _data;  //underlying container
	private int _size;    //number of elements in this SuperArray


	//default constructor – initializes 10-item array
	public SuperArray() {
		_data = new int[10];
		_size = 10;
	}

	//output SuperArray in [a,b,c] format
	public String toString() {
		String ans = "[";
		for (int i = 0; i<_size;i++) {
			ans+= _data[i] + ", ";
		}
		ans = ans.substring(0, ans.length()-2);
		ans += "]";
		return ans;
	}


	//double capacity of SuperArray
	private void expand() {
		int[] result = new int[_size*2];
		for (int i = 0; i < _data.length; i++) {
			result[i] = _data[i];
		}
		_data = result;
		_size = _size * 2;
	}


	//accessor -- return value at specified index
	public int get( int index ) {
		return _data[index];
	}


	//mutator -- set value at index to newVal,
	//           return old value at index
	public int set( int index, int newVal ) {
		int old = _data[index];
		_data[index] = newVal;
		return old;
	}


	//main method for testing
	public static void main( String[] args ) {
		SuperArray curtis = new SuperArray();
		System.out.println( "Printing empty SuperArray curtis..." );
		System.out.println( curtis );

		for( int i = 0; i < curtis._data.length; i++ ) {
			curtis.set( i, i * 2 );
		}

		System.out.println("Printing populated SuperArray curtis...");
		System.out.println(curtis);

		for( int i = 0; i < 3; i++ ) {
			curtis.expand();
			System.out.println("Printing expanded SuperArray curtis...");
			System.out.println(curtis);
		}
		System.out.println("Printing the 3rd index of curtis the array!");
		System.out.println(curtis.get(3)); //should be 6!
	}//end main()


}//end class
