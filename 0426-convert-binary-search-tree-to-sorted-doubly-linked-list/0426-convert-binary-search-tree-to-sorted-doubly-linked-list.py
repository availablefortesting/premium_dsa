"""
# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""

class Solution:
    def treeToDoublyList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root
        
        self.head = None
        self.tail = None
        
        self.inOrderLinking(root)
        
        self.head.left = self.tail
        self.tail.right = self.head
        
        return self.head
    
    def inOrderLinking(self, root):
        # go till left most node
        if root:
            self.inOrderLinking(root.left)
            
            # now we're sure there no left most node
            if not self.tail:
                self.head = root
            # if there is tail then append new ele to end
            else:
                root.left = self.tail
                self.tail.right = root
                
            self.tail = root
            
            self.inOrderLinking(root.right)