# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode], direc = "R") -> int:
        if not root:    return 0
        if not root.left and not root.right and direc == "L":    
            return root.val
        
        return self.sumOfLeftLeaves(root.left, "L") + self.sumOfLeftLeaves(root.right, "R")