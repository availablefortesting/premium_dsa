class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        res = nums[0]
        prev_sums = [nums[0]]
        
        for i in range(1, len(nums)):
            for j in range(len(prev_sums)):
                prev_sums.append(prev_sums[j] ^ nums[i])
                res += prev_sums[-1]
            
            res += nums[i]
            prev_sums.append(nums[i])
        return res
                
        