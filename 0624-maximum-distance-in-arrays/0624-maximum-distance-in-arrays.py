class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:
        min_e = arrays[0][0]
        max_e = arrays[0][-1]
        res = 0
        
        for arr in arrays[1:]:
            res = max(res, abs(arr[-1] - min_e), abs(max_e - arr[0]))
            
            min_e = min(min_e, arr[0])
            max_e = max(max_e, arr[-1])
            
        return res