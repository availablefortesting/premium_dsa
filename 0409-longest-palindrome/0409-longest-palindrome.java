class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> odds = new HashSet<>();
        for(char c : s.toCharArray())
            if (odds.contains(c))   odds.remove(c);
            else                    odds.add(c);
        
        return s.length() - Math.max(0, odds.size() - 1);
    }
}