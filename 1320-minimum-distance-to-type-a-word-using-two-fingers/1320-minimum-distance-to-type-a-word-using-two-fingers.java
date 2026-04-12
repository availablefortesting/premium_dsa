class Solution {
    int n;
    String word;
    int[][][] dp;

    public int minimumDistance(String word) {
        this.word = word;
        this.n = word.length();

        dp = new int[27][27][n];
        for (int i = 0; i < 27; i++)
            for (int j = 0; j < 27; j++)
                Arrays.fill(dp[i][j], -1);

        return helper(26, 26, 0); // 26 = no finger placed
    }

    private int helper(int f1, int f2, int k) {
        if (k == n)                 return 0;
        if (dp[f1][f2][k] != -1)    return dp[f1][f2][k];

        int curr = word.charAt(k) - 'A';
        int moveF1 = distance(f1, curr) + helper(curr, f2, k + 1);
        int moveF2 = distance(f2, curr) + helper(f1, curr, k + 1);

        return dp[f1][f2][k] = Math.min(moveF1, moveF2);
    }

    private int distance(int a, int b) {
        if (a == 26) return 0;  // finger not placed yet
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }
}