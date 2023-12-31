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
    public int closestValue(TreeNode root, double target) {

        int closest_node = Integer.MAX_VALUE;
        double closest_diff = Double.MAX_VALUE;
        
        while (root != null) {
            double cur_diff = Math.abs(root.val - target);
            
            if ( (cur_diff < closest_diff) || (cur_diff == closest_diff && root.val < closest_node) ) {
                closest_node = root.val;
                closest_diff = cur_diff;
            }

            if (target < root.val)
                root = root.left;
            else
                root = root.right;
            
        }
        
        return closest_node;
    }
}