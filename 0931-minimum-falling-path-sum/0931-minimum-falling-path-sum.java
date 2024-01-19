class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int min_e = matrix[i - 1][j];
                if (j - 1 >= 0) {
                    min_e = Math.min(min_e, matrix[i - 1][j - 1]);
                }
                if (j + 1 < m) {
                    min_e = Math.min(min_e, matrix[i - 1][j + 1]);
                }
                matrix[i][j] += min_e;
            }
        }

        return Arrays.stream(matrix[n - 1]).min().getAsInt();
    }
}