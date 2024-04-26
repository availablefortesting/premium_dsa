class Solution:
    def specialPerm(self, nums: List[int]) -> int:
        n, mod = len(nums), 10**9 + 7
        mask = (1 << n) - 1

        @cache
        def dfs(last_idx, cur_mask):
            if cur_mask == mask:    return 1
            
            ways = 0
            for i in range(n):
                idx_used = (1 << i) & cur_mask
                if not idx_used and (nums[i] % nums[last_idx] == 0 or nums[last_idx] % nums[i] == 0):
                    ways += dfs(i, cur_mask | (1 << i))
                
            return ways
        
        res = 0
        for i in range(n):
            res = (res + dfs(i, 1 << i)) % mod

        return res
            