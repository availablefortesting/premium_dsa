class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1)
            return 0;
        
        HashMap<Long, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++)   dp[i] = new HashMap<>();
        int cnts = 0;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long)nums[i] - (long)nums[j];
                int cnt = dp[j].getOrDefault(diff, 0);
                cnts += cnt;
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + cnt + 1);
            }
        }   
        
        return cnts;
    }
}