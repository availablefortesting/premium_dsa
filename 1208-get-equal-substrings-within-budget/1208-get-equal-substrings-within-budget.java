class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int cur_cost = 0, l = 0, n = s.length();
        int max_length_substr = 0;
        
        for(int  r = 0; r < n; r++) {
            cur_cost += Math.abs(s.charAt(r) - t.charAt(r));
            
            while (cur_cost > maxCost) {
                cur_cost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
            max_length_substr = Math.max(max_length_substr, r - l + 1);
        }
        return max_length_substr;
    }
}