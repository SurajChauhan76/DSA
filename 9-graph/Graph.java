import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    // The Adjacency List
    private HashMap<Integer, List<Integer>> adjList;
    
    public Graph() {
        adjList = new HashMap<>();
    }

    // Helper method to make sure a node exists in the map with an empty list
    public void addNode(int node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    // Add an undirected edge between node 'u' and node 'v'
    public void addEdge(int u, int v) {
        // Step 1 - Ensure both nodes exist in the map!
        // Call the addNode() helper method for both 'u' and 'v'just in case they haven't been added to the graph yet.
        addNode(u);
        addNode(v);

        // Step 2 - Add the connection from 'u' to 'v'
        // Get the list of neighbors for 'u' from the map, and add 'v' to that list.
        adjList.get(u).add(v);

        // Step 3 - Add the connection from 'v' to 'u'
        // Because this is an UNDIRECTED graph, the connection goes both ways!
        // Get the list of neighbors for 'v' from the map, and add 'u' to that list.
        adjList.get(v).add(u);
    }

    public void printGraph() {
        for (int node: adjList.keySet()) {
            System.out.println("Node " + node + " is connected to: " + adjList.get(node));
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();

        // Let's build a triangle: 1 connects to 2, 2 connects to 3, 3 connects to 1.
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.printGraph();

        /* Expected Output (order may vary):
           Node 1 is connected to: [2, 3]
           Node 2 is connected to: [1, 3]
           Node 3 is connected to: [2, 1]
        */
    }
}
