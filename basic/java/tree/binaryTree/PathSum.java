package java.tree.binaryTree;

// Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that
//  adding up all the values along the path equals targetSum.
// A leaf is a node with no children.

/**
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        
        // Check if it is a leaf node
        if (root.left == null && root.right == null) {
            // Check if the current node's value is equal to targetSum
            return root.val == targetSum;
        }
        
        // Recursively check the left and right subtree
        boolean leftHasPath = false;
        if (root.left != null) {
            leftHasPath = hasPathSum(root.left, targetSum - root.val);
        }
        
        boolean rightHasPath = false;
        if (root.right != null) {
            rightHasPath = hasPathSum(root.right, targetSum - root.val);
        }
        
        // Return true if any of the subtree has the path sum equal to targetSum
        return leftHasPath || rightHasPath;
    }
}
