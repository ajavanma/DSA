from typing import Optional

# Given the root of a complete binary tree, return the number of the nodes in the tree.
# According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
# Design an algorithm that runs in less than O(n) time complexity.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        leftHeight = self.leftDepth(root)
        rightHeight = self.rightDepth(root)
        
        if leftHeight == rightHeight:
            # Use bit shifting to calculate 2^leftHeight - 1
            return (1 << leftHeight) - 1  # return (2 ** leftHeight) - 1
        else:
            # Recursively count the nodes in the left and right subtrees
            return 1 + self.countNodes(root.left) + self.countNodes(root.right)

    def leftDepth(self, node: Optional[TreeNode]) -> int:
        depth = 0
        while node:
            node = node.left
            depth += 1
        return depth

    def rightDepth(self, node: Optional[TreeNode]) -> int:
        depth = 0
        while node:
            node = node.right
            depth += 1
        return depth

