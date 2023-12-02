class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> cnts = new HashMap<>();
        for (char c : chars.toCharArray()) {
            cnts.put(c, 1 + cnts.getOrDefault(c, 0));
        }
        
        int res = 0;
        toStart : for (String word : words) {
            HashMap<Character, Integer> w_freq = new HashMap<>();
            for (char c : word.toCharArray()) {
                w_freq.put(c, 1 + w_freq.getOrDefault(c, 0));
            }
        
            for (char c : word.toCharArray()) {
                if (w_freq.get(c) > cnts.getOrDefault(c, Integer.MIN_VALUE)) {
                    continue toStart;
                }
            }
            
            res += word.length();
        }
        
        return res;
    }
}