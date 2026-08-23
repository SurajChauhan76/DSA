// Count the combinations of (u, v, w, z) each representing a element from different 4 arrays, thier sum results in zero.

import java.util.HashMap;
import java.util.Map;

public class FourSum {
    
    public static int fourSumIICount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // Store all possible sums of nums1 & nums2 in the map
        for (int u : nums1) {
            for (int v : nums2) {
                int sum = u + v;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // Compute complement and check if exists in the map. If yes then increment the count
        for (int w : nums3) {
            for (int z : nums4) {
                int targetComplement = - (w + z);

                if (map.containsKey(targetComplement)) {
                    count += map.get(targetComplement);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, -3};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};

        System.out.println("Four sum count: " + fourSumIICount(nums1, nums2, nums3, nums4));
    }
}

// Time: O(n2)
// Space: O(n2)