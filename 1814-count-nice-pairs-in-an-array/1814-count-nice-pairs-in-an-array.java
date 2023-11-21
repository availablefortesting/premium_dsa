class Solution {
    private int rev(int n) {
        int rev_n = 0;
        
        while (n > 0) {
            rev_n = rev_n * 10 + n % 10;
            
            n /= 10;
        }
        return rev_n;
    }
    
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Integer> m = new HashMap<>();
        int res = 0;
        int mod = (int) 1e9 + 7;
        
        for (int n : nums) {
            // int rev_n = (Integer.valueOf(new StringBuilder(""+n).reverse().toString()));
            // int diff = n - rev_n;
            
            int diff = n - rev(n);
            int old_cnt = m.getOrDefault(diff,0);
            
            res = (res + old_cnt) % mod;
            m.put(diff, 1 + old_cnt);
        }
        
        return res;
    }
}