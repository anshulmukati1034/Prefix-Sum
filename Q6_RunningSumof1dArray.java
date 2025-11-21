public class Q6_RunningSumof1dArray {
    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int[] result = runningSum(nums);

        System.out.print("Running Sum: ");
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
