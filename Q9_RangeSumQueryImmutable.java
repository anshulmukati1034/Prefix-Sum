public class Q9_RangeSumQueryImmutable {

    private int[] prefix;

    // Constructor (must NOT be static and must match class name)
    public Q9_RangeSumQueryImmutable(int[] nums) {
        int n = nums.length;

        prefix = new int[n];

        if (n > 0) {
            prefix[0] = nums[0];
        }

        // Build prefix sum
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) return prefix[right];
        return prefix[right] - prefix[left - 1];
    }

    // MAIN FUNCTION
    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};

        Q9_RangeSumQueryImmutable obj = new Q9_RangeSumQueryImmutable(nums);

        System.out.println(obj.sumRange(0, 2));  // Output: 1
        System.out.println(obj.sumRange(2, 5));  // Output: -1
        System.out.println(obj.sumRange(0, 5));  // Output: -3
    }
}
