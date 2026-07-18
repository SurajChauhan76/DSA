// Today, the industry standard is to use the Deque (Double-Ended Queue) interface for both Stacks and Queues. 
// It is typically implemented using an ArrayDeque.
import java.util.Deque;
import java.util.ArrayDeque;

public class StackQueueExample {
    public static void main(String[] args) {
        // -- Implementing a STACK (LIFO) --
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);  // [10]
        stack.push(20);  // [20, 10]
        stack.push(30);  // [30, 20, 10]

        System.out.println(stack.pop()); // Removes & prints 30


        // -- Implementing a QUEUE (FIFO) --
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(10);  // [10]
        queue.offer(20);  // [10, 20]
        queue.offer(30);  // [10,20,30]

        System.out.println(queue.poll()); // Removes & prints 10
    }    
}
