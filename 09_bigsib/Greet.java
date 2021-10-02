// Flaming Hot Cheetos (Perry (Salaj Jr.), Courtney (Timothy), Samantha (me) (Poppy)
// APCS
// HW09 -- Calling methods from other java files
// 2021-10-02

// Discoveries
// You can call other methods from other files without needing to import anything. The method that you are calling can also have a main().
// To call a method in another file, write [FileName].[MethodName]([AnyParameters). 

//Unresolved Questions
// Why do we normally write main(String[] args)? Why not something else?

// Check the BigSib.java file to see my process of experimentation.

public class Greet {
	public static void main(String[] args) {
		BigSib.main("Flim");
		BigSib.main("Flam");
		BigSib.main("Kazaam");
	}
// 	public static void main(String[] args) {
// 		BigSib.greet("Flim");
// 		BigSib.greet("Flam");
// 		BigSib.greet("Kazaam");
// 	}
}
