class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        
        for i in range(1, len(heights)):
            temp = heights[i] - heights[i-1]
            heights[i-1] = max(0, temp)
            
        n = len(heights) - 1
        heap = []
        
        print(heights[:-1])
        req_bricks = 0
        for i,jump in enumerate(heights[:-1]):
            if not jump: continue
            heapq.heappush(heap, jump)
            
            if (len(heap)) > ladders:
                req_bricks += heapq.heappop(heap)
                
            if req_bricks > bricks:
                return i
            
        return n