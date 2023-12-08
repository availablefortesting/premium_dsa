class Solution {
    private String inorder(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        String left = inorder(root.left);
        String right = inorder(root.right);
        
        left = left == "" && right == "" ? "" : "("+ left +")";
        right = right == "" ? "" : "("+ right +")";
        
        return root.val + left + right;
    }
    
    public String tree2str(TreeNode root) {
        return inorder(root);
    }
}