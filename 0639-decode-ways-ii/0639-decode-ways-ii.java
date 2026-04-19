class Solution {
    static final int MOD = 1_000_000_007;

    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        char[] a = s.toCharArray();
        long[] dp = new long[n + 1];

        dp[0] = 1;
        dp[1] = ways1(a[0]);

        for (int i = 2; i <= n; i++) {
            char prev = a[i - 2], cur  = a[i - 1];

            dp[i] = (dp[i] + dp[i - 1] * ways1(cur)) % MOD;     // 1-char
            dp[i] = (dp[i] + dp[i - 2] * ways2(prev, cur)) % MOD; // 2-char
        }

        return (int) dp[n];
    }

    private long ways1(char c) {
        if (c == '*') return 9;   // '1'..'9'
        if (c == '0') return 0;   // invalid alone
        return 1;                 // '1'..'9'
    }

    private long ways2(char p, char c) {
        if (p == '*' && c == '*') return 15; // 11-19 (9) + 21-26 (6)

        if (p == '*') { // p can be '1' or '2'
            if (c >= '0' && c <= '6') return 2; // 10-16 or 20-26
            if (c >= '7' && c <= '9') return 1; // 17-19 only
            return 0;
        }

        if (c == '*') {
            if (p == '1') return 9; // 11-19
            if (p == '2') return 6; // 21-26
            return 0;
        }

        int val = (p - '0') * 10 + (c - '0');
        return (val >= 10 && val <= 26) ? 1 : 0;
    }
}