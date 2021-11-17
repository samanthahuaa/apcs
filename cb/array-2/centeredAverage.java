/**
Return the "centered" average of an array of ints, which
we'll say is the mean average of the values, except ignoring 
the largest and smallest values in the array. If there are
multiple copies of the smallest value, ignore just one copy,
and likewise for the largest value. Use int division to produce
the final average. You may assume that the array is length 3 or more.
*/public class centeredAverage {
	public static int centeredAve(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
			if (nums[i] < min) {
				min = nums[i];
			}
			total += nums[i];
		}
		return (total-min-max)/(nums.length - 2);
	}
	public static void main(String[] args) {
		int[] test0 = {1, 2, 3, 4, 100};
		int[] test1 = {1, 1, 5, 5, 10, 8, 7};
		int[] test2 = {-10, -4, -2, -4, -2, 0};

		System.out.println(centeredAve(test0));
                System.out.println(centeredAve(test1));
                System.out.println(centeredAve(test2));
	}
}
