/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        
        Node prev = head;
        Node curr = head.next;
        boolean toInsert = false;
        do {
          if (prev.val <= insertVal && insertVal <= curr.val) {
            // Case 1) The value of new node sits between the minimal and maximal values of the current list. 
            //         As a result, it should be inserted within the list.
            toInsert = true;
          } else if (prev.val > curr.val) {
            /* Case 2). The value of new node goes beyond the minimal and maximal values of the current list, 
                        either less than the minimal value or greater than the maximal value. 
                        In either case, the new node should be added right after the tail node 
                            (i.e. the node with the maximal value of the list).
            */
            if (insertVal >= prev.val || insertVal <= curr.val)
              toInsert = true;
          }

          if (toInsert) {
            prev.next = new Node(insertVal, curr);
            return head;
          }

          prev = curr;
          curr = curr.next;
        } while (prev != head);
        
        
        // Case 3). Finally, there is one case that does not fall into any of the above two cases. 
        //            This is the case where the list contains uniform values.
        prev.next = new Node(insertVal, curr);
        return head;
    }
}
