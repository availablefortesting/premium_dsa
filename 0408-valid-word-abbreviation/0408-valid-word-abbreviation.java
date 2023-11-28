class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int n = word.length(), m = abbr.length();
        int i = 0, j = 0;
        
        while (i < n && j < m) {
            char c = abbr.charAt(j);
            if (word.charAt(i) == c) {
                ++i;
                ++j;
                continue;
            }
            
            // edge case of leading ZERO's handled here, isn't cool !!
            if (abbr.charAt(j) <= '0' || c > '9') {
                return false;
            }
            
            int num = 0;
            while (j < m && (c >= '0' && c <= '9')) {
                num = 10 * num +  (c - '0');
                
                ++j;
                if (j < m) c = abbr.charAt(j);
            }
            i += num;
        }
        
        return i == n && j == m;
    }
}