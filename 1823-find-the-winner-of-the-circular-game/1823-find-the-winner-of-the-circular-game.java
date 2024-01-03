class Solution {
    // Josepuse problem
    private int iterative(int n, int k) {
        int cur_n = 1, cur_winner = 0;
        
        while (cur_n <= n) {
            cur_winner = (cur_winner + k) % cur_n;
            cur_n += 1;
        }
        
        return cur_winner + 1;
    }
    
    private int solve(int n, int k) {
        if (n == 1) 
            return 0;
        
        return (solve(n-1,k) + k) % n;
    }
    
    public int findTheWinner(int n, int k) {
        // return solve(n,k) + 1;
        return iterative(n,k);
    }
}