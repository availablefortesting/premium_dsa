class Solution:
    def trap(self, height: List[int]) -> int:
        stack = []
        i, max_square = 0, 0
        
        for i, cur_height in enumerate(height + [0]):
            while stack and height[stack[-1]] >= cur_height:
                middle_idx = stack.pop()
                    
                w = i - (stack[-1] if stack else -1) - 1 
                sq_side = min(w, height[middle_idx])
                max_square = max(max_square, sq_side * sq_side)
                
            stack.append(i)
            i += 1
            
        return max_square
    
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m,n = len(matrix), len(matrix[0])
        heights = [0] * n
        max_area = 0
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == "1":    heights[j] += 1
                else:                      heights[j] = 0
                    
            max_area = max(max_area, self.trap(heights))
            
        return max_area
            