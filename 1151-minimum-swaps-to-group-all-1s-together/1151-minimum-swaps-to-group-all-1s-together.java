class Solution {
    public int minSwaps(int[] data) {
        int window_size = 0, zeros = 0, n = data.length;
        int min_swap = n;
        
        for (int e : data){
            if (e == 1) window_size++;
        }
        
        if (window_size == 0)
            return 0;
        
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (data[r] == 0) zeros++;
            if (r + 1 < window_size) {
                continue;
            }
            
            min_swap = Math.min(min_swap, zeros);
            if (data[l++] == 0)
                zeros--;
        }
        
        return min_swap == n ? 0 : min_swap;
    }
}