/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node head, tail;
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return root;
        
        head = null;
        tail = null;
        
        inOrderLinking(root);
        
        head.left = tail;
        tail.right = head;
        
        return head;
    }
    
    private void inOrderLinking(Node root) {
        // go till left most node
        if (root != null) {
            inOrderLinking(root.left);
            
            // now we're sure there no left most node
            if (tail == null) {
                head = root;
            // if there is tail then append new ele to end
            } else {
                root.left = tail;
                tail.right = root;
            }
                
            tail = root;
            
            inOrderLinking(root.right);
        }
    }
}