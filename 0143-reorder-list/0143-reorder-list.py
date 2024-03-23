# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        def reverse(head):
            prev = None;
            while head != None:
                head.next, prev, head = prev, head, head.next
            return prev
        
        slow, fast = head, head
        while fast != None and fast.next != None:
            slow, fast = slow.next, fast.next.next
        
        if fast != None:   slow = slow.next
            
        fast = reverse(slow)
        slow = head
        
        while slow != None and fast != None:
            slow.next, fast.next, fast, slow = fast, slow.next, fast.next, slow.next
        
        if slow.next != None:   slow.next = None;