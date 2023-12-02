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
    private List<Integer> dfs(TreeNode root) {
            if (root == null) {
                // [min_val, max_val, total_nodes]
                return Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            }

            List<Integer> left = dfs(root.left);
            List<Integer> right = dfs(root.right);

            // left_max_val < root_val < right_min_val
            if (left.get(1) < root.val && root.val < right.get(0)) {
                return Arrays.asList(
                        Math.min(root.val, left.get(0)), 
                        Math.max(root.val, right.get(1)), 
                        1 + left.get(2) + right.get(2)
                       );
            } else
                return Arrays.asList( Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.get(2), right.get(2)) );
        }
            
    public int largestBSTSubtree(TreeNode root) {
        return dfs(root).get(2);
    }
}