class Solution {
    private boolean isMapEqual(HashMap<Character, Integer> a, HashMap<Character, Integer> b) {
        for (char key : b.keySet())
            if (!a.containsKey(key) || a.get(key) < b.get(key))
                return false;
        
        return true;
    }
    
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> t_map = new HashMap<>();
        HashMap<Character, Integer> s_map = new HashMap<>();
        
        for (char c : t.toCharArray())
            t_map.put(c, 1 + t_map.getOrDefault(c, 0));
        
        int l = 0, min_win_len = Integer.MAX_VALUE, required_len = t_map.size();
        String min_win_substr = "";
        for (int r = 0; r < s.length(); r++) {
            s_map.put(s.charAt(r), 1 + s_map.getOrDefault(s.charAt(r), 0));
            
            while (s_map.size() >= required_len && isMapEqual(s_map, t_map)) {
                int cur_len = r - l + 1;
                if (cur_len < min_win_len) {
                    min_win_len = cur_len;
                    min_win_substr = s.substring(l, r + 1);
                }
                
                int cur_freq = s_map.get(s.charAt(l));
                s_map.put(s.charAt(l), cur_freq - 1);
                if (cur_freq == 1)
                    s_map.remove(s.charAt(l));
                
                l++;
            }
        }
        
        return min_win_substr;
    }
}