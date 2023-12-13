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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<TreeNode> leftBoundaryNodes = new ArrayList<>(Arrays.asList(root));
        List<TreeNode> rightBoundaryNodes = new ArrayList<>(Arrays.asList(root));
        List<TreeNode> leafNodes = new ArrayList<>();
        
        // Left boundary nodes
        TreeNode current = root.left;
        while (current != null) {
            leftBoundaryNodes.add(current);
            current = (current.left != null) ? current.left : current.right;
        }

        // Right boundary nodes
        current = root.right;
        while (current != null) {
            rightBoundaryNodes.add(current);
            current = (current.right != null) ? current.right : current.left;
        }

        // Leaf nodes
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.left == null && node.right == null) {
                leafNodes.add(node);
            }
        }

        // Combine all three lists
        Set<TreeNode> seen = new HashSet<>();
        for (TreeNode node : leftBoundaryNodes) {
            result.add(node.val);
            seen.add(node);
        }

        for (TreeNode node : leafNodes) {
            if (!seen.contains(node)) {
                result.add(node.val);
                seen.add(node);
            }
        }

        for (int i = rightBoundaryNodes.size() - 1; i >= 0; i--) {
            TreeNode node = rightBoundaryNodes.get(i);
            if (!seen.contains(node)) {
                result.add(node.val);
                seen.add(node);
            }
        }

        return result;
    }
}