class Solution:
    def findRotateSteps(self, ring: str, key: str) -> int:
        m, n = len(ring), len(key)
        @cache
        def dfs(i, j, dire):
            if j == n:
                return 0
            
            if ring[i] == key[j]:
                return 1 + min(dfs(i, j + 1, 0), dfs(i, j + 1, 1))
            else:
                if dire == 1:   # forward
                    return 1 + dfs((i+1) % m, j, dire)
                else:
                    return 1 + dfs((m + i-1) % m, j, dire)
            
        return min(dfs(0, 0, 0), dfs(0, 0, 1))
            