/*
Return the sum of the numbers in the array, except ignore
sections of numbers starting with a 6 and extending to the
next 7 (every 6 will be followed by at least one 7). Return 0 for no numbers.
*/

public class sum67 {
	public static int sumsixty7(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (nums[i] == 6) {
				sum = sum - 6;
				while (nums[i] != 7) {
					i = i + 1;
				}
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] test0 = {1, 2, 2};
		int[] test1 = {1, 2, 2, 6, 99, 99, 7};
		int[] test2 = {1, 1, 6, 7, 2};

		System.out.println(sumsixty7(test0));
                System.out.println(sumsixty7(test1));
                System.out.println(sumsixty7(test2));
	}
}
