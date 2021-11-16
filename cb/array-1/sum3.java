public class sum3{
	public static int sumThree(int[] nums) {
		return nums[0]+nums[1]+nums[2];
	}
	public static void main(String[] args) {
		int[] test0 = {1,2,3};
		int[] test1 = {5,11,2};
		int[] test2 = {7,0,0};

		System.out.println(sumThree(test0));
		System.out.println(sumThree(test1));
		System.out.println(sumThree(test2));
	}
}
