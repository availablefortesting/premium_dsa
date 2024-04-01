class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        directions = [[0,1],[1,0],[0,-1],[-1,0]]
        m,n = len(matrix), len(matrix[0])
        memo = defaultdict(int) 
        
        def dfs(x,y):
            if (x,y) in memo:
                return memo[(x,y)]
            
            max_path = 0
            for dx, dy in directions:
                nx, ny = dx + x, dy + y
                
                if 0 <= nx < m and 0 <= ny < n and matrix[x][y] < matrix[nx][ny]:
                    max_path = max(max_path, dfs(nx, ny))
                    
            memo[(x,y)] = 1 + max_path
            return memo[(x,y)]
                
        res = 0
        for i in range(m):
            for j in range(n):
                res = max(res, dfs(i, j))
                
        return res