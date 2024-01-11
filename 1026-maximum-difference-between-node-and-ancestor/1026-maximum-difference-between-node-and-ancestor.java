class Solution {
    int maxDiff;
    public int maxAncestorDiff(TreeNode root) {
        maxDiff = 0;
        dfs(root);
        return maxDiff;
    }
    
    private int[] dfs(TreeNode root) {
        if (root.left == null && root.right == null)   return new int[]{root.val, root.val};
        
        int[] left = root.left != null ? dfs(root.left) : new int[]{root.val, root.val};
        int[] right = root.right != null ? dfs(root.right) : new int[]{root.val, root.val};
        int min_left = left[0], max_left = left[1];
        int min_right = right[0], max_right = right[1];
        
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(root.val - min_left), Math.abs(root.val - min_right)));
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(root.val - max_left), Math.abs(root.val - max_right)));
        
        // System.out.println(root.val + " : " + min_left + " , " + min_right + " <> " + maxDiff);
        int cur_min = Math.min(root.val, Math.min(min_left, min_right));
        int cur_max = Math.max(root.val, Math.max(max_left, max_right));
        return new int[]{cur_min, cur_max};
    }
}