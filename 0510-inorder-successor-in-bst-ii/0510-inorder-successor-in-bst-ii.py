"""
# Definition for a Node.
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None
"""

class Solution:
    def inorderSuccessor(self, node: 'Node') -> 'Optional[Node]':
        if node.right:
            node = node.right
            while node.left:
                node = node.left
        else:
            while node.parent and node.parent.right == node:
                node = node.parent
            # now we have parent from left direction
            node = node.parent
        
        return node