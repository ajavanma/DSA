package java.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;


// Given a binary tree, find its minimum depth.
// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
// Note: A leaf is a node with no children.


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

class MinimumDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();  // Number of nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                
                // Check if the current node is a leaf
                if (current.left == null && current.right == null) {
                    return depth;
                }

                // Add children to the queue
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            depth++;  // Increment depth as we move to the next level
        }

        return depth;
    }
}
