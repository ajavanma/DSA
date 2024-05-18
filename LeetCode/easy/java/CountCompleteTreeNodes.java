package leetcode.easy.java;

// Given the root of a complete binary tree, return the number of the nodes in the tree.
// According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
// Design an algorithm that runs in less than O(n) time complexity.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class CountCompleteTreeNodes {
    
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = leftDepth(root);
        int rightHeight = rightDepth(root);
        
        if (leftHeight == rightHeight) {
            // heights are the same => it's a full tree at this depth
            return (1 << leftHeight) - 1;  // return Math.pow(2, leftHeight) - 1;
        } else {
            // If not, recursively count the nodes in the left and right subtree
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    
    private int leftDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }
    
    private int rightDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.right;
            depth++;
        }
        return depth;
    }
}