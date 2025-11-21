import java.util.HashMap;
import java.util.Map;

public class Q4_SubarraySumsDivisiblebyK {

    public static int subarraysDivByK(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // empty prefix has remainder 0

        int prefix = 0;
        int count = 0;

        for (int num : nums) {
            prefix += num;

            int rem = prefix % k;

            // Important: handle negative remainder
            if (rem < 0) rem += k;

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;

        int result = subarraysDivByK(nums, k);

        System.out.println("Subarrays divisible by " + k + " = " + result);
    }
}
