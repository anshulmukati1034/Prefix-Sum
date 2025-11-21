import java.util.HashMap;

public class Q10_ContiguousArray {

    public static int findMaxLength(int[] nums) {
        // Map to store prefixSum -> first index
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1); // prefix sum 0 before array starts

        int prefix = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            // Convert 0 to -1
            if (nums[i] == 0) prefix += -1;
            else prefix += 1;

            // If prefix already exists → subarray with sum 0 found
            if (map.containsKey(prefix)) {
                int len = i - map.get(prefix);
                maxLen = Math.max(maxLen, len);
            } else {
                // store first occurrence only
                map.put(prefix, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 1, 0};

        int ans = findMaxLength(nums);
        System.out.println("Longest Contiguous Array Length = " + ans);
    }
}
