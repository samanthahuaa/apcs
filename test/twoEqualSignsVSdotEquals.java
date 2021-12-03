public class twoEqualSignsVSdotEquals {
	public static void main(String[] args) {

		//INTEGER TESTING
		Integer test1 = 100;

		Integer a = new Integer(5);
		Integer b = new Integer(5);
		System.out.println(a==b); //false
		System.out.println(a.equals(b)); //true

		Integer c = 4;
		Integer d = 4;
		System.out.println(c==d); //true
		System.out.println(c.equals(d)); //true

		c += 1; //c takes the value of c+1  = 5
		System.out.println("c: "+c);
		System.out.println("d: "+d); //4 - while both c and d point to the same memory location, their values are able to become distinct
		System.out.println(c==d); //false - new memory is being allocated for the updated variable since they don't have the same value anymore (they don't point to the same memory location)
		System.out.println(c.equals(d)); //false

		Integer test2 = 100;
		System.out.println(test1.equals(test2)); //true - even though the two variables are in different parts of the file, Java recognizes that they have the same value and allows them to point to the same memory location

		//STRING TESTING
		System.out.println("==========STRING TIME==========");

		String e = new String("boop");
		String f = new String("boop");
		System.out.println(e==f); //false
		System.out.println(e.equals(f)); //true

		String g = "lalala";
		String h = "lalala";
		System.out.println(g==h); //true
		System.out.println(g.equals(h)); //true

	}
}
