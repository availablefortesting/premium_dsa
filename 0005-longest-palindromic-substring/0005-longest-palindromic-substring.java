class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), resL = 1;
        String res = String.valueOf(s.charAt(0));
        
        // centred around
        for (int i = 0; i < n; i++) {
            // odd length case
            int l = i-1, r = i+1;  
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if ((r-l+1) > resL ) {
                    resL = r-l+1;
                    res = s.substring(l, r+1);
                }
                l--; r++;
            }
            
            // even length case
            l = i;
            r = i+1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if ((r-l+1) > resL ) {
                    resL = r-l+1;
                    res = s.substring(l, r+1);
                }
                l--; r++;
            }
            
        }
        
        return res;
    }
}