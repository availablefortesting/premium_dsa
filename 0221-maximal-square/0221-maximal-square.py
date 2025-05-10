class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        maxArea = 0
        m,n = len(matrix), len(matrix[0])

        for i in range(m):
            if matrix[i][0] == '1': 
                maxArea = 1
                break
        for j in range(n):
            if matrix[0][j] == '1': 
                maxArea = 1
                break

        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == '1':
                    matrix[i][j] = min(int(matrix[i][j-1]), int(matrix[i-1][j-1]), int(matrix[i-1][j])) + 1
                    maxArea = max(maxArea, matrix[i][j] * matrix[i][j])

        return maxArea 