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
    private List<List<Integer>> res;
    
    private int getHeight(TreeNode root) {
        
        if (root == null) {
            return -1;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        int currHeight = 1 + Math.max(leftHeight, rightHeight);
        
        if (this.res.size() == currHeight) {
            this.res.add(new ArrayList<>());
        }
        
        this.res.get(currHeight).add(root.val);
        
        return currHeight;
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        this.res = new ArrayList<>();
        
        getHeight(root);
        
        return this.res;
    }
}