class Solution {  
    private int minCoinsBounded(int n) {
        int[] coins = {1,2,4,6};
        int[] limit = new int[7];

        for (int coin : coins) limit[coin] = Integer.MAX_VALUE;
        limit[4] = 2;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            /**
                Why prev = dp.clone()?
                Without the snapshot, when processing coin=3, limit=2 at j=6:

                dp[3] was already updated earlier in the same loop pass
                dp[6] = dp[3] + 1 would count 3 twice → uses coin 3 three times (1 + 2) (violates limit)
             */
            int[] prev = dp.clone();

            for (int j = coin; j <= n; j++) {
                for (int k = 1; k < limit[coin] && k * coin <= j; k++) {
                    if (prev[j - k * coin] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], k + prev[j - k * coin]);
                    }
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
    public int numberOfWays(int amount) {
        int MOD = 1_000_000_007;
        int[] coins = new int[]{ 1, 2, 6 };
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // bounding it
        if(amount >= 4) dp[4] = 1;
        if(amount >= 8) dp[8] = 1;
        
        for(int coin: coins){
            for(int i=1; i<=amount; i++){
                if(coin > i) continue;
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }
        return dp[amount];   
    }
}