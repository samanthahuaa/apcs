//Given an array length 1 or more of ints, return the
// difference between the largest and smallest values
// in the array. Note: the built-in Math.min(v1, v2) and
// Math.max(v1, v2) methods return the smaller or larger
// of two values.

public class bigDiff {
	public static int bigDif(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
			if (nums[i] < min) {
				min = nums[i];
			}
		}
		return max - min;
	}
	public static void main(String[] args) {
		int[] test0 = {10, 3, 5, 6};
		int[] test1 = {7, 2, 10, 9};
		int[] test2 = {2, 10, 7, 2};

		System.out.println(bigDif(test0));
  		System.out.println(bigDif(test1));
   		System.out.println(bigDif(test2));
	}
}
