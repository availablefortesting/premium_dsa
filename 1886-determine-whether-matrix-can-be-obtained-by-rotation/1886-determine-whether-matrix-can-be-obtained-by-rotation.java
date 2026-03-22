class Solution {
    public boolean findRotation(int[][] a, int[][] b) {
        int n = a.length, size = a.length * a.length;
        int c90 =0, c180 = 0, c270 = 0, c0 = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (b[i][j] == a[n-j-1][i])  c90++;
                if (b[i][j] == a[n-i-1][n-j-1])  c180++;
                if (b[i][j] == a[j][n-i-1])  c270++;
                if (b[i][j] == a[i][j])  c0++;
            }
        }
        
        if (c90 == size ||c270 == size ||c180 == size ||c0 == size) return true;
        
        return false;
    }
}