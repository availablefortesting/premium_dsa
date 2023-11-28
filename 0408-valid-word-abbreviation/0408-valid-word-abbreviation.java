class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int n = word.length(), m = abbr.length();
        int i = 0, j = 0;
        int num = 0;
        
        while (i < n && j < m) {
            char c = abbr.charAt(j);
            if (Character.isDigit(c)) {
                if (num == 0 && c == '0')   
                    return false;
                num = 10 * num + (c - '0');
            } else {
                i += num;
                // System.out.println(i + " : " + word.charAt(i) + " - " + c);
                if (i < n && word.charAt(i) != c) {
                    return false;
                }
                
                num = 0;
                ++i;
            }
            ++j;
        }
        
        return ((i + num) == n && j == m) ? true : false;
    }
}