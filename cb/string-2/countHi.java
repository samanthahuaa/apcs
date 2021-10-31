public class countHi {
	public static  int countHi(String str) {
	  int counter = 0;
	  for (int i=0; i < (str.length() -2); i++) {
		System.out.print("ran outside");
		System.out.print(str.substring(i,i+1));
		 System.out.println(str.substring(i+1,i+2));
	    if (str.substring(i,i+1) == "h") {
			System.out.println("ran once");
	      if (str.substring(i+1,i+2) == "i") {
		      if 
		System.out.println("ran");
	        counter++;
	      }
	    }
	  }
	  return counter;
	}

	public static void main(String[] args) {
		System.out.println(countHi("hihihi"));
	}
}
