class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int imin = -1, imax = -1, ibad = -1;
        long res = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || maxK < nums[i]) 
                ibad = i;
            
            if (nums[i] == minK)    imin = i;
            if (nums[i] == maxK)    imax = i;
            
            res += Math.max(0L, Math.min(imin, imax) - ibad);
        }
        
        return res;
    }
}