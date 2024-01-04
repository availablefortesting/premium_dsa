class Solution {
    private int intuitive(int[] prices) {
        // It is impossible to sell stock on first day, set -infinity as initial value for cur_hold
        int hold = Integer.MIN_VALUE, notHold = 0;
        for( int stockPrice : prices ) {
            int prevHold = hold, prevNotHold = notHold;
            
            // either keep hold, or buy in stock today at stock price
            hold = Math.max(prevHold, prevNotHold - stockPrice);
            
            // either keep not-hold, or sell out stock today at stock price
            notHold = Math.max(prevNotHold, prevHold + stockPrice);
        }
        // maximum profit must be in not-hold state
        return notHold;
    }
    
    public int maxProfit(int[] prices) {
        int k = 2;
        int[] buy = new int[k + 1], sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }
}