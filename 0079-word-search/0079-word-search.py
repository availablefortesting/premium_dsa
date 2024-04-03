class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        directions = [[0,1],[1,0],[0,-1],[-1,0]]
        m, n = len(board), len(board[0])
        # memo = defaultdict(bool)
        
        def dfs(i, x, y):
            # if (i,x,y) in memo:
            #     return memo[(i,x,y)]
            
            if i == len(word) - 1:
                # memo[(i,x,y)] = True
                # return memo[(i,x,y)]
                return True
            
            
            # memo[(i,x,y)] = False
            memo = False
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                
                if 0 <= nx < m and 0 <= ny < n and (nx,ny) not in visited and board[nx][ny] == word[i + 1]:
                    # memo[(i,x,y)] |= dfs(i+1, nx, ny)
                    visited.add((x,y))
                    memo |= dfs(i+1, nx, ny)
                    visited.remove((x,y))
                    
            # return memo[(i,x,y)]
            return memo
        
        for x in range(m):
            for y in range(n):
                visited = set()
                if board[x][y] == word[0] and dfs(0, x, y):
                    return True

        return False