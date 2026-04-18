class Solution {
    private int n;
    private char[][] board;
    private boolean[] col, backwardDiag, forwardDiag;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.board = new char[n][n];
        for (int r = 0; r < n; r++) Arrays.fill(board[r], '.');

        this.col = new boolean[n];
        // backwardDiag is calc as (r-c) and other as (r+c). And unique diff values we can have is 2*n-1
        this.backwardDiag = new boolean[2 * n - 1]; // as this can have neg range [-(n-1), (n-1)] --shift{+(n-1)}--> [0, 2*n-2] 
        this.forwardDiag = new boolean[2 * n - 1];

        this.res = new ArrayList<>();

        backtracking(0);

        return this.res;
    }

    private void backtracking(int r) {
        if (r == this.n) {
            List<String> sol = new ArrayList<>(this.n);
            for (int i = 0; i < n; i++) sol.add(new String(this.board[i]));
            this.res.add(sol);
            return;
        } else {
            // try to place queen in every r-c[0..n-1] positions
            for (int c = 0; c < this.n; c++) {
                // first check we can place Q in [r][c] position??
                int backwardDiagVal = (r - c) + (this.n - 1);
                int forwardDiagVal = (r + c);

                if (this.col[c] || this.backwardDiag[backwardDiagVal] || this.forwardDiag[forwardDiagVal])  continue;

                // place it and mark it
                this.board[r][c] = 'Q';
                this.col[c] = this.backwardDiag[backwardDiagVal] = this.forwardDiag[forwardDiagVal] = true;

                // now try to place next Q in next row, if not possible revert
                backtracking(r+1);

                this.board[r][c] = '.';
                this.col[c] = this.backwardDiag[backwardDiagVal] = this.forwardDiag[forwardDiagVal] = false;
            }
        }
    }

    // private boolean canPlaceQueen(int r, int c) {
    //     int backwardDiagVal = (r - c) + (this.n - 1);
    //     int forwardDiagVal = (r + c);

    //     if (this.col[c] || this.backwardDiag[backwardDiagVal] || this.forwardDiag[forwardDiagVal])
    //         return false;
    //     return true;
    // }
}