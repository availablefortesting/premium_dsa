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
    private int[] dfs(TreeNode root) {
            if (root == null) {
                return new int[]{-1,-1,-1};
            }
            
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            
            int leftPath = 1 + left[1];  // then go right of left child
            int rightPath = 1 + right[0];  // then go left of right child
            int notStartingFromRoot = Math.max(left[2], right[2]);
            
            int longestZigZag = Math.max(Math.max(leftPath, rightPath), notStartingFromRoot);
            
            return new int[]{leftPath, rightPath, longestZigZag};
    }
    
    public int longestZigZag(TreeNode root) {
        return dfs(root)[2];
    }
}