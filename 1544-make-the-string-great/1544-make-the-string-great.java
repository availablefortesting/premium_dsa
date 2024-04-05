class Solution {
    public String makeGood(String s) {
        int i = 0, j = 0, n = s.length();
        char[] res = s.toCharArray();
        
        while (j < n) {
            res[i] = res[j];
            if (i > 0 && Math.abs(res[i - 1] - res[i]) == 32)
                i--;
            else 
                i++;
            j++;
        }
        return new String(res, 0, i);
    }
}