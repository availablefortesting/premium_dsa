# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maximumAverageSubtree(self, root: Optional[TreeNode]) -> float:
        st = [(root,False)]
        cache = {None : (0,0)}
        max_avg = 0
        
        while st:
            node, visited = st.pop()
            
            if not visited:
                st.append((node, True))
                
                if node.right:
                    st.append((node.right, False))
                    cache[node.right] = (node.right.val, 1)
                    
                if node.left:
                    st.append((node.left, False))
                    cache[node.left] = (node.left.val, 1)
                    
            else:
                left = cache[node.left]
                right = cache[node.right]
                
                sums = (node.val + left[0] + right[0]) 
                cnts = (1 + left[1] + right[1])
                
                max_avg = max(max_avg, sums/cnts)
                cache[node] = (sums, cnts)
                
        return max_avg