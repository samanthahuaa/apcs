/******************************
 * class TwoDimArray
 * practice working with 2D arrays
 ******************************/

/**
Frogs (Ruby Friedman, Samantha Hua, Ivina Wang)
APCS pd07
HW40 -- Demand A Raise
2021-11-30
time spent: 0.75 hrs

DISCO:
 * When using 2D arrays, a.length (where a is the 2D array) returns the
   amount of arrays a contains, whereas a[1].length returns the length
   of the array at index 1 in a.
 * To initialize and set values in 2D arrays you put curly braces inside
   of curly braces:
   ex: { {4, 7, 9}, {-1, 0}, {2, 8, 0} }
 * To access a value in an array inside the larger array, the syntax is:
   a[i][j] where a is the 2D array i is the index of the smaller array
   in which the value is contained and j is the index of the value in
   array i.
QCC:
 * Is there a way to access the indexOf a value in a 2D array without
   creating a method for it?
 * Is there a maximum value for the rows and columns we can have in an
   array.
 * What other types of for loop are there other than the default one and
   for each loops?

*/
public class TwoDimArray {
	//postcond: prints each row of 2D int array a on its own line
	//uses a FOR loop
	public static void print1( int[][] a ) {
		for (int i=0; i< a.length;i++) {
			System.out.print("[");
			for(int j=0; j<a[i].length;j++) {
				System.out.print(a[i][j]);
				if (j != a[i].length-1) {
					System.out.print(", ");
				}
			}
		System.out.println("]");
		}
	}

	//postcond: prints each row of 2D int array a on its own line
	//uses a FOREACH loop
	public static void print2( int[][] a ) {
		for(int[] i: a) {
			int counter = 0;
			System.out.print("[");
                        for(int j: i) {
                                System.out.print(j);
                                if (counter != i.length-1) {
                                        System.out.print(", ");
                                }
				counter +=1;
                        }
                System.out.println("]");
                }
	}

	//postcond: returns sum of all items in 2D int array a
	public static int sum1( int[][] a ) {
		int sum = 0;
                for (int i=0; i< a.length;i++) {
                        for(int j=0; j<a[i].length;j++) {
                                sum += a[i][j];
                        }
                }
		return sum;
	}


	//postcond: returns sum of all items in 2D int array a
	//uses helper fxn sumRow
  	public static int sum2( int [][] m ) {
		int sum = 0;
		for (int i=0; i<m.length; i++) {
			sum += sumRow(i, m); //exchanged this with sumRow2 to test if it was functional
		}
		return sum;
	}


	//postcond: returns sum of all items on row r of 2D int array a
	//uses a FOR loop
	public static int sumRow( int r, int[][] a ) {
		int sum = 0;
		for (int j=0; j<a[r].length; j++) {
			sum += a[r][j];
		}
		return sum;
	}


	//postcond: returns sum of all items on row r of 2D int array a
	//uses a FOREACH loop
	public static int sumRow2(int r, int[][] m) {
		int summer = 0;
			for(int j: m[r]) {
				summer +=j;
			}
		return summer;
	}

	public static void main( String [] args ) {
		int [][] m1 = new int[4][2];
		int [][] m2 = { {2,4,6}, {3,5,7} };
		int [][] m3 = { {2}, {4,6}, {1,3,5} };
		int [][] m4 = { {4, 7, 9}, {-1, 0}, {2, 8, 0} }; //our additional test case
		print1(m1);
		print1(m2);
		print1(m3);
                print1(m4);
		print2(m1);
		print2(m2);
		print2(m3);
                print2(m4);
		System.out.print("testing sum1...\n");
		System.out.println("sum m1 : " + sum1(m1));
		System.out.println("sum m2 : " + sum1(m2));
		System.out.println("sum m3 : " + sum1(m3));
                System.out.println("sum m4 : " + sum1(m4));
		System.out.print("testing sum2...\n");
		System.out.println("sum m1 : " + sum2(m1));
		System.out.println("sum m2 : " + sum2(m2));
		System.out.println("sum m3 : " + sum2(m3));
                System.out.println("sum m4 : " + sum2(m4));
	}

}//end class TwoDimArray
