class Solution {
    static int curSum;
    
    private int getSum(TreeNode root) {
        if (root == null)   return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }
    
    private void changeBst(TreeNode root, int totalSum) {
        if (root == null)   return;
        
        changeBst(root.left, totalSum);
        curSum += root.val;
        root.val += totalSum - curSum;
        changeBst(root.right, totalSum);
    }
    
    public TreeNode bstToGst(TreeNode root) {
        int totalSum = getSum(root);
        System.out.println(totalSum);
        
        curSum = 0;
        changeBst(root, totalSum);
        return root;
    }
}