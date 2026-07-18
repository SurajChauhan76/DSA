import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length]; 
        
        // Remember: The stack holds INDICES, not the actual temperatures!
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            
            // TODO: Create the while loop. 
            // Condition: stack is not empty AND the current temperature is GREATER 
            // than the temperature at the index stored at the top of the stack.
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                
                // TODO: Pop the waiting index from the stack
                int waitingIndex = stack.pop();

                // TODO: Calculate how many days we waited. 
                // Hint: The current day is 'i'. The day we started waiting is the popped index.
                // Store this difference in the result array at the correct spot!
                result[waitingIndex] = i - waitingIndex;
            }
                
            // TODO: Push the current index 'i' onto the stack to wait for a warmer day
              stack.push(i);  
        }

        return result;
    }

    public static void main(String[] args) {
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(temps);
        
        // Expected Output: [1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println(Arrays.toString(result)); 
    }
}