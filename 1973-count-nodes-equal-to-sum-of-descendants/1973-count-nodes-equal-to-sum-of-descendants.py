# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def equalToDescendants(self, root: Optional[TreeNode]) -> int:
        cnts = 0
        
        def dfs(root):
            if not root:
                return 0

            left_Sum = dfs(root.left)
            right_Sum = dfs(root.right)
            
            if root.val == (left_Sum + right_Sum):
                nonlocal cnts
                cnts += 1
                
            return root.val + left_Sum + right_Sum
           
        dfs(root)
        return cnts