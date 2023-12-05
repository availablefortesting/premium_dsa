# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderSuccessor(self, root: TreeNode, p: TreeNode) -> Optional[TreeNode]:
        
        successor = None
        
        while root:
            # if its in strictly left side then, cur root could be successor 
            if root.val > p.val:
                successor = root
                root = root.left
            else:
                root = root.right
                
        return successor