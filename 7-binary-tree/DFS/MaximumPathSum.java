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

public class MaximumPathSum {
    // Global variable to keep track of the maximum path sum found so far
    private static int maxSum;
    
    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        calculateMaxPath(root);
        return maxSum;
    }
    
    public static int calculateMaxPath(TreeNode node) {
        if (node == null) return 0;
        
        // Recursively find the max path sum of the left and right subtrees.
        // If a subtree sum is negative, we drop it by taking Math.max(0, ...).
        int leftMax = Math.max(0, calculateMaxPath(node.left));
        int rightMax = Math.max(0, calculateMaxPath(node.right));
        
        // Calculate the max path sum WITH the current node as the highest peak
        int currentPathSum = node.val + leftMax + rightMax;
        
        // Update the global maximum if this local path is better
        maxSum = Math.max(maxSum, currentPathSum);
        
        // Return the maximum branch sum extending downwards to the parent
        return node.val + Math.max(leftMax, rightMax);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2, new TreeNode(9, new TreeNode(4), new TreeNode(10)), new TreeNode(6));
        root.right = new TreeNode(8, new TreeNode(7), new TreeNode(0));
        
        System.out.println("Max path sum: " + maxPathSum(root));
        // Output: 41 , Path: 10 -> 9 -> 2 -> 5 -> 8 -> 7
    }
}


/*
The algorithm uses a post-order traversal (bottom-up), evaluating the leaves first and working its way up to the root. At every single node, it calculates two things:

1. Local Peak: What is the maximum sum if the path arches over this node? (left + node + right)

2. Returned Branch: What is the strongest single line of nodes passing through this node that can connect to its parent? (node + max(left, right))
*/
