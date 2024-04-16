# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def addOneRow(self, root: Optional[TreeNode], val: int, depth: int) -> Optional[TreeNode]:
        if depth == 1:
            new_root = TreeNode(val)
            new_root.left = root
            return new_root
        
        q = deque()
        q.append(root)
        depth -= 1
        
        while depth != 1:
            for _ in range(len(q)):
                node = q.popleft()
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            depth -= 1
        
        for node in q:
            new_node = TreeNode(val)
            new_node.left = node.left
            node.left = new_node

            new_node = TreeNode(val)
            new_node.right = node.right
            node.right = new_node
                
        return root