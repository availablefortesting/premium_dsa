class Solution:
    def twoSumLessThanK(self, nums: List[int], k: int) -> int:
        nums.sort()
        res = -1
        
        for i in range(len(nums)):
            req = k - nums[i]
            
            j = bisect.bisect_left(nums, req, i+1) - 1
            
            if j > i:
                res = max(res, nums[i] + nums[j])
                
        return res
                