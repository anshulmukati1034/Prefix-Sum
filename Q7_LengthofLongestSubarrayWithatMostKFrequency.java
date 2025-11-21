import java.util.HashMap;
import java.util.Map;

public class Q7_LengthofLongestSubarrayWithatMostKFrequency {

    public static int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        // prefix for length (not sum)
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) prefix[i] = i;

        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < n; right++) {

            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            // shrink window if freq violates
            while (freq.get(nums[right]) > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                left++;
            }

            // window length using prefix logic
            int windowLen = prefix[right] - prefix[left] + 1;
            maxLen = Math.max(maxLen, windowLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1, 2, 3, 3};
        int k = 2;

        int ans = maxSubarrayLength(nums, k);

        System.out.println("Longest subarray length with at most K frequency = " + ans);
    }
}
