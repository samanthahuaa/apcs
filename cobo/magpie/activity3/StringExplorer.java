/**
 * A program to allow students to try out different
 * String methods.
 * @author Laurie White
 * @version April 2012
 */
 /*
		 If the substring is not found within the target, indexOf() will return -1.
 */
public class StringExplorer
{

	public static void main(String[] args)
	{
		String sample = "The quick brown fox jumped over the lazy dog.";
		int notFoundPsn = sample.indexOf("slow");
		System.out.println("sample.indexOf(\"slow\") = " + notFoundPsn); //-1
		//  Demonstrate the indexOf method.
		int position = sample.indexOf("quick");
		System.out.println ("sample.indexOf(\"quick\") = " + position); //4

		/*
			The indexOf method that takes in two parameters (string and index) starts
			looking at the specified index for the specified target. This differs from
			the indexOf method without parameters due to the varying starting indexes
			for your search.
		*/

		//  Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println ("sample.toLowerCase() = " + lowerCase);
		System.out.println ("After toLowerCase(), sample = " + sample);

		//  Try other methods here:

	}

}
