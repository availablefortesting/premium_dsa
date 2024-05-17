/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;
            
        TreeNode l = removeLeafNodes(root.left, target);
        TreeNode r = removeLeafNodes(root.right, target);
        
        root.left = l;
        root.right = r;
        
        if (l == null && r == null && root.val == target)
            return null;
        else
            return root;
    }
}