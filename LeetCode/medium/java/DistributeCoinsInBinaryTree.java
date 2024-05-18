package leetcode.medium.java;

// You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n coins in total throughout the whole tree.
// In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent to child, or from child to parent.
// Return the minimum number of moves required to make every node have exactly one coin.

// Input: root = [3,0,0]
// Output: 2
// Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.

// Input: root = [0,3,0]
// Output: 3
// Explanation: From the left child of the root, we move two coins to the root [taking two moves]. Then, we move one coin from the root of the tree to the right child.

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


class DistributeCoinsInBinaryTree {
    private int moves;

    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        // moves needed to balance the subtree rooted at the current node
        // Positive means that subtree has extra coins that need to be moved out
        // Negative means that subtree lacks coins and needs to receive some
        // Math.abs(node) : absolute number of moves needed to either send out the extra coins or bring in the required coins for the left subtree
        moves += Math.abs(left) + Math.abs(right);
        
        return node.val + left + right - 1;   // each need to keep one for itself, if it retunrs zero base case it met, balanced
    }
}