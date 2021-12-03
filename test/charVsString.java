public class charVsString {
	public static void main(String[] args) {
		System.out.println('c');
//		System.out.println('har'); will not compile
		System.out.println("s");
		System.out.println("tring");

		char a = 'c';
		System.out.println(new char['a']);
		//new char does not work the same way newe String does. it is  more like an array of characters seperated by commas. thus it needs brackets (but not curly braces like arrays use to intiate with values)
		//it doesn't print out anything though... 
	}
}
