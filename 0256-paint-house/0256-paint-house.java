class Solution {
    /*
        0-6 months: LinkedIn (4) Amazon (2) Navan (2)
        6 months ago: Citadel (3) Google (2) Microsoft (2) Uber (2) Shopify (2)
    */
    private int[][] costs;
    private int n, m;
    private Integer[][] memo;

    public int minCost(int[][] costs) {
        this.costs = costs;
        this.n = costs.length;
        this.m = costs[0].length;
        
        this.memo = new Integer[n][m + 1]; // +1 to handle prevCol = -1
        
        return helper(0, -1);
    }

    private int helper(int i, int prevCol) {
        if (i == n) return 0;
        
        int memoIdx = prevCol + 1;
        if (memo[i][memoIdx] != null)   return memo[i][memoIdx];
        
        int res = Integer.MAX_VALUE;
        for (int c = 0; c < m; c++) {
            if (c == prevCol) continue;
            
            res = Math.min(res, costs[i][c] + helper(i + 1, c));
        }
        
        return memo[i][memoIdx] = res;
    }
}