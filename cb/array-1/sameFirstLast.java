public class sameFirstLast {
	public static boolean sameFL(int[] nums) {
		if ((nums.length != 0) && (nums[0] == nums[nums.length-1])) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] test0 = {1,2,3};
		int[] test1 = {1,2,3,1};
		int[] test2 = {1,2,1};

		System.out.println(sameFL(test0));
		System.out.println(sameFL(test1));
		System.out.println(sameFL(test2));
	}
}
