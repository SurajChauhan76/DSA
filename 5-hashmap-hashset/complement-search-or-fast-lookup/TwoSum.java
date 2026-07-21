import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // Map will store: <The Number, Its Index>
        HashMap<Integer, Integer> visited = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            // TODO: Step 1 - Calculate the complement we need to reach the target
            int complement = target - current;

            // TODO: Step 2 - Check if the map CONTAINS the complement
            if (visited.containsKey(complement)) {
                // We found it!
                // TODO: Step 3 - Get the index of the complement from the map using visited.get()
                int compIndex = visited.get(complement);

                // Return a new integer array containing the complement's index and the current index 'i'
                return new int[] {compIndex, i};
            }

            // TODO: Step 4 - If we didn't find the compelement, we need to remember this number for the future!
            // Put the current number AND its index into the map using visited.put(Key, Value)
            visited.put(current, i);
        }

        // We should never reach here if solution is guaranteed, but Java requires a return statement.
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result)); // Expected: [0, 1]

        int[] nums2 = {2, 15, 7, 11}; // unsorted
        int[] result2 = twoSum(nums2, target);
        System.out.println(Arrays.toString(result2)); // Expected: [0, 2]

    }
}
