# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        
        def dfs(root):
            if not root:
                return [-1,-1,-1]
            
            left = dfs(root.left)
            right = dfs(root.right)
            
            leftPath = 1 + left[1]  # then go right of left child
            rightPath = 1 + right[0]  # then go left of right child
            notStartingFromRoot = max(left[2], right[2])
            
            longestZigZag = max(leftPath, rightPath, notStartingFromRoot)
            
            return [leftPath, rightPath, longestZigZag]
        
        return dfs(root)[-1]