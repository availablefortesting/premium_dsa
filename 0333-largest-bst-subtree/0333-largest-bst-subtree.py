# Each node will return min node value, max node value, size
class Solution:
    def largestBSTSubtree(self, root: Optional[TreeNode]) -> int:
        
        def dfs(root):
            if not root:
                # [min_val, max_val, total_nodes]
                return (float('inf'), float('-inf'), 0)

            left = dfs(root.left)
            right = dfs(root.right)

            # left_max_val < root_val < right_min_val
            if left[1] < root.val < right[0]:
                return (
                        min(root.val, left[0]), 
                        max(root.val, right[1]), 
                        1 + left[2] + right[2]
                       )
            else:
                return ( float('-inf'), float('inf'), max(left[2], right[2]) )
            
        return dfs(root)[2]