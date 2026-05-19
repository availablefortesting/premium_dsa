class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007 , n = nums.length;
        Arrays.sort(nums);

        if (nums[0] * 2 > target)   return 0;
        
        int[] power = new int[n+1];
        power[0] = 1;
        for (int i = 1; i <= n; i++) power[i] = (power[i - 1] << 1) % mod;

        if (nums[n-1] * 2 <= target)   return power[n] - 1;

        int left = 0 , right = n - 1 , result = 0;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + power[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}