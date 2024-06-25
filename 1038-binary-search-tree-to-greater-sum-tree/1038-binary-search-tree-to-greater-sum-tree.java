class Solution {  
    int curSum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null)
            bstToGst(root.right);
        
        root.val += curSum;
        curSum = root.val;
        
        if (root.left != null)
            bstToGst(root.left);
        return root;
    }
}