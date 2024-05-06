# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        def dfs(root, prev):
            nonlocal max_val
            if not root:
                return None
            
            dfs(root.next, root)
            if root.val < max_val:
                prev.next = root.next
                root.next = None
            max_val = max(max_val, root.val)
            
        max_val = float("-inf")
        dummy = ListNode(-1, head)
        dfs(head, dummy)
        return dummy.next