class Solution {
    public int compress(char[] chars) {
        int l = 0, r = 0, n = chars.length, i = 0, cnt = 0;
        while (l < n) {
            while (r < n && chars[l] == chars[r]) r++;
            
            chars[i++] = chars[l];
            cnt = r - l;

            if (cnt > 1) 
                for (char c : String.valueOf(cnt).toCharArray()) 
                    chars[i++] = c;
            
            l = r;
        }
        return i;
    }
}