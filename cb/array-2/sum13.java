/*
Return the sum of the numbers in the array, returning 0 for an
empty array. Except the number 13 is very unlucky, so it does
not count and numbers that come immediately after a 13 also do not count.
*/

public class sum13 {
	public static int sumThreeTeens(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i ++) {
			sum += nums[i];
			if (nums[i] == 13) {
				sum = sum - 13;
				if ((nums.length-1 > i) && (nums[i + 1] != 13)) {
					sum = sum - nums[i + 1];
				}
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] test0 = {1, 2, 2, 1};
		int[] test1 = {1, 1};
		int[] test2 = {1, 2, 2, 1, 13};

		System.out.println(sumThreeTeens(test0));
                System.out.println(sumThreeTeens(test1));
                System.out.println(sumThreeTeens(test2));
	}
}
