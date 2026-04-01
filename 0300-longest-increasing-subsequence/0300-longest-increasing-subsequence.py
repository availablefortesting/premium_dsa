class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # DP - https://www.youtube.com/watch?v=mouCn3CFpgg
        n = len(nums)
        dp = [1]*(n)
        
        
        for i in range(n):
            for j in range(i):
                if nums[i] > nums[j] and dp[i] <= dp[j]:
                    dp[i] = 1 + dp[j]
        
        return max(dp)
    
    
        mono = []
        for num in nums:
            i = bisect.bisect_left(mono, num)  # or bisect.bisect_right
            if i == len(mono):
                mono.append(num)
            else:
                mono[i] = num
        print(mono)
        return len(mono)