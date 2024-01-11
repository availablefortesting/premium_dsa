class Solution {
    int maxDiff;
    public int maxAncestorDiff(TreeNode root) {
        maxDiff = 0;
        dfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return maxDiff;
    }
    
    private void dfs(TreeNode root, int min, int max) {
        if (root != null) {
            min = Math.min(min, root.val);
            max = Math.max(max, root.val);
            maxDiff = Math.max(maxDiff, max - min);
            
            dfs(root.left, min, max);
            dfs(root.right, min, max);
        }
    }
}