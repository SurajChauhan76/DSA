class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int val) {
        this.val = val;
    }
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        
        if (leftLCA != null && rightLCA != null) return root;
        
        return leftLCA != null ? leftLCA : rightLCA;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        root.right = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        
        TreeNode p = root.left;  // This is the node with value 5
        TreeNode q = root.right; // This is the node with value 1
        
        TreeNode lca = lowestCommonAncestor(root, p, q);
        
        if (lca != null) {
            System.out.println(lca.val);
        } else {
            System.out.println("null");
        }
    }
}

/*
Find the lowest node in a tree that has both nodes p and q as descendants. Traverse the tree; if the current node is p or q, return it. Search the left and right subtrees. If both return a non-null result, the current node is the LCA. If only one returns a result, pass that result up.  

Time Complexity: O(N), as we might need to visit every node in the worst-case scenario if the target nodes are deep in the tree.

Space Complexity: O(H) for the recursion stack.
*/