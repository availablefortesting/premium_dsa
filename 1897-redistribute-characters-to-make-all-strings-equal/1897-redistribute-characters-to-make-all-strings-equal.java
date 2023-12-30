class Solution {
    public boolean makeEqual(String[] words) {
        int[] c_map = new int[26];
        int n = words.length;
        
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray())
                c_map[c - 'a']++;
        }
        
        for (int i = 0; i < 26; i++)
            if (c_map[i] % n != 0)
                return false;
        
        return true;
    }
}