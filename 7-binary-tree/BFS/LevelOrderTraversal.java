// The BFS Algorithm
// To process a tree level by level, we use a Queue. Here is the strict set of rules to make it work:

// 1. Enqueue the Root: Start by pushing the very first node into the queue.

// 2. Measure the Level: Before you start popping, look at the size of the queue. That exact number tells you how many nodes are on the current level.

// 3. Process the Level: Create a for loop that runs size times. Inside the loop:

//  - Pop a node off the front of the queue.

//  - Add its value to your results list.

//  - Enqueue its left child (if it exists).

//  - Enqueue its right child (if it exists).

// Because a Queue is strictly First-In-First-Out, all the children you push to the back of the line will patiently wait until the current level finishes processing.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // We use a LinkedList to implement the Queue for our nodes
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Start by enqueuing the root

        while (!queue.isEmpty()) {
            // Step 1 - Measure the level
            // Get the current size of the queue. This is exactly how many nodes are the current level.
            int levelSize = queue.size();

            // This list will hold the values for just this level
            List<Integer> currentLevel = new ArrayList<>();

            // Step 2 - Process the Level
            // Create a for-loop that runs exactly 'levelSize' times.
            for (int i = 0; i < levelSize; i++) {

                // 1. Pop the front node off the queue using queue.poll().
                TreeNode frontNode = queue.poll();

                // 2. Add the node's value to the 'currentLevel' list.
                currentLevel.add(frontNode.val);

                // 3. If the node has left child, enqueue it using queue.offer().
                if (frontNode.left != null) {
                    queue.offer(frontNode.left);
                }

                // 4. If the node has a right child, enqueue it
                if (frontNode.right != null) {
                    queue.offer(frontNode.right);
                }
            }

            // Step 3 - Add the completed level to the final result list.
            result.add(currentLevel);
        }

        return result;
    }   

    public static void main(String[] args) {
        // Building the tree: [3, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        List<List<Integer>> output = levelOrder(root);
        System.out.println("Level Order: " + output);
        // Expected: [[3], [9, 20], [15, 7]]
    }
}

// The Complexity BreakdownIf an interviewer asks you to analyze this:
// Time Complexity: O(n). You visit every single node in the tree exactly once.

// Space Complexity: O(n) (or more accurately, O(w) where w is the maximum width of the tree). 
// In the worst-case scenario (a perfectly balanced tree), the very bottom level holds roughly half of all the nodes in the entire tree, 
// which means your Queue will hold about n/2 nodes at the very end.