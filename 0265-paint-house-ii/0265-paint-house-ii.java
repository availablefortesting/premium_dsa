class Solution {
    /*
        6 months ago: LinkedIn-6 Meta-3 
    */
    private int[][] costs;
    private int n, m;
    private Integer[][] memo;

    public int minCostII(int[][] costs) {
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