# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> Optional[TreeNode]:
        if not preorder:
            return None
        
        node = TreeNode(preorder.pop(0))
        partition = bisect.bisect(preorder, node.val)
        
        node.left = self.bstFromPreorder(preorder[:partition])
        node.right = self.bstFromPreorder(preorder[partition:])
        
        return node