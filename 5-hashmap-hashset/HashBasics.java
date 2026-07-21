// Main Methods: 
// Hash Set: .add(item), .contains(item), .remove(item)
// Hash Map: .put(key, value), .get(key), .containsKey(key)

import java.util.HashSet;
import java.util.HashMap;

public class HashBasics {
    public static void main(String[] args) {

        // --- Hash Set ---
        HashSet<String> seenNumbers = new HashSet<>();
        seenNumbers.add("42");
        seenNumbers.add("99");
        seenNumbers.add("42"); // Ignored! Sets only keep unique items.

        System.out.println(seenNumbers.contains("99")); // true, takes O(1) time!


        // --- Hash Map ---
        HashMap<String, Integer> inventory = new HashMap<>();
        // .put(key, value)
        inventory.put("Apples", 10);
        inventory.put("Bananas", 5);

        // .get(key) returns the value
        System.out.println(inventory.get("Apples")); // Prints 10
        
        // Update a value
        inventory.put("Apples", 15); // Overwrites the old value
        
        System.out.println(inventory.get("Apples")); // Prints 10
    }    
}
