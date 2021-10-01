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
