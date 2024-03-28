class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int l = 0;
        
        int prev_freq;
        for (int r = 0; r < nums.length; r++) {
            prev_freq = freq.getOrDefault(nums[r], 0);
            freq.put(nums[r], prev_freq + 1);
            
            if (prev_freq == k)
                while (freq.get(nums[r]) > k)
                    freq.put(nums[l], freq.get(nums[l++]) - 1);
            
            res = Math.max(res, r - l + 1);
        }
        
        return res;
    }
}