class Solution:
    def findRotateSteps(self, ring: str, key: str) -> int:
        n, m = len(key), len(ring)
        visit = set()
        q = [(0, 0, 0)]

        while q:
            i, j, depth = q.pop(0)
            
            if j == n:  
                return depth
            if (i, j) in visit: 
                continue
            visit.add((i, j))
            
            if ring[i] == key[j]:
                q.append((i, j + 1, depth + 1))
            else:
                q.append(((i + 1) % m, j, depth + 1))
                q.append(((i - 1) % m, j, depth + 1))
            