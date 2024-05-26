class Solution {
    public int checkRecord(int n) {
        int[][][] dp = new int[n+1][2][3];
        
        dp[n] = new int[][]{{1,1,1},{1,1,1}};
        
        int mod = 1000000007;
        
        for(int i = n-1; i >= 0; i--) 
            for(int A = 0; A < 2; A++)
                for(int L = 0;L < 3; L++) {
                    dp[i][A][L] = dp[i+1][A][0];
                    if(A == 0) 
                        dp[i][0][L] = (dp[i][0][L] + dp[i+1][1][0])%mod;
                    if(L<2) 
                        dp[i][A][L] = (dp[i][A][L] + dp[i+1][A][L+1])%mod;
                }   
        
        return dp[0][0][0];   
    }
}