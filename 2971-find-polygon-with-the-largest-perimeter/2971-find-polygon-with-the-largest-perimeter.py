class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        nums.sort()
        
        cur_peri = nums[0] + nums[1]
        max_peri = float("-inf")
        
        for i in range(2, len(nums)):
            if cur_peri > nums[i]:
                max_peri = max(max_peri, cur_peri + nums[i])
                
            cur_peri += nums[i]
            
        return max_peri if max_peri != float("-inf") else -1 