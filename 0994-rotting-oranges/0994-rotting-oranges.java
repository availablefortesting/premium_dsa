class Solution {    
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh_oranges = 0;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                    grid[i][j] = 0;
                }
                if (grid[i][j] == 1)    fresh_oranges++;
            }
        }
        
        if(fresh_oranges == 0) return 0;
        
        int time = 0;
        while (!q.isEmpty()) {
            int level_size = q.size();
            for (int i = 0; i < level_size; i++) {
                int[] cur_cell = q.poll();
                
                for (int[] d : directions) {
                    int nx = cur_cell[0] + d[0];
                    int ny = cur_cell[1] + d[1];
                    
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] != 0) {
                        q.offer(new int[]{nx,ny});
                        grid[nx][ny] = 0;
                        fresh_oranges--;
                    }
                }
                
            }
            time++;
        }
        
        return fresh_oranges == 0 ? time - 1 : -1;
    }
}