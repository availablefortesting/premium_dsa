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
    TreeNode startNode;
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, TreeNode> parents = new HashMap<>();
        parents.put(root.val, null);
        fillParents(root, parents, start);
        
        Queue<TreeNode> q = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();
        q.offer(startNode);
        visited.add(startNode.val);
        
        int infections_time = -1;
        while (!q.isEmpty()) {
            int level_size = q.size();
            // print(q);
            for (int i = 0; i < level_size; i++) {
                TreeNode node = q.poll();
                
                TreeNode parent = parents.get(node.val);
                if (parent != null && !visited.contains(parent.val)) {
                    q.offer(parent);  visited.add(parent.val);
                }
                if (node.left != null && !visited.contains(node.left.val)) {
                    q.offer(node.left);  visited.add(node.left.val);
                }
                if (node.right != null && !visited.contains(node.right.val)) {
                    q.offer(node.right);  visited.add(node.right.val);
                }
            }
            infections_time++;
        }
        
        return infections_time;
    }
    
    private void fillParents(TreeNode root, HashMap<Integer, TreeNode> parents, int start) {
        if (root == null)   return;
        
        if (root.val == start)  startNode = root;
        
        if (root.left != null) {
            parents.put(root.left.val, root);
            fillParents(root.left, parents, start);
        }
        if (root.right != null) {
            parents.put(root.right.val, root);
            fillParents(root.right, parents, start);
        }
    }
    
    private void print(Queue<TreeNode> q) {
        for (TreeNode node : q) {
            System.out.println(node.val);
        }
    }
}