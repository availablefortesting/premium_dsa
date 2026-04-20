class Solution {
    int[][] dp;
    int[] a;

    public int maxCoins(int[] nums) {
        int n = nums.length;

        // pad with 1s at both ends
        a = new int[n + 2];
        a[0] = 1; a[n + 1] = 1;
        for (int i = 0; i < n; i++) a[i + 1] = nums[i];

        dp = new int[n + 2][n + 2];
        for (int[] row : dp) Arrays.fill(row, -1);

        // real balloons are indices 1..n in padded array
        return solve(1, n);
    }

    int solve(int l, int r) {
        if (l > r) return 0;
        if (dp[l][r] != -1) return dp[l][r];

        int best = 0;

        // pick i as the LAST balloon to burst in [l..r]
        for (int i = l; i <= r; i++) {
            int left = solve(l, i - 1);
            int right = solve(i + 1, r);
            int coins = (a[l - 1] * a[i] * a[r + 1]) + left + right;
            best = Math.max(best, coins);
        }

        return dp[l][r] = best;
    }
}