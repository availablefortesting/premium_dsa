class Solution {
    private int simulation(int n) {
        boolean left = true;
        int remaining = n;
        int head = 1, step = 1;
    
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head = head + step;
            }
            
            remaining = remaining / 2;
            step = step * 2;    // every time jump-gap doubles (try to see it from left side every time)
            left = !left;
        }
        
        return head;
    }
    
    public int lastRemaining(int n) {
        // return simulation(n);
        return n == 1 ? 1 : 2 * (n/2 + 1 - lastRemaining(n/2));
        // explanation: https://leetcode.com/problems/elimination-game/discuss/982449/Step-by-step-explanation-to-1-liner
    }
}