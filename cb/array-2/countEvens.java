//Return the number of even ints in the given array.
// Note: the % "mod" operator computes the remainder,
// e.g. 5 % 2 is 1.
public class countEvens {
	public static int countEven(int[] nums) {
		int counter = 0;
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] % 2) == 0) {
				counter += 1;
			}
		}
		return counter;
	}
	public static void main(String[] args) {
		int[] test0 = {2, 1, 2, 3, 4};
		int[] test1 = {2, 2, 0};
		int[] test2 = {1, 3, 5};

		System.out.println(countEven(test0));
                System.out.println(countEven(test1));
                System.out.println(countEven(test2));
	}
}
