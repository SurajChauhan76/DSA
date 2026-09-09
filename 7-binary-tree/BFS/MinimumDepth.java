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

public class MinimumDepth {
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // Early exit: First leaf node encountered is the minimum depth
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }

                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }

            depth++;  // Increment depth after completing a full level
        }

        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Minimum Depth: " + minDepth(root));
    }
}


/*
The Problem: Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

The Strategy: While this can be solved with DFS, BFS is significantly more efficient. By traversing level by level, the very first time you encounter a leaf node (a node with no left or right children), you are guaranteed to have found the shortest path. You can immediately return the current depth and skip processing the rest of the tree.

Time Complexity: O(N) in the worst case (a perfectly balanced tree), but O(1) in the best case (a highly unbalanced tree where a leaf is found immediately).

Space Complexity: O(N) for the queue width at the deepest level.

How it works: The queue starts with [3] at depth 1. It pops 3, checks if it's a leaf (no), and enqueues [9, 20]. Depth becomes 2. On the next pass, it pops 9. Because 9 has no children, the condition current.left == null && current.right == null is met, and it instantly returns 2 without ever exploring 15 or 7.
*/