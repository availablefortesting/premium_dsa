class Solution {
    public long wonderfulSubstrings(String word) {
        int mask = 0;
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        
        long res = 0;
        for (int i = 0; i < word.length(); i++) {
            int cur_char = word.charAt(i) - 'a';
            mask ^= 1 << cur_char;
            
            res += prefix.getOrDefault(mask, 0);
            for (int j = 0; j < 10; j++) {
                res += prefix.getOrDefault(mask ^ (1 << j), 0);
            }
            prefix.put(mask, prefix.getOrDefault(mask, 0) + 1);
        }
        
        return res;
    }
}