class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum += n;
            
        int left_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * left_sum == sum - nums[i])
                return i;
            
            left_sum += nums[i];
        }
        
        return -1;
    }
}