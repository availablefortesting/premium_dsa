class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty string
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        char prev = s.charAt(0), cur = '#';
        
        for (int i = 2; i < n + 1; i++) {
            cur = s.charAt(i - 1);
            if (cur != '0') {
                dp[i] += dp[i - 1];
            }
            if (prev == '1' || prev == '2' && cur <= '6') {
                dp[i] += dp[i - 2];
            }
            
            prev = cur;
        }
        
        return dp[n];
    }
}