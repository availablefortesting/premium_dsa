class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;
        int n = s.length(), m = t.length();
        int res = m;
        
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                res--; j++;
            }
            i++;
        }
        
        return res;
    }
}