class Solution:
    def findBuildings(self, heights: List[int]) -> List[int]:
        res = []
        max_h, n = float("-inf"), len(heights)
        
        for i,height in enumerate(heights[::-1]):
            if height > max_h:
                res.append(n - i - 1)
                
            max_h = max(max_h, height)
            
        return res[::-1]