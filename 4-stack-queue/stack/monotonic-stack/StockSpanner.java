import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {

    static class MyStockSpanner {
        Deque<int[]> stack;

        public MyStockSpanner() {
            stack = new ArrayDeque<>();
        }

        public int nextSpan(int price) {
            int span = 1;

            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                span += stack.pop()[1];
            }

            stack.push(new int[]{price, span});
            return span;
        }
    }

    public static void main(String[] args) {
        MyStockSpanner spanner = new MyStockSpanner();

        System.out.println(spanner.nextSpan(100)); // Returns 1
        System.out.println(spanner.nextSpan(80));  // Returns 1
        System.out.println(spanner.nextSpan(60));  // Returns 1
        System.out.println(spanner.nextSpan(70));  // Returns 2
        System.out.println(spanner.nextSpan(60));  // Returns 1
        System.out.println(spanner.nextSpan(75));  // Returns 4
        System.out.println(spanner.nextSpan(85));  // Returns 6
    }
}

/* 
Why It Fails Inside the Method
* State Reset: Every time your program calls next(), a brand-new, empty deque is created in memory.
* Loss of History: The method completely forgets all stock prices from previous days.
* Incorrect Output: The loop while (!stack.isEmpty()) will never execute because the stack is always empty.
* Constant Result: The function will always return 1 for every single price call, failing to calculate spans across multiple days.

Class Scope vs. Method Scope
* Class Field (Instance Variable): Keeps the deque alive across multiple calls to next(), maintaining the historical record of prices.
* Method Variable (Local Variable): Destroys the deque as soon as the next() method finishes executing and hits the return statement.
*/