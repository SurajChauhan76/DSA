// Problem: Write an algorithm to determine if a number n is happy.
// A happy number is a number defined by the following process:  

// - Starting with any positive integer, replace the number by the sum of the squares of its digits.  

// - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.  

// - Those numbers for which this process ends in 1 are happy (return true). Otherwise, they are unhappy (return false).

import java.util.HashSet;

public class HappyNumber {
    
    // Helper method to calculate the sum of the squares of the digits
    private static int getNextNumber(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;  // Remainder: to get the ones place digit
            totalSum += digit * digit;
            n = n / 10;  // Excluding the ones place digit
        }
        return totalSum;
    }

    public static boolean isHappy(int n) {
        // TODO: Step 1 - Initialize your HashSet to track the numbers you've seen
        HashSet<Integer> set = new HashSet<>();

        // TODO: Step 2 - Create a while loop.
        // We keep calculating the next number AS LONG AS n is not 1.
        while (n != 1) {

            // TODO: Step 3 - Try to add 'n' to the HashSet.
            // If the set rejects it (!set.add(n)), we found a cycle! Return false.
            if (!set.add(n)) {
                return false;
            }

            // TODO: Step 4 - If it wasn't a cycle, calculate the next number in the sequence using the helper method.
            n = getNextNumber(n);
        }

        // TODO: Step 5 - If the loop finishes because n == 1, the number is happy! Return true.
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Is 19 happy?: " + isHappy(19));  // Expected: true
        System.out.println("Is 2 happy?: " + isHappy(2));    // Expected: false
    }
}


// This is the exact logic you will use if you ever need to detect a cycle in a Linked List (using a set of Nodes instead of Integers) or any other sequence graph.