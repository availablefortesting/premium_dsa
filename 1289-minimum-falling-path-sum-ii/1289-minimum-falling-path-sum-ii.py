class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        n = len(grid)
        # print(*grid, sep = "\n", end = "\n\n")
        
        min_path_sum = float("inf")
        min_1, j1 = 0, -1
        min_2, j2 = 0, -1
        for i in range(n):
            min_1_c, j1_c = float("inf"), -1
            min_2_c, j2_c = float("inf"), -1
            
            for j in range(n):
                if j != j1:     grid[i][j] += min_1
                else:           grid[i][j] += min_2
                    
                if min_1_c > grid[i][j]:
                    min_2_c, j2_c = min_1_c, j1_c
                    min_1_c, j1_c = grid[i][j], j
                elif min_2_c > grid[i][j]:
                    min_2_c, j2_c = grid[i][j], j
                    
                if i == n - 1:
                    min_path_sum = min(min_path_sum, grid[i][j])
                    
            min_1, j1 = min_1_c, j1_c
            min_2, j2 = min_2_c, j2_c
            # print(min_1, j1, " : ", min_2, j2)
            
        # print(*grid, sep = "\n")
        return min_path_sum