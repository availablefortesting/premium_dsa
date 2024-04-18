class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        
        def dfs(x,y):
            if 0 <= x < m and 0 <= y < n:
                if not grid[x][y]:  return 1        # water cell
                if grid[x][y] == -1:    return 0    # visited land cell
                grid[x][y] = -1                     # mark land cell visited
                return dfs(x, y + 1) + dfs(x + 1, y) + dfs(x, y - 1) + dfs(x - 1, y)
            
            # for boundries
            return 1
            
        m,n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j]:
                    return dfs(i,j)
        return 0