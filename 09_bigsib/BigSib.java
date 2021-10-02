// For the heading, look at Greet.java
// I first tried to use a method called greet because I faced errors when using main. 
// I then revisted using main as a method and found that I needed to write BigSib.main in order for Greet.java to look at BigSib as a file.
// I also needed to write BigSib.main similar to how I wrote BigSib.greet.
// The next error I encountered was that the parameters for main took in a array of strings so I edited that to only take in one string. It worked!

public class BigSib {
	public static void main(String args) {
		System.out.println("Hello "+args+"! I'm Poppy (not poopy)");
	}
// 	public static void greet(String name) {
// 		System.out.println("Hello "+name+"! I'm Poppy (not poopy)");
// 	}
}
