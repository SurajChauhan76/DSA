// An input string is valid if:  
// Open brackets must be closed by the same type of brackets.  
// Open brackets must be closed in the correct order.  
// Every close bracket has a corresponding open bracket of the same type.
import java.util.Deque;
import java.util.ArrayDeque;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            // Step 1: Push opening brackets
            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            }
            // Step 2: Handle closing brackets
            else if (current == ')' || current == '}' || current == ']') {
                
                if (stack.isEmpty()) {
                    return false;
                } 
                
                char popped = stack.pop();
                
                // Check if they form a valid pair!
                if (current == ')' && popped != '(') return false;
                if (current == '}' && popped != '{') return false;
                if (current == ']' && popped != '[') return false;
            }
        }

        // Step 3: Check for leftovers
        return stack.isEmpty(); // Fun fact: you can just return the boolean directly!
    }
     
    
    // Interview Pro-Tip: The "Push the Opposite" Trick
    public static boolean isValid2(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        // for each loop after converting the string into character array
        for (char current : s.toCharArray()) {
            // If we see an open bracket, push its corresponding closing bracket
            if (current == '(') stack.push(')');
            else if (current == '{') stack.push('}');
            else if (current == '[') stack.push(']');

            // If it's a closing bracket, it MUST match whatever is on top of the stack!
            else if (stack.isEmpty() || stack.pop() != current) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("()[]{} : " + isValid("()[]{}")); // Expected: true
        System.out.println("([)] : " + isValid("([)]"));     // Expected: false
        System.out.println("{[]} : " + isValid("{[]}"));     // Expected: true
        System.out.println("] : " + isValid("]"));           // Expected: false
        System.out.println("()[]{} : " + isValid2("()[]{}")); // Expected: true
        System.out.println("([)] : " + isValid2("([)]"));     // Expected: false
        System.out.println("{[]} : " + isValid2("{[]}"));     // Expected: true
        System.out.println("] : " + isValid2("]"));           // Expected: false
    }
}
