class Solution {
    public int countSubarrays(int[] nums, int k) {
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1); // Dummy value of 0's frequency is 1.
        int ans = 0, runningSum = 0;
        boolean found = false;
        for (int num : nums) {
            if (num < k)        --runningSum;
            else if (num > k)   ++runningSum;
            else                found = true;

            if (found) {
                // to have k as median, the subarray sum should be 0 or 1, means <k and >k should be equal or >k one more to <k (even case)
                ans += prefixSumFreq.getOrDefault(runningSum, 0);
                ans += prefixSumFreq.getOrDefault(runningSum - 1, 0);
            }else {
                // prefixSumFreq.merge(runningSum, 1, Integer::sum);
                prefixSumFreq.put(runningSum, prefixSumFreq.getOrDefault(runningSum, 0) + 1);
            }
        }
        return ans;
    }
}