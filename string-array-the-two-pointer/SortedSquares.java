import java.util.Arrays;

public class SortedSquares {
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        
        int left = 0;
        int right = nums.length - 1;
        int resultIndex = nums.length - 1; // Start filling from the back!

        while (left <= right) { // We use <= so we don't miss the middle element
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            // TODO: Compare leftSquare and rightSquare
            // TODO: Place the larger one at result[resultIndex]
            // TODO: Move either the 'left' or 'right' pointer inward
            // TODO: Decrease resultIndex by 1

            if (leftSquare > rightSquare) {
                result[resultIndex] = leftSquare;
                left++;
                // resultIndex--;
            } else {
                result[resultIndex] = rightSquare;
                right--;
                // resultIndex--;
            }

            // Pro-tip: Since resultIndex goes down no matter what, 
            // we can write it just once outside the if/else block! (DRY Principle)
            resultIndex--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = sortedSquares(nums);
        
        System.out.println("Result: " + Arrays.toString(result)); 
        // Expected: [0, 1, 9, 16, 100]
    }
}
