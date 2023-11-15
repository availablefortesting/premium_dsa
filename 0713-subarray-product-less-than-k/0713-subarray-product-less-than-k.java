class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        /*
            0 ~ 6 months6 months ~ 1 year1 year ~ 2 years
            ServiceNow - 8 | Facebook - 4 | SoFi - 2
        */
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