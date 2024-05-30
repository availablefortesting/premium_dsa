class Solution:
    def countTriplets(self, arr: List[int]) -> int:
        '''
            Now say currently we are at index i and let xor([0...i]) = x.
            Now say x has occurred 3 times previously at indices (i1, i2, i3)

            our answer for i will be = (i - i1 - 1) + (i - i2 - 1) + (i - i3 - 1)
            if you simplify this further you get,
            times * i - (i1 + i2 + i3) - times = (i - 1) * times - (i1 + i2 + i3)
        '''
        n = len(arr)
        prefix_xor, res = 0, 0
        cnt = {0 : [1, 0]}  # {pre_xor : [seen_?_time, sum_of_that_seen_idexes]}
        
        for i, num in enumerate(arr):
            prefix_xor ^= num
            prev_times, prev_idx_sums = cnt.get(prefix_xor, [0, 0])
            
            res += prev_times * i - prev_idx_sums
            cnt[prefix_xor] = [1 + prev_times, prev_idx_sums + (i+1)]
        
        return res