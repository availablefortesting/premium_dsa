# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findLeaves(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = defaultdict(list)
        
        def dfs(root):
            if not root:
                return 0
                
            left = dfs(root.left)
            right = dfs(root.right)
            
            cur_l = 1 + max(left, right)
            res[cur_l].append(root.val)
            
            return cur_l
        
        dfs(root)
        return res.values()
                    