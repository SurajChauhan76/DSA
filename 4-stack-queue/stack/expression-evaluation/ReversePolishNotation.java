/* The Stack Algorithm
Here are the only two rules you need to know to evaluate an RPN expression:

-If you see a number: Push it onto the stack.

If you see an operator (+, -, *, /):

- Pop the top two numbers off the stack.

- Apply the operator to them.

- Push  the result back onto the stack. */

import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        // We need a stack of Integers to hold our operands
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {

            // TODO: Step 1 - Check if the token is an operator ("+", "-", "*", "/")
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {

                // TODO: Step 2 - Pop the top TWO numbers.
                // CRITICAL: The first popped is 'b' (right), the second popped is 'a' (left)
                int b = stack.pop();
                int a = stack.pop();

                // TODO: Step 3 - Perform the correct math operation and push the result back on stack
                int result = 0;

                if (token.equals("+")) result = a + b;
                else if (token.equals("-")) result = a - b;
                else if (token.equals("*")) result = a * b;
                else if (token.equals("/")) result = a / b;

                stack.push(result);
                
            } else {
                // TODO: Step 4 - If its not an operator, it must be a number!
                // Convert the String to an integer and push it onto the stack.
                stack.push(Integer.parseInt(token));
            }
        }

        // TODO: Step 5 - Return the final answer left in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Result 1: " + evalRPN(tokens1));
        // Expected: 9  (which is (2 + 1) * 3)

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Result 2: " + evalRPN(tokens2));
        // Expected: 6  (which is 4 + (13 / 5))
    }
}
