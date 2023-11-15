class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0;
        int cur_prod = 1;
        int res = 0;
        
        for (int r = 0; r < nums.length; r++) {
            cur_prod *= nums[r];
            
            while (l <= r && cur_prod >= k) {
                cur_prod /= nums[l++];
            }
            res += (r-l+1);
        }
        
        return res;
    }
}