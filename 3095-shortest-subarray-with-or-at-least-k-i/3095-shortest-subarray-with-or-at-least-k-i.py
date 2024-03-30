class Solution:
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        l, n = 0, len(nums)
        bit_cnts, or_val = [0] * 32, 0
        res = float("inf")
        
        def doOr(num):
            nonlocal or_val
            or_val |= num
            
            i = 0
            while num > 0:
                if num & 1:
                    bit_cnts[i] += 1
                num >>= 1
                i += 1
                
        def nullifyOr(num):
            nonlocal or_val
            i = 0
            while num > 0:
                if num & 1:
                    bit_cnts[i] -= 1
                    
                    if bit_cnts[i] == 0:
                        or_val &= ~(1 << i)     # unset only ith bit, by one's complement
                num >>= 1
                i += 1
            
        for r in range(n):
            doOr(nums[r])

            while l <= r and or_val >= k:
                res = min(res, r - l + 1)
                
                nullifyOr(nums[l])
                l += 1
                
        return res if res != float("inf") else -1