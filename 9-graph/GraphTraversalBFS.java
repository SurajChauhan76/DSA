import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Graph {
    private HashMap<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    } 

    public void addNode(int node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        addNode(u);
        addNode(v);
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    // --- BFS Method ---
    public void bfs(int startNode) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        // Step 1 - The Initial State
        // Add the startNode to the 'visited' set AND offer it to the 'queue'.
        visited.add(startNode);
        queue.offer(startNode);

        // Step 2 - The BFS Loop
        // Create a while loop that runs as long as the queue is NOT empty.
        while (!queue.isEmpty()) {
            // Pop the front node off the queue
            int currentNode = queue.poll();

            // Print it out
            System.out.print(currentNode + " ");

            // Loop through all the neighbors of the current node
            for (int neighbor : adjList.get(currentNode)) {
                
                // Try to add the neighbor to the visited set.
                // If it successfully adds it (returns true), offer it to the queue!
                if (visited.add(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
    }
}
public class GraphTraversalBFS {
    public static void main(String[] args) {
        Graph g = new Graph();

        // Build a graph: 1 connects to 2 and 3. 2 connects to 4.
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        System.out.println("BFS Traversal starting from 1:");
        g.bfs(1);

        // Expected Output: 1 2 3 4
        // (Notice it visits 2 and 3 before diving into 4!)
    }
}
