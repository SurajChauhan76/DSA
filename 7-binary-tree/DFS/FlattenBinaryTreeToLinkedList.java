class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int val) {
        this.val = val;
    }
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val =  val;
        this.left = left;
        this.right = right;
    }
}

public class FlattenBinaryTreeToLinkedList {
    // Global variable to keep track of the previously processed node
    private static TreeNode prev = null;
    
    public static void flatten(TreeNode root) {
        if (root == null) return;
        
        // Traverse Right, then Left (Reverse Post-Order)
        flatten(root.right);
        flatten(root.left);
        
        // Rewire the current node's pointers
        root.right = prev;
        root.left = null;
        
        // Update the previous node to be the current node for the next recursive step up
        prev = root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(5, null, new TreeNode(6));
        
        // Apply the DFS flatten method 
        flatten(root);
        
        // Traverse and print the modified tree using only the right pointers
        System.out.println("Flattend Tree: ");
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + (current.right != null ? " -> " : ""));
            current = current.right;
        }
        
        // Expected output: 1 -> 2 -> 3 -> 4 -> 5 -> 6
    }
}


/*
This problem shifts from calculating values to structurally modifying the tree in-place. The goal is to rearrange the tree into a "linked list" where all nodes are connected via their right pointers in the same order as a pre-order traversal (Root -> Left -> Right), and all left pointers are set to null.

The Strategy:
While the final shape mirrors a pre-order traversal, iterating pre-order makes it difficult to rewire pointers without losing references to the original right children.

The clever solution is to use a Reverse Post-Order Traversal (Right -> Left -> Root). By visiting the rightmost nodes first, you can keep track of the previously processed node and simply point the current node's right pointer to it, safely building the "linked list" from tail to head.

Time Complexity: O(N), where N is the number of nodes, as we visit every node exactly once.

Space Complexity: O(H) for the recursive call stack, where H is the height of the tree.
*/