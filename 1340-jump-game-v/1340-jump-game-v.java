class Solution {
    int d, n;
    int[] arr;
    int[] memo;

    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.d = d; this.n = arr.length;
        this.memo = new int[n];
        Arrays.fill(memo, -1);

        int res = 1;
        for (int i = 0; i < n; i++)
            res = Math.max(res, dfs(i));

        // System.out.println(Arrays.toString(memo));
        return res;
    }

    private int dfs(int idx) {
        if (memo[idx] != -1) return memo[idx];

        int res = 1;
        for (int i = idx - 1; i >= Math.max(0, idx - d); i--)
            if (arr[idx] > arr[i]) 
                res = Math.max(res, 1 + dfs(i));
            else break;

        for (int i = idx + 1; i <= Math.min(idx + d, n-1); i++)
            if (arr[idx] > arr[i]) 
                res = Math.max(res, 1 + dfs(i));
            else break;

        return memo[idx] = res;
    }
}