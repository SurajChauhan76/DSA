import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    
    // Declare the Queue at the class level so it persists between pings
    Queue<Integer> queue;

    public RecentCounter() {
        // TODO: Step 1 - Initialize the queue
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        // TODO: Step 2 - Enqueue the new request time 't'
        // Note: The method to add to a Queue is .offer(t) or .add(t)
        queue.add(t);

        // TODO: Step 3 - Create a while loop to remove expired timestamps.
        // Condition: While the queue is not empty AND the time at the front of the queue is LESS than (t - 3000)...
        // Note: Use .peek() to look at the front, and .poll() or .remove() to kick it out.
        while (!queue.isEmpty() && queue.peek() < (t - 3000)) {
            // Remove the expired timestamp
            queue.remove();
        }

        // TODO: Step 4 - Return the current size of the queue
        return queue.size();
    }

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();

        System.out.println("Ping at 1ms. Recent calls: " + counter.ping(1));        // Expected: 1
        System.out.println("Ping at 100ms. Recent calls: " + counter.ping(100));    // Expected: 2
        System.out.println("Ping at 3001ms. Recent calls: " + counter.ping(3001));  // Expected: 3
        System.out.println("Ping at 3002ms. Recent calls: " + counter.ping(3002));  // Expected: 3
    }
}

// Explanation for 3002: The queue had [1, 100, 3001]. We add 3002. 
// The window is [2, 3002]. The ping at '1' is expired and gets removed. 
// Valid pings left: [100, 3001, 3002]. Size is 3.