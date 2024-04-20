class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        
        def dfs(x,y):
            if 0 <= x < m and 0 <= y < n and land[x][y]:
                land[x][y] = 0
                nonlocal bottom_x, bottom_y
                bottom_x, bottom_y = max(bottom_x, x), max(bottom_y, y)
                return dfs(x, y+1) or dfs(x+1, y)
            
        m,n = len(land), len(land[0])
        res = []
        for i in range(m):
            for j in range(n):
                if land[i][j]:
                    bottom_x, bottom_y = i, j
                    dfs(i,j)
                    res.append([i, j, bottom_x, bottom_y])
                
        return res