class Solution {
    public int compress(char[] chars) {
        int idx = 0, n = chars.length;
        int g_cnt = 1;
        
        for (int i = 1; i <= n; i++) {
            if (i == n || chars[i-1] != chars[i]){
                chars[idx++] = chars[i-1];
                
                if (g_cnt != 1) {
                    for (char num : String.valueOf(g_cnt).toCharArray())
                        chars[idx++] = num;
                }
                
                g_cnt = 1;
            } else 
                g_cnt++;
        }
        
        return idx;
    }
}