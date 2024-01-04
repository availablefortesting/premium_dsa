class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for (int c : coins)
            for (int amt = c; amt <= amount; amt++)
                    dp[amt] += dp[amt - c];
        
        return dp[amount];
    }
}