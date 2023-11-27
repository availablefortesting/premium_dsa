class Solution {
    int MOD = (int) 1e9 + 7;
    static int[][] jumps = {
            {4, 6},
            {6, 8},
            {7, 9},
            {4, 8},
            {3, 9, 0},
            {},
            {1, 7, 0},
            {2, 6},
            {1, 3},
            {2, 4}
        };
    
    public int knightDialer(int n) {
        if (n == 1) return 10;
        
        int[] prev = new int[10];
        Arrays.fill(prev, 1);
        
        while (n != 1) {
            int[] cur = new int[10];
            
            for (int i = 0; i < 10; i++) {
                for (int next_pos : jumps[i]) {
                    cur[next_pos] = (cur[next_pos] + prev[i]) % MOD; 
                }
            }
            
            prev = cur; 
            n--;
        }
        
        int res = 0;
        for (int num : prev)
            res = (res + num) % MOD;
        
        return res;
    }
}