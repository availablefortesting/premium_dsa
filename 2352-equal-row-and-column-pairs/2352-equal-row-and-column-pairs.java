class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> hm_rows = new HashMap<>();
        HashMap<String, Integer> hm_cols = new HashMap<>();
        int res = 0;
        
        for (int i = 0; i < grid.length; i++) {
            String cur_row = "";
            for (int j = 0; j < grid.length; j++)
                cur_row += (grid[i][j] + ",");
            hm_rows.put(cur_row, 1 + hm_rows.getOrDefault(cur_row , 0));
        }
        
        for (int j = 0; j < grid.length; j++) {
            String cur_col = "";
            for (int i = 0; i < grid.length; i++)
                cur_col += (grid[i][j] + ",");
            hm_cols.put(cur_col, 1 + hm_cols.getOrDefault(cur_col , 0));
        }
        
        for (String row : hm_rows.keySet()) {
            if (hm_cols.containsKey(row)) {
                res += hm_rows.get(row) * hm_cols.get(row);
            }
        }

        return res;
    }
}