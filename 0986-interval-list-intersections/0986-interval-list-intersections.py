class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        n, m = len(firstList), len(secondList)
        if n == 0 or m == 0:
            return []
        
        i, j = 0, 0
        res = []
        while i < n and j < m:
            y1 = firstList[i][1]
            y2 = secondList[j][1]
            
            start = max(firstList[i][0], secondList[j][0])
            end = min(y1, y2)
            
            if start <= end:    res.append([start, end])
            
            if y1 < y2: i += 1
            else:       j += 1
                
        return res