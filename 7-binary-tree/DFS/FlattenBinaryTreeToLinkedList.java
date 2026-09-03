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