class Solution {
    public int countBinarySubstrings(String s) {
        int cnt = 0;

        int i = 0, n = s.length();
        while(i < n-1) {
            if (s.charAt(i) != s.charAt(i+1)) {
                ++cnt;
                
                int l = i-1, r = i+2;
                while (l >= 0 && r < n && s.charAt(i) == s.charAt(l) && s.charAt(l) != s.charAt(r)) {
                    ++cnt;
                    --l;++r;
                }
            }
            ++i;
        }
        return cnt;
    }
}