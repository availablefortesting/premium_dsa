class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, max = 0, total = 0;
        int[] dp = new int[n], cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
        }

        for(int i=0; i<n; i++)
            if(dp[i] > max)   
                max = dp[i];

        for(int i=0; i<n; i++)
            if(dp[i] == max)
                total += cnt[i];

        return total;
    }
}