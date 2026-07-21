import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        // Edge Case: If the lengths are different, they can't be anagrams
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> counts = new HashMap<>();

        // TODO: Step 1 - Build the inventory from string 's'
        for (int i =0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Add the character to the map, incrementing its count by 1
            // int currentCount = counts.getOrDefault(c, 0);
            // counts.put(c, currentCount + 1);

            // Pro-tip: This can be done in one line
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // TODO: Step 2 - "Shop" from the inventory using string 't'
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            // Check if the character exists in the map at all.
            // If it doesn't, or if its count is 0, then we can't fulfill the shopping list! Return false.
            if (!counts.containsKey(c) || counts.get(c) == 0) {
                return false;
            }

            // Otherwise, decrement the count of this character by 1 in the map.
            counts.put(c, counts.get(c) - 1);
        }

        // TODO: Step 3 - If we successfully finished the shopping list, return true!
        return true;
    }


    // --- "Senior Engineer" Optimization Trick: The ASCII Array Trick (10x faster) ---
    // If we subtract 'a' from any lowercase letter, we get a perfect 0-25 index.
    // This means we can use an int[] array of size 26 as our frequency map!
    public static boolean isAnagramOptimized(String s, String t) {
        if (s.length() != t.length()) return false;

        // Our lightweight "HashMap" for 26 lowercase letters
        int[] counts = new int[26];

        // Build the inventory
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        // Shop from the inventory
        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i) - 'a']--;

            // If the count drops below 0, 't' has a letter that 's' doesn't!
            if (counts[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("anagram vs nagaram: " + isAnagram("anagram", "nagaram")); // true
        System.out.println("rat vs car: " + isAnagram("rat", "car"));                 // false
        System.out.println("a vs ab: " + isAnagram("a", "ab"));  
                             // false
        System.out.println("a vs ab: " + isAnagramOptimized("a", "ab"));                       // false
    }
}
