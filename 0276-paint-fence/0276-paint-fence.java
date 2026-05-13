class Solution {
    /**
        6 months ago: Google 4, Meta 2, Snowflake 2
     */
    public int numWays(int n, int k) {
        // if there are no posts, there are no ways to paint them
        if (n == 0) return 0;
        
        // if there is only one post, there are k ways to paint it
        if (n == 1) return k;
        
        // if there are only two posts, you can't make a triplet, so you 
        // are free to paint however you want.
        // first post, k options. second post, k options
        if (n == 2) return k * k;
        
        int dp[] = new int[n+1];
        dp[0] = 0; dp[1] = k; dp[2] = k * k;
        for (int i = 3; i <= n; i++) {
            /**
                num_ways(i) = num_ways_diff(i) + num_ways_same(i)  (in compare to i-1th post)
                num_ways(i) = num_ways(i-1) * (k-1) + num_ways_same(i)  // there will be k-1 diff col as 1 used on ith
                num_ways(i) = num_ways(i-1) * (k-1) + num_ways_diff(i-1) * 1  // use prev col from last diff
                num_ways(i) = num_ways(i-1) * (k-1) + num_ways(i-2) * (k-1)  // substitute earlier formula #2
                num_ways(i) = (num_ways(i-1) + num_ways(i-2)) * (k-1)
             */
            dp[i] = (dp[i-1] + dp[i-2]) * (k - 1);
        }
        return dp[n];
    }
}