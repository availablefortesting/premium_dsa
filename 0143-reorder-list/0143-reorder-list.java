/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
    
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast != null)   slow = slow.next;
        fast = reverse(slow);
        
        slow = head;
        while (slow != null && fast != null) {
            ListNode next = slow.next;
            // add fast's node
            slow.next = fast;
            fast = fast.next;
            
            // link fast's node to slow's next
            slow = slow.next;
            slow.next = next;
            
            slow = next;
        }
        
        // to avoid self loop in odd-length case
        if (slow.next != null)   slow.next = null;
    }
}