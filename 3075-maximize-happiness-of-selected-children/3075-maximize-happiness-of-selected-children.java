class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long max_happiness = 0;
        int n = happiness.length;
        
        int i = n - 1;
        while (k > 0 && i >= 0 && (happiness[i] - ((n - 1) - i)) > 0) {
            max_happiness += (happiness[i] - ((n - 1) - i));
            i--; k--;
        }
        return max_happiness;
    }
}