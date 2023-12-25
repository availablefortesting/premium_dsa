class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        char prev = 'a';
        
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            
            if (cur == '0'){
                if (prev <= '0' || prev > '2')
                    return 0;
                else
                    dp[i+1] += dp[i-1];
            } else {
                dp[i+1] = dp[i];
                if (prev == '1' || prev == '2' && cur <= '6')
                    dp[i+1] += dp[i-1]; 
            }
            
            prev = cur;
        }
        
        // for (int d : dp) 
        //     System.out.println(d);
        return dp[n];
    }
}