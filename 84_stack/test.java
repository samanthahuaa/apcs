public class test {
	public static void main(String[] args) {
		String s = "HELLO";
		for (int i=0; i < s.length(); i++) {
			System.out.println(s.substring(i,i+1));
		}

		Latkes temp = new Latkes(10);
		temp.push("1");
		temp.push("2");
		temp.push("3");
		temp.push("twenty");
		System.out.println(temp.peek());

		System.out.println(true || false || false);
	}
}
