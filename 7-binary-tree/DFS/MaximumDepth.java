// A Binary Tree is a data structure made up of nodes. It is called "binary" because each node can have at most two children.

// Here is the anatomy you need to know:

    // Root: The very top node of the tree.

    // Children: The nodes directly connected below a parent (the left and right child).

    // Leaf: A node at the very bottom that has no children (both left and right are null).


// This is the standard class definition for a Binary Tree Node
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

public class MaximumDepth {
    public static int maxDepth(TreeNode root) {
        // TODO: Step 1 - The Base Case
        // If the current node (root) is null, it has no depth. Return 0.
        if (root == null) {
            return 0;
        }

        // TODO: Step 2 - The Recursive Step
        // 1. Recursively call the maxDepth on left child and store it in an int 'leftDepth'.
        // 2. Recursively call the maxDepth on the right child and store it in an int 'rightDepth'.
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // TODO: Step 3 - Return the result
        // Use Math.max(leftDepth, rightDepth) to find the bigger path, add 1 to count the current node, and return it!
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // Building the tree: [3, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        System.out.println("Max Depth: " + maxDepth(root)); // Expected: 3
    }
}

// This is the exact blueprint for almost every tree problem.