import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;

        // The Deque stores indices, and maintains them in decreasing order of their values
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            // TODO: Step 1 - The Queue Rule (Remove Expired)
            // If the deque is not empty AND the index at the FRONT of the deque
            // is out of the current window bounds (which is strictly less than i - k + 1).
            // Kick it out using deque.pollFirst()
            if (!deque.isEmpty() && deque.peekFirst() < (i - k + 1)) {
                deque.pollFirst();
            }

            // TODO: Step 2 - The Monotonic Rule (Remove Smaller)
            // While the deque is not empty AND the current number (nums[i]) is GREATER 
            // than the number at the index sitting at the BACK of the deque...
            // Kick them out using deque.pollLast()
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // TODO: Step 3 - Add the current index 'i' to the BACK of the deque
            // (Use deque.offerLast(i))
            deque.offerLast(i);

            // TODO: Step 4 - Record the Maximum
            // Our window is fully formed once we've processed at least 'k' elements.
            // If i is greater than or equal to (k - 1), grab the number at the index 
            // sitting at the FRONT of the deque, and store it in result[resultIndex++]
            if (i >= (k - 1)) {
                result[resultIndex++] = nums[deque.peekFirst()]; 
            }
        }

        return result;
    }  
    
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(result));
        // Expected Output: [3, 3, 5, 5, 6, 7]
    }
    
}
