import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    
    public static int subarraySumKCounts(int[] nums, int k) {
        int count = 0;
        int currentPrefixSum = 0;

        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        // Base case: A prefix sum of 0 has occurred 1 time initially.
        prefixSumMap.put(0, 1);

        for (int num : nums) {
            currentPrefixSum += num;

            // Define the complement we need to find.
            int complement = currentPrefixSum - k;

            if (prefixSumMap.containsKey(complement)) {
                count += prefixSumMap.get(complement);
            }

            // Record/Update the frequency of the current prefix sum
            prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 7, 2, -3, 1, 4};
        int k = 7;

        System.out.println("Subarray sum eauls " + k + " counts: " + subarraySumKCounts(nums, k));
    }
}


// Time Complexity: (O(N)) — We traverse the array exactly once, performing (O(1)) map lookups at each step.
// Space Complexity: (O(N)) — In the worst case, the map stores a unique prefix sum for every single index.