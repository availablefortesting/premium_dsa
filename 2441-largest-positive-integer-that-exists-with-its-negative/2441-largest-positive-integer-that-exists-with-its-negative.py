class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        nums = set(nums)
        
        max_e = -1
        for num in nums:
            if -num in nums:
                max_e = max(max_e, abs(num))
                
        return max_e