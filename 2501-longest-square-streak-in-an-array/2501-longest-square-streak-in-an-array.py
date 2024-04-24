class Solution:
    def longestSquareStreak(self, nums: List[int]) -> int:
        nums.sort()
        idx_map = {num : i for i, num in enumerate(nums)}
        
        max_l, n = -1, len(nums)
        dp = [1] * n
        for i in range(n-1, -1, -1):
            sq = nums[i] * nums[i]
            if sq in idx_map:
                dp[i] += dp[idx_map[sq]]
            max_l = max(max_l, dp[i])
        # print(nums, dp)
        
        return max_l if max_l >= 2 else -1
        