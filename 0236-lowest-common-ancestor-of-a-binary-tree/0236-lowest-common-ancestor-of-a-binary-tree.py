# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # with cnt its Lowest Common Ancestor of a Binary Tree II
        cnt = 0
        def helper(root):
            nonlocal cnt
            if not root:    return root

            left, right = helper(root.left), helper(root.right)
            if root in [p, q]:  
                cnt += 1
                return root

            if left and right:  return root
            return left if left else right

        res = helper(root)
        return res if cnt == 2 else None