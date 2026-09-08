import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class RightSideViewOfBinaryTree {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            // Iterate through all nodes on the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                
                // If this is the last node in the current level, add it to the result
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }
                
                // Add child nodes to the queue for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Constructing the tree:
        //      1
        //    /   \
        //   2     3
        //    \     \
        //     5     4
        //    /
        //   6
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.left.right.left = new TreeNode(6);
        
        List<Integer> rightView = rightSideView(root);
        System.out.println("Right Side View: " + rightView);
        // Expected Output: [1, 3, 4, 6]
    }
}

/*
The Strategy:
To solve this, we perform a standard level-order traversal using a Queue. The key trick is that at the beginning of each level, we measure the size of the queue. We then iterate exactly size times. Since we process the nodes from left to right, the last node we process in that inner loop is the rightmost node of that level.

Time Complexity: O(N), where N is the number of nodes. We enqueue and dequeue every node exactly once.

Space Complexity: O(D), where D is the maximum diameter of the tree. In the worst case (the bottom level of a perfectly balanced tree), the queue will hold roughly N/2 nodes, which simplifies to O(N).
*/