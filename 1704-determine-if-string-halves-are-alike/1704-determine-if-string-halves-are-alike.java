class Solution {
    public boolean halvesAreAlike(String s) {
        HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a','e','i','o','u','A','E','I','O','U')
        );
        
        int n = s.length();
        int i = 0, j = n/2;
        int diff = 0;
        while (j < n) {
            if (vowels.contains(s.charAt(i++)))  diff++;
            if (vowels.contains(s.charAt(j++)))  diff--;
        }
        
        return diff == 0;
    }
}