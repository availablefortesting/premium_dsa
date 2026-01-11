class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        def helper(idx, eval):
            if idx == len(nums):
                if eval == target:
                    return 1
                return 0

            return helper(idx+1, eval + nums[idx]) + helper(idx+1, eval - nums[idx])
        # return helper(0, 0)

        def dp():
            dp = {0: 1}  # sum -> number of ways
            for num in nums:
                next_dp = defaultdict(int)
                for s, count in dp.items():
                    next_dp[s + num] += count
                    next_dp[s - num] += count
                dp = next_dp
            
            return dp[target]
        return dp()
