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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)   return head;
        ListNode cur = head, slow = head, fast = head;
        int n = 0;

        while (cur != null)  {
            cur = cur.next; n++;
        }
        k %= n;
        if (k == 0) return head;

        while (fast != null && k-- != 0)    fast = fast.next;

        while (fast.next != null) {
            slow = slow.next; fast = fast.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        
        return newHead;
    }
}