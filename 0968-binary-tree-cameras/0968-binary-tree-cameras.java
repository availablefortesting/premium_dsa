class Solution {
    private static final int NOT_COVERED = 0;
    private static final int HAS_CAMERA = 1;
    private static final int COVERED = 2;
    private int cameras = 0;

    private int dfs(TreeNode root) {
        if (root == null)   return COVERED;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == NOT_COVERED || right == NOT_COVERED) {
            cameras++;
            return HAS_CAMERA;
        }
        if (left == HAS_CAMERA || right == HAS_CAMERA)  return COVERED;
        return NOT_COVERED;
    }
    
    public int minCameraCover(TreeNode root) {
        if (dfs(root) == NOT_COVERED)
            cameras++;
        return cameras;
    }
}