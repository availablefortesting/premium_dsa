# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.head = None
        self.tail = None
        
        self.flattern_bst(root)
        
        self.cur = TreeNode(-1, None, self.head)
        
    def print_DLL(self):
        temp = self.head
        while temp:
            print(self.head.val)
            temp = temp.right
            
    def flattern_bst(self, root):
        if root:
            self.flattern_bst(root.left)
            
            if not self.tail:
                self.head = root
            else:
                root.left = self.tail
                self.tail.right = root
                
            self.tail = root
            
            self.flattern_bst(root.right)

    def hasNext(self) -> bool:
        return self.cur.right != None

    def next(self) -> int:
        self.cur = self.cur.right
        return self.cur.val
    
    def hasPrev(self) -> bool:
        return self.cur.left != None

    def prev(self) -> int:
        self.cur = self.cur.left
        return self.cur.val


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.hasNext()
# param_2 = obj.next()
# param_3 = obj.hasPrev()
# param_4 = obj.prev()