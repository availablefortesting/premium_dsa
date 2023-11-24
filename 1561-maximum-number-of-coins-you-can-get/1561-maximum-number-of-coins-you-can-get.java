class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        
        int n = piles.length;
        int i = 0, j = n-2;
        int max_coins = 0;
        
        while (i < j) {
            max_coins += piles[j];
            
            j -= 2;
            i++;
        }
        
        return max_coins;
    }
}
