class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length, n = bank[0].length();
        String emptyRow = "0".repeat(n);
        int beams = 0;
        
        int prev_r = 0, next_r = 0;
        while (prev_r < m && bank[prev_r].equals(emptyRow))
            prev_r++;
        
        while (next_r < m) {
            next_r = prev_r + 1;
            while (next_r < m && bank[next_r].equals(emptyRow))
                next_r++;
            
            if (next_r < m)
                beams += (bank[prev_r].chars().filter(c -> c == '1').count()) * (bank[next_r].chars().filter(c -> c == '1').count());
            prev_r = next_r;
        }
        
        return beams;
    }
}