// Next greater element or Daily temperature
// Monotonic means strictly increasing or decreasing
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums) {
        int[] result = new int[nums.length];

        // If an element never finds a greater element, the answer is usually -1
        Arrays.fill(result, -1);

        // The stack will hold the INDICES of the elements waiting for a greater number
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++) {

            // THE MONOTONIC RULE:
            // While the stack is not empty AND 
            // the current number is GREATER than the number sitting at the top of the stack...
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){

                // We found the next greater element for the index at the top of the stack!
                int waitingIndex = stack.pop();
                result[waitingIndex] = nums[i];
            }
            // Now that all smaller elements have been kicked out, the current index goes into the waiting room.
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {6, 8, 0, 1, 3};
        int[] result = nextGreaterElement(nums);

        System.out.println(Arrays.toString(result));
        // Output: [8, -1, 1, 3, -1]
    }
}


// Key insight: The while loop inside the for loop looks like it might make the time complexity O(n^2). 
// But it doesn't! Since every index goes into the stack exactly once and comes out exactly once, the total operations across the entire array is just 2n. 
// Dropping the constant gives us a strict O(n) time complexity.