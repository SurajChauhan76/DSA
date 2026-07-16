import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;

        // This Set will act as our "window" to track unique characters
        Set<Character> window = new HashSet<>();

        // TODO: Step 1 - Use a for-loop to move the 'right' pointer across the string
        // Hint: You can get a character using s.charAt(right)
        for (int right = 0; right < s.length(); right++) {

            // TODO: Step 2 - If the character at 'right' is ALREADY in the Set (a
            // duplicate!)...
            // We must shrink the window from the left.
            // Use a while loop to remove s.charAt(left) from the Set and increment 'left'
            // until the duplicate is gone.
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }

            // TODO: Step 3 - Add the current character at 'right' to the Set
            window.add(s.charAt(right));

            // TODO: Step 4 - Calculate the current window size (right - left + 1)
            // Update maxLength if this window is the biggest one we've seen so far
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String testString = "abcabcbb";
        System.out.println("Longest substring length: " + lengthOfLongestSubstring(testString));
        // Should print 3
    }
}