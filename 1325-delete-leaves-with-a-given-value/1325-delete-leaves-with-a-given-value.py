# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def removeLeafNodes(self, root: Optional[TreeNode], target: int) -> Optional[TreeNode]:
        
        def dfs(root):
            if not root:    return None
            if not root.left and not root.right:
                return root

            left_tree = dfs(root.left)
            right_tree = dfs(root.right)

            if left_tree and left_tree.val == target and not left_tree.left and not left_tree.right:
                root.left = None
            if right_tree and right_tree.val == target and not right_tree.left and not right_tree.right:
                root.right = None

            return root
        
        dummy_root = TreeNode(-1)
        dummy_root.left = root
        dfs(dummy_root)
        return dummy_root.left
        