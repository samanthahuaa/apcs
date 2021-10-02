// Flaming Hot Cheetos (Perry (Salaj Jr.), Courtney (Timothy), Samantha (me) (Poppy)
// APCS
// HW09 -- Calling methods from other java files
// 2021-10-02

// Discoveries
// You can call other methods from other files without needing to import anything. The method that you are calling should not have main(String[] args).
// To call a method in another file, write [FileName].[MethodName]([AnyParameters)

//Unresolved Questions
// Why can't the file being called have a main(String[] args) method?

public class Greet {
	public static void main(String[] args) {
		BigSib.main("Flim");
		BigSib.main("Flam");
		BigSib.main("Kazaam");
	}
}
