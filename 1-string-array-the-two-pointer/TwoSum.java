import java.util.Arrays; // Don't forget this import!

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0; 
        int right = numbers.length - 1; 

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] { left, right }; 
            } else if (sum < target) {
                left++; 
            } else {
                right--; 
            }
        }
        return new int[] { -1, -1 }; 
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7};
        
        // Wrap the result in Arrays.toString()
        int[] result = twoSum(arr, 10);
        System.out.println(Arrays.toString(result)); 
    }
}
