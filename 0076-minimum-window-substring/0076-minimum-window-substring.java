class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray())
            map[c]++;
        
        int counter = t.length();
        int l = 0, r = 0, d = Integer.MAX_VALUE, head = 0;
        
        while (r < s.length()) {
            if (map[s.charAt(r++)]-- > 0)
                counter--;
            
            while (counter == 0) { // valid
                if (r - l < d) 
                    d = r - (head = l);
                
                // only required char from t in s will have zero freq here, else would be negative
                if (map[s.charAt(l++)]++ == 0)
                    counter++;
            }
        }
        
        return (d == Integer.MAX_VALUE) ? "" : s.substring(head, head + d);
    }
}