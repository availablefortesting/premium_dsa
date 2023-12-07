class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        
        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            
            TreeNode node = st.pop();
            if (--k == 0) {
                return node.val;
            }
            
            root = node.right;
        }
        
        return -1;
    }
}