class Solution {
    private static final int INF = 1_000_000_000;

    int n, K;
    int[] pref;
    int[][][] dp; // dp[l][r][m], -1 means uncomputed

    public int mergeStones(int[] stones, int K) {
        this.n = stones.length;
        this.K = K;

        if ((n - 1) % (K - 1) != 0) return -1;

        pref = new int[n + 1];
        for (int i = 0; i < n; i++) pref[i + 1] = pref[i] + stones[i];

        dp = new int[n][n][K + 1];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) Arrays.fill(dp[i][j], -1);

        return solve(0, n - 1, 1);
    }

    private int solve(int l, int r, int m) {
        if (l == r) return (m == 1) ? 0 : INF;

        if (dp[l][r][m] != -1) return dp[l][r][m];

        int res = INF;

        if (m == 1) {
            int costK = solve(l, r, K);
            if (costK < INF) res = costK + sum(l, r);
        } else {
            // split: left -> 1 pile, right -> (m-1) piles
            for (int mid = l; mid < r; mid += (K - 1)) {
                int left = solve(l, mid, 1);
                int right = solve(mid + 1, r, m - 1);
                if (left < INF && right < INF) {
                    res = Math.min(res, left + right);
                }
            }
        }

        return dp[l][r][m] = res;
    }

    private int sum(int l, int r) {
        return pref[r + 1] - pref[l];
    }
}