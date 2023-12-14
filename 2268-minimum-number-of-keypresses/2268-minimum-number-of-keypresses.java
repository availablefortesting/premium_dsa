class Solution {
    public int minimumKeypresses(String str) {
        Integer[] freq = new Integer[26];
        Arrays.fill(freq, 0);
        
        for(int i = 0; i < str.length(); i++)
            freq[str.charAt(i) - 'a']++;
        
        Arrays.sort(freq, (x, y) -> y - x);
        
        int result = 0;
        for(int i = 0; i < 26; i++)
            result += freq[i] * ((i + 9)/9);
        
        return result;
    }
}