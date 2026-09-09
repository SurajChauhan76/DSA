import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue; 

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigZagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true; // Flag to track traversal direction

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Use a LinkedList for O(1) insertions at both ends
            List<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // Construct the level's result based on the current direction
                if (leftToRight) {
                    currentLevel.addLast(currentNode.val);
                } else {
                    currentLevel.addFirst(currentNode.val);
                }

                // Always add children to the queue left-to-right
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                } 
            }

            result.add(currentLevel);
            leftToRight = !leftToRight; // Flip the direction for the next level
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3, new TreeNode(4), new TreeNode(5));

        List<List<Integer>> result = zigZagLevelOrder(root);
        System.out.println("Zig zag level order traversal: " + result);
        // Expected output: [[1], [3, 2], [4, 5]]
    }
}


/*
How the Code Works:

Level 0 (Root): The queue starts with [3]. leftToRight is true. The code pulls 3, adds it to the end of currentLevel -> [3]. It queues the children [9, 20]. leftToRight flips to false.

Level 1: The queue has [9, 20]. leftToRight is false.

Pulls 9, adds to the front -> [9]. Queues its children (none).

Pulls 20, adds to the front -> [20, 9]. Queues its children [15, 7].

leftToRight flips to true.

Level 2: The queue has [15, 7]. leftToRight is true.

Pulls 15, adds to the end -> [15].

Pulls 7, adds to the end -> [15, 7].

leftToRight flips to false. The queue is now empty, so the loop terminates.
*/