class Solution {
    private boolean recursive(String s, List<String> wordDict, int i) {
        if (i < 0) 
            return true;
        
        // if (memo[i] != -1) {
        //     return memo[i] == 1;
        // }
        
        for (String word: wordDict) {
            // Handle out of bounds case
            if (i - word.length() + 1 < 0) {
                continue;
            }
            
            if (s.substring(i - word.length() + 1, i + 1).equals(word) && recursive(s, wordDict, i - word.length())) {
                // memo[i] = 1;
                return true;
            }
        }
        
        // memo[i] = 0;
        return false;
    }
    
    // O(n * m * k)
    private boolean dp(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        
        for (int i = n-1; i >= 0; --i) {
            for (String word : wordDict) {
                if ( (i + word.length()) <= n && s.substring(i, i + word.length()).equals(word) ) {
                    dp[i] = dp[i+word.length()];
                }
                if (dp[i] == true)  break;
            }
        }
        
        return dp[0];
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        return dp(s, wordDict);
        // return recursive(s, wordDict, s.length()-1);
    }
}