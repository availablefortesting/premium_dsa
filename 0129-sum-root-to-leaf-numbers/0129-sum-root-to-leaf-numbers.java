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
    int total;
    public int sumNumbers(TreeNode root) {
        this.total = 0;
        dfs(root, 0);
        return total;
    }
    
    private void dfs(TreeNode root, int cur) {
        if (root == null)   return;
        
        if (root.left == null && root.right == null)
            total += (cur * 10 + root.val);
        
        dfs(root.left, cur * 10 + root.val);
        dfs(root.right, cur * 10 + root.val);
    }
}