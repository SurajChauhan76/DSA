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

public class PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {

        // Base case: empty root cannot form path
        if (root == null) return false;

        // If leaf node, check if the remaining target sum matches its value
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recursive step: Recurse down to the left and right children with updated target sum
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,  targetSum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(5, new TreeNode(10), new TreeNode(3));
        root.right = new TreeNode(7);

        System.out.println("Has path sum: " + hasPathSum(root, 20));
        System.out.println("Has path sum: " + hasPathSum(root, 22));
    }
}
