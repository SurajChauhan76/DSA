public class DynamicWindow {
    // Example: Smallest subarray with a sum >= target
    public static int minSubArrayLen(int target, int[] arr) {
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int left = 0; // The back of the window

        for (int right = 0; right < arr.length; right++) {
            windowSum += arr[right]; // Expand the window

            // If we hit or exceed the target, try shrinking the window from the left
            while (windowSum >= target) {
                minLength = Math.min(minLength, right - left + 1);

                // Shrink the window
                windowSum -= arr[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = { 1, -5, 10, -1, 20, 2, 0 };
        int target = 25;

        System.out.println("Smallest subarray length: " + minSubArrayLen(target, nums));
    }
}
