public class FixedSizeWindow {
    // Example: Max sum of a contiguous subarray of size 'k'
public static int maxSubArraySum(int[] arr, int k) {
    if (arr.length < k) return -1; // Edge case
    
    int maxSum = 0;
    int windowSum = 0;
    
    // Step 1: Calculate the first window
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    maxSum = windowSum;
    
    // Step 2: Slide the window
    for (int right = k; right < arr.length; right++) {
        // Add the new element entering the window
        // Subtract the old element leaving the window
        windowSum = windowSum + arr[right] - arr[right - k];
        
        maxSum = Math.max(maxSum, windowSum);
    }
    
    return maxSum;
}

public static void main(String[] args) {
    int [] nums = {1, 3, 10, 35, 0, 15, 1};
    int k = 4;

    System.out.println("Maximum sum: " + maxSubArraySum(nums, k));
}
}
