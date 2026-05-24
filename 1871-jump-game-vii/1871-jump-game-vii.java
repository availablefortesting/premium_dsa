class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length() - 1) != '0')
            return false;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        // This variable tells us till which index we have processed
        int maxReach = 0;
        
        while(!queue.isEmpty()){
            int idx = queue.remove();
            // If we reached the last index
            if(idx == s.length() - 1)
                return true;
            
            // start the loop from max of [current maximum (idx + minJump), maximum processed index (maxReach)]
            for(int j = Math.max(idx + minJump, maxReach); j <= Math.min(idx + maxJump, s.length() - 1); j++){
                if(s.charAt(j) == '0')
                    queue.add(j);
            }
            
            // since we have processed till idx + maxJump so update maxReach to next index
            maxReach = Math.min(idx + maxJump + 1, s.length() - 1);
        }
        
        return false;
    }

    // O(n)
    private boolean canReach2(String s, int minJ, int maxJ) {
        int n = s.length(), pre = 0;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; ++i) {
            if (i >= minJ && dp[i - minJ])
                pre++;
            if (i > maxJ && dp[i - maxJ - 1])
                pre--;
            dp[i] = pre > 0 && s.charAt(i) == '0';
        }
        return dp[n - 1];
    }
}