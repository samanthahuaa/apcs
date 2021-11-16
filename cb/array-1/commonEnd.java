public class commonEnd{
	public static boolean commonEnd1(int[] a, int[] b) {
		if ((a[0] == b[0]) || (a[a.length-1] == b[b.length-1])) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		int[] test = {1,2,3};
		int[] second0 = {7,3};
		int[] second1 = {7,3,2};
		int[] second2 = {1,3};

		System.out.println(commonEnd1(test, second0));
		System.out.println(commonEnd1(test, second1));
		System.out.println(commonEnd1(test, second2));
	}

}
