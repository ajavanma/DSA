package leetcode.java;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;


// Given the root of a binary tree, return the inorder traversal of its nodes' values.
// example:
// Input: root = [1,null,2,3]
// Output: [1,3,2]

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        
        return result;
    }
}
