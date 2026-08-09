import java.util.Deque;
import java.util.ArrayDeque;

public class HistogramLargestRect {
    
    public static int largestRectangleArea(int[] heights) {
        // Edge case
        if (heights == null || heights.length == 0) return 0;
        
        // stack holds the indices of the histogram bars.
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // Treat the end of the array as a bar of height 0 to flush remaining elements
            int currentHeight = (i == n) ? 0 : heights[i];

            // Maintain a strictly increasing stack of heights
            while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                int height = heights[stack.pop()];

                // If stack is empty, it means this bar was the shortest so far (width is 'i')
                // Otherwise, the width is bounded between current index and the new top of stack
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println("Maximum Rectangle Area: " +  largestRectangleArea(heights));
        // Expected Output: 10 (formed by bars 5 and 6 with height 5 and width 2)
    }
}

/*
How the Algorithm Works:

* Monotonic Increasing Stack: We push index (i) onto the stack as long as 
heights[i] is greater than or equal to the height at the top of the stack. 
This keeps heights in sorted increasing order.

* Encountering a Smaller Bar: When we see a bar shorter than the top of the stack, 
it means the bar at the top of the stack cannot extend any further to the right.

* Calculating the Area:We pop the top index from the stack. This is our rectangle's height.
The right boundary is the current index i (the bar that triggered the pop).
The left boundary is the new top of the stack (the next smaller element to the left).

* Formula for width: width = i - stack.peek() - 1. 
If the stack becomes empty, the popped bar was the smallest seen so far, so width = i.

The Dummy Zero: Appending a virtual bar of height 0 at index n forces the algorithm 
to pop and calculate areas for all remaining bars left in the stack at the end of the loop.
*/