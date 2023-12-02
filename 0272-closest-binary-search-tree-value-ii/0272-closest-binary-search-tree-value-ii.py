# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def closestKValues(self, root: Optional[TreeNode], target: float, k: int) -> List[int]:
        heap = []
        
        def inorder(root):
            if root:
                inorder(root.left)
                
                heapq.heappush(heap, (-abs(target - root.val), root.val))
                if len(heap) > k:
                    heapq.heappop(heap)
                    
                inorder(root.right)
                
        inorder(root)
        return [pair[1] for pair in heap]