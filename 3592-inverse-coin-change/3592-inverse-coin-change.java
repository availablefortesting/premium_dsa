class Solution {
    public List<Integer> findCoins(int[] numWays) {
        int n = numWays.length, dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; ++i) dp[i + 1] = numWays[i];

        List<Integer> res = new ArrayList<>();
        for (int coin = 1; coin <= n; ++coin) {
            if (dp[coin] > 1) return new ArrayList<>();    // 1st ele come across should be 1, else not possible
            if (dp[coin] == 0) continue;
            res.add(coin);

            // if remove all the combs including num coin
            for (int v = n; v >= coin; --v) {
                dp[v] -= dp[v - coin];
                if (dp[v] < 0) return new ArrayList<>();   
            }
        }
        return res;
    }
    // REVERSE DP
    private List<Integer> findCoinsRDP(int[] numWays) {
        int n = numWays.length;
        int[] dp = new int[n + 1];
        ArrayList<Integer> coins = new ArrayList<>();
        dp[0] = 1;

        // start to check from smallest coin  possible to max coin
        for (int i = 0; i < n; i++) {
            int amount = i + 1;
            if ( numWays[i] > 0 && dp[amount] == numWays[i] - 1) {
                coins.add(amount);
                for (int coin = amount; coin <= n; coin++) {
                    dp[coin] += dp[coin - amount];
                }
            }

            if (dp[amount] != numWays[i]) return new ArrayList<>();
        }
        return coins;
    }
}