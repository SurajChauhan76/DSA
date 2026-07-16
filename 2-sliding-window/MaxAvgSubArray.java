public class MaxAvgSubArray {
    public static double findMaxAverage(int[] nums, int k) {
        // Edge case
        if (nums.length < k) return -1;

        // TODO: Step 1 - Initialize your tracking variables (e.g., maxSum)
        int maxSum = 0;
        int windowSum = 0;
        
        // TODO: Step 2 - Calculate the sum of the very first window (first 'k' elements)
        for (int i=0; i<k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;

        // TODO: Step 3 - Slide the window from index 'k' to the end of the array.
        // Add the new element, subtract the old element, and update maxSum if needed.
        for (int right=k; right<nums.length; right++) {
            windowSum = windowSum + nums[right] - nums[right-k];
            maxSum = Math.max(maxSum, windowSum);
        }
        
        // TODO: Step 4 - Return the maximum average
        return (double) maxSum / k; 
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println("Max Average: " + findMaxAverage(nums, k)); // Should print 12.75
    }
}