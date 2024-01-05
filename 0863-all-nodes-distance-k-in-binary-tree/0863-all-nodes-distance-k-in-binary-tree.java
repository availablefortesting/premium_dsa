/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> childToParent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        childToParent.put(root, null);
        while (!q.isEmpty()) {
            int level_size = q.size();
            
            for (int i = 0; i < level_size; i++) {
                TreeNode node = q.poll();
                
                if (node.left != null) {
                    childToParent.put(node.left, node);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    childToParent.put(node.right, node);
                    q.offer(node.right);
                }
            }
        }
        
        HashSet<TreeNode> visited = new HashSet<>();
        q.offer(target);
        
        int cur_level = 0;
        while (cur_level != k) {
            
            int level_size = q.size();
            for (int i = 0; i < level_size; i++) {
                TreeNode node = q.poll();
                visited.add(node);
                
                TreeNode parent = childToParent.get(node);
                if (parent != null && !visited.contains(parent))
                    q.offer(parent);
                if (node.left != null && !visited.contains(node.left))
                    q.offer(node.left);
                if (node.right != null && !visited.contains(node.right))
                    q.offer(node.right);
            }
            cur_level++;
        }
        
        List<Integer> res = new ArrayList<>();
        for (TreeNode node : q)
            res.add(node.val);
        
        return res;
    }
}