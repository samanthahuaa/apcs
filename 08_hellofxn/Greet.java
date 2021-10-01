//DISCOVERIES
// I referred back to my summer pre-work exercises to remind myself of how to call functions and pass information into them.
// In particular, I was reminded of how when a method has a parameter, you must specify the type of information that is being passed into it.

//UNRESOLVED QUESTIONS
// At the moment, I do not have any unresolved questions.

public class Greet {
	public static void main(String [] args) {
		greet("Maria");
		greet("boop");
		greet("friend");
	}
	public static void greet(String a){
		// System.out.print("Hello World");
		System.out.println("Hello there "+a+", nice to meet you!");
	}
}
