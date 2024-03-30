class Solution {
    int or_val;
    int[] bit_cnts;

    private void nullifyOr(int num) {
        int i = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                bit_cnts[i] -= 1;

                if (bit_cnts[i] == 0)
                    or_val &= ~(1 << i); // unset only ith bit, by one's complement
            }
            num >>= 1;  i++;
        }
    }
    
    private void doOr(int num) {
        this.or_val |= num;
        
        int i = 0;
        while (num > 0) {
            if ((num & 1) == 1)
                bit_cnts[i] += 1;
            num >>= 1;  i++;
        }
    }
    
    public int minimumSubarrayLength(int[] nums, int k) {
        this.or_val = 0;
        this.bit_cnts =  new int[32];
        
        int l = 0, n = nums.length;
        int res = Integer.MAX_VALUE;
        
        for (int r = 0; r < n; r++) {
            doOr(nums[r]);

            while (l <= r && or_val >= k) {
                res = Math.min(res, r - l + 1);
                nullifyOr(nums[l]);
                l += 1;
            }
        }

        return res != Integer.MAX_VALUE ? res : -1;
    }
}