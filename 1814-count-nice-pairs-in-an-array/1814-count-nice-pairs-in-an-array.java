class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Integer> m = new HashMap<>();
        int res = 0;
        int mod = (int) 1e9 + 7;
        
        for (int n : nums) {
            int rev_n = (Integer.valueOf(new StringBuilder(""+n).reverse().toString()));
            
            int diff = n - rev_n;
            int old_cnt = m.getOrDefault(diff,0);
            
            res = (res + old_cnt) % mod;
            m.put(diff, 1 + old_cnt);
        }
        
        return res;
    }
}