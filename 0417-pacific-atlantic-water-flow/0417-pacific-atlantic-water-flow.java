class Solution {
    int m, n;
    int[][] h, vis;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        h = heights;
        m = h.length;
        n = h[0].length;
        vis = new int[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, 1);          // Pacific
            dfs(i, n - 1, 2);      // Atlantic
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, 1);          // Pacific
            dfs(m - 1, j, 2);      // Atlantic
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (vis[i][j] == 3)
                    res.add(List.of(i, j));

        return res;
    }

    void dfs(int x, int y, int bitMask) {
        if ((vis[x][y] & bitMask) == bitMask) return;

        vis[x][y] |= bitMask;
        for (int[] d : directions) {
            int nx = x + d[0], ny = y + d[1];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && h[x][y] <= h[nx][ny])
                dfs(nx, ny, bitMask);
        }
    }
}