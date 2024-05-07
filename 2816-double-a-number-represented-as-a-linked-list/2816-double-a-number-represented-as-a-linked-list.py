# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        def dfs(head):
            nonlocal carry
            if not head:
                return 0

            total = (head.val * 2) + dfs(head.next)
            head.val = total % 10
            return total // 10
        
        carry = dfs(head)
        if carry: 
            top = ListNode(carry)
            top.next = head
            head = top
        return head
        