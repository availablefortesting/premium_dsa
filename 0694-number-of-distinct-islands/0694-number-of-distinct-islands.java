class Solution {
    /*
                {1, 1, 0},
                {1, 0, 0},
                {0, 0, 0},
                {1, 1, 0},
                {0, 1, 0}
                
        o - start, and move 0 - right, 1 - down, 2 - left, 3 - up
        Shapes will be, o0_1__ and o0_1___
    */
    
    private static int rows, cols;
    private static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int numDistinctIslands(int[][] grid) {
        cols = grid[0].length;
        rows = grid.length;   
        Set<String> uniqueShapes = new HashSet<>(); // Unique shpes.        
        StringBuilder shape;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {               
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    shape = new StringBuilder("o");
                    dfsTraversal(i, j, grid, shape);      
                    uniqueShapes.add(shape.toString());    
                }
            }
        }
        
        return uniqueShapes.size();
    }
    
    private static void dfsTraversal(int x, int y, int[][] matrix, StringBuilder shape) {        
        
        for (int i = 0; i < directions.length; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];   
            if (nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                if (matrix[nx][ny] == 1) {
                    matrix[nx][ny] = 0;
                    shape.append(i);
                    dfsTraversal(nx, ny, matrix, shape);
                }
            }
        }
        shape.append("_");   
    }
}