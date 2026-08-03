import java.util.Arrays;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int slow = 0; // Tracks the position of the last unique element

        // 'fast' is our scout. It checks every single element.
        for (int fast = 1; fast < nums.length; fast++) {
            // If we find a NEW unique element...
            if (nums[fast] != nums[slow]) {
                slow++; // Move our unique tracker forward
                nums[slow] = nums[fast]; // Overwrite the duplicate with the new unique number
            }
        }

        // The length of the unique portion is index + 1
        return slow + 1;
    }


    public static void main(String[] args) {
        // int [] arr = {1, 1, 2, 3, 5, 6, 7, 2, 1}; // This array is not sorted and it results in incorrect output
        int [] arr = {1, 1, 1, 2, 2, 3, 5, 6, 7};  // Ensure the array is sorted
        int res = removeDuplicates(arr); // Gives the length of the unique array
        System.out.println(res);

        // arr = {1, 2, 3, 5, 6, 7, 5, 6, 7};  // Upto index 6 array contains the unique values but after that it contains the Garbage as array size can't be shrink hence after index 6 the same elements from original array are copied.
        System.out.println(Arrays.toString(arr));

        int[] uniqueArr = Arrays.copyOfRange(arr, 0, res);
        System.out.println(Arrays.toString(uniqueArr));
    }
}
