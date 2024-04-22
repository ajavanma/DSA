# Given an integer array nums where the elements are sorted in ascending order, convert it to a 
# height-balanced (A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.)
#  binary search tree.

import Optional
from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
 
        
class convertArrayToBinarySearchTree:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        def convert(left, right):
            if left > right:
                return None
            mid = (left + right) // 2     # // is floor division, / results in float
            node = TreeNode(nums[mid])
            node.left = convert(left, mid - 1)
            node.right = convert(mid + 1, right)
            return node

        return convert(0, len(nums) - 1)
    
    

