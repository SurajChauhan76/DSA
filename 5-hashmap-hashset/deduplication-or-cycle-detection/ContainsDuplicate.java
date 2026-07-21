import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        // TODO: Step 1 - Initialize your HashSet to hold Integers
        HashSet<Integer> set = new HashSet<>();

        for (int num: nums) {

            // TODO: Step 2 - Try to add the 'num' to the set.
            // If the set rejects it (returns false), you found a duplicate! Return true
            if (!set.add(num)) {
                return true;
            }
        }

        // TODO: Step 3 - If the loop finishes without finding any duplicates, return false.
        return false;
    }    

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Result 1: " + containsDuplicate(nums1));

        int [] nums2 = {1, 2, 3, 4};
        System.out.println("Result 2: " + containsDuplicate(nums2));
    }
}

// In Java, the .add() method for a HashSet actually returns a boolean!

// - It returns 'true' if the item was successfully added (it was new).

// - It returns 'false' if the item was rejected (it was already in the set).