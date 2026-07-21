// Two Iron-Clad Rules of Recursion
// 1. The Base Case (The Anchor)
// 2. The Recursivee Step (The Engine)

// Memory Error: StackOverflowError


public class RecursionBasics {
    public static int factorial(int n) {
        // The Base Case
        if (n == 1 || n == 0) {
            return 1;
        }

        // The Recursive Step
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 4 is: " + factorial(4)); // Expected: 24
        System.out.println("Factorial of 5 is: " + factorial(5)); // Expected: 120
    }
}
