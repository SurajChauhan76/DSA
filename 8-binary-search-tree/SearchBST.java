// The Golden Rule of the BST
// For every single node in the tree:
// 1. All nodes in its left subtree must be strictly less than the node's value.
// 2. All nodes in its right subtree must be strictly greater than the node's value.

// Time Complexity: O(log n)

// In a BST, every time you compare your target number to a node, you immediately eliminate an entire branch of the tree.
// - If your target is smaller than the current node, you move left (and ignore the right).
// - If your target is larger, you move right (and ignore the left).

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

public class SearchBST {
    public static TreeNode searchBST(TreeNode root, int val) {
        // Step 1 - Base Cases
        // If the root is null, we didn't find it. Return null.
        if (root == null) return null;

        // If the root's value is exactly what we are looking for, we found it! Return root.
        if (root.val == val) return root;

        // Step 2 - The Decision
        // If 'val' is LESS than the current root's value...
        // We only need to search the left side. Return the result of a recursive call to the left child.
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        // Step 3 - The Alternative
        // If 'val' is GREATER than the current root's value...
        // We only need to search the right side. Return the result of a recursive call to the right child.
        if (val > root.val) {
            return searchBST(root.right, val);
        }

        return null; // Fallback
    }

    public static void main(String[] args) {
        // Building the BST: [4, 2, 7, 1, 3]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(7);

        TreeNode result = searchBST(root, 2);

        if (result != null) {
            System.out.println("Found node with value: " + result.val);
            // Expected: 2
        } else {
            System.out.println("Node not found.");
        }
    }
}


// The Interviewer's Trap
// If an interviewer ever asks you: "Is searching a Binary Search Tree always O(log n) time?"
// The answer is No!
// Imagine if you inserted the numbers 1, 2, 3, 4, 5 into a BST in that exact order. 
// The 2 goes to the right of 1. The 3 goes to the right of 2. 
// You end up with a tree that just looks like a straight line sloping downward to the right. 
// That is essentially a Linked List, which means searching it takes O(n) time.
// That is why production databases use self-balancing BSTs (like AVL Trees or Red-Black Trees), 
// which automatically rotate themselves to ensure the tree stays wide and short, guaranteeing that O(log n) speed.