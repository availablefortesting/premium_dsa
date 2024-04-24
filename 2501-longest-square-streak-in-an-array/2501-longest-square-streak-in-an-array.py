class Solution:
    def longestSquareStreak(self, nums: List[int]) -> int:
        nums = set(nums)
        
        max_l = -1
        for num in nums:
            cur, cur_streak = num, 1
            while (cur * cur) in nums:
                cur *= cur
                cur_streak += 1
            max_l = max(max_l, cur_streak)
        return max_l if max_l >= 2 else -1