class Solution {
    /* Similar Template problems */
    // Premium : https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
    // https://leetcode.com/problems/binary-subarrays-with-sum/
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        // right - left = k -> left = right - k
        int ans = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            int left = right - k;
            if (map.containsKey(left))
                ans = Math.max(ans, i - map.get(left));
            
            map.putIfAbsent(right, i); // make current right as left for later retrieve
        }
        return ans;
    }
    
    /*
        0 [1 [1 [1 0] 0] 0]
        -1 1  2  3 2  1  0
    */
    public int findMaxLength(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        // treat 0 as -1, so when sum is 0 there is same nums of 1's and 0's
        // right - left = 0 -> left = right
        
        int ans = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(right))
                ans = Math.max(ans, i - map.get(right));
            
            map.putIfAbsent(right, i); // make current right as left for later retrieve
        }
        return ans;
    }
}