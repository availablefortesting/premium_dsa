class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // min_cap first
        PriorityQueue<int[]> pqCapital = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        // max_profit first 
        PriorityQueue<int[]> pqProfit = new PriorityQueue<>((a,b) -> (b[1] - a[1]));
        
        int n = capital.length;
        for(int i = 0; i < n; i++)
            pqCapital.offer(new int[]{capital[i], profits[i]});
        
        while (k != 0) {
            while (!pqCapital.isEmpty() && pqCapital.peek()[0] <= w)
                // it will have current affordable and previous projects
                pqProfit.offer(pqCapital.poll());
            
            if (pqProfit.isEmpty()) break;
            w += pqProfit.poll()[1];
            k--;
        }
        
        return w;
    }
}