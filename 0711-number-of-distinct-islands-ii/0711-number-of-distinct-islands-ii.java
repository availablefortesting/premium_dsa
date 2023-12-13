class Solution {
    private final int[][] dirs = new int[][]{{0, 1},{0, -1},{1, 0},{-1, 0}};
    
    public int numDistinctIslands2(int[][] mat) {
        Set<Map<Integer, Integer>> allDistinctIslands = new HashSet<>();
        int rows = mat.length;
        int cols = mat[0].length;
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                if (mat[r][c] == 1)
                {
                    List<int[]> positions = new ArrayList<>();
                    getIsland(mat, r, c, positions);
                    Map<Integer, Integer> allDistanceCountMap = new HashMap<>();
                    for (int i = 0; i < positions.size(); i++)
                    {
                        for (int j = i + 1; j < positions.size(); j++)
                        {
                            int dist = (int)Math.pow(positions.get(i)[0] - positions.get(j)[0], 2) + (int)Math.pow(positions.get(i)[1] - positions.get(j)[1], 2);
                            allDistanceCountMap.put(dist, allDistanceCountMap.getOrDefault(dist, 0) + 1);
                        }
                    }
                    allDistinctIslands.add(allDistanceCountMap);
                }
            }
        }
        return allDistinctIslands.size();
    }
    
    private void getIsland(int[][] mat, int r, int c, List<int[]> positions)
    {
        positions.add(new int[]{r, c});
        mat[r][c] = 0;
        for (int[] dir : dirs)
        {
            int rNext = r + dir[0];
            int cNext = c + dir[1];
            if (rNext < 0 || rNext >= mat.length || cNext < 0 || cNext >= mat[0].length || mat[rNext][cNext] == 0)
            {
                continue;
            }
            getIsland(mat, rNext, cNext, positions);
        }
    }
}