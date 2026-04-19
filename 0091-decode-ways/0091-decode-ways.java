class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        char[] a = s.toCharArray();

        int[] dp = new int[n + 1];
        dp[0] = 1;                    // empty prefix
        dp[1] = (a[0] == '0') ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            char prev = a[i - 2], cur = a[i - 1];

            if (cur != '0') dp[i] += dp[i - 1];
            if (prev == '1' || (prev == '2' && cur <= '6')) dp[i] += dp[i - 2];
        }

        return dp[n];
    }
}