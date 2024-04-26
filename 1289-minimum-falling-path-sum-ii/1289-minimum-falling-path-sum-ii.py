class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        n = len(grid)
        
        min_path_sum = float("inf")
        min_1, min_2, j1 = 0, 0, -1

        for i in range(n):
            min_1_c, min_2_c, j1_c = float("inf"), float("inf"), -1
            
            for j in range(n):
                mn = min_1 if j != j1 else min_2
                    
                if min_1_c > grid[i][j] + mn:
                    min_2_c = min_1_c
                    min_1_c, j1_c = grid[i][j] + mn, j
                elif min_2_c > grid[i][j] + mn:
                    min_2_c, j2_c = grid[i][j] + mn, j
                    
            min_1, min_2, j1 = min_1_c, min_2_c, j1_c
            
        # print(*grid, sep = "\n")
        return min_1