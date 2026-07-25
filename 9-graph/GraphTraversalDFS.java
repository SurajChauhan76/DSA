import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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

    // --- DFS Method ---
    public void dfs(int startNode, HashSet<Integer> visited) {
        // Step 1 - The Base Case (Cycle Prevention)
        // Try to add 'startNode' to the 'visited' set.
        // If set returns false (it was already there), just return; to stop!
        if (!visited.add(startNode))
            return;

        // Step 2 - Process the node
        // Lets print it to see the path the algorithm takes
        System.out.print(startNode + " ");

        // Step 3 - The Recursive step
        // 1. Get the list of neighbors for 'startNode' from adjList
        // 2. Loop through each neighbor.
        // 3. For each neighbor, recursively call dfs(neighbor, visited)
        for (int neighbor : adjList.get(startNode)) {
            dfs(neighbor, visited);
        }
    }
}

public class GraphTraversalDFS {
    public static void main(String[] args) {
        Graph g = new Graph();

        // Build the triangle graph
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("DFS Traversal starting from 1:");
        // Initialize the empty visited set and kick off the DFS
        HashSet<Integer> visited = new HashSet<>();
        g.dfs(1, visited);
        // Expected Output: 1 2 3 (It should NOT loop forever!)
    }
}

// Time Complexity of Graph Traversal
// In a Graph, we have Vertices (Nodes) and Edges (Connections). We visit every Node once (thanks to our HashSet), and we loop through every single Edge to see where we can go.
// Therefore, the Time Complexity is O(V + E) (where V is Vertices and E is Edges).