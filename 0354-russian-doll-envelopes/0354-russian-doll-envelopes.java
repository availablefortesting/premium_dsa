class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // once width is sorted we need to find Longest Increaseing Subsequence of heights
        //    and to as we can't choose same width env, we always want to pick lowest height env incase of same width
        Arrays.sort(envelopes, (a,b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        // Step 2: LIS on heights
        int[] dp = new int[envelopes.length];
        int len = 0;

        for (int[] env : envelopes) {
            int height = env[1];

            int index = Arrays.binarySearch(dp, 0, len, height);
            if (index < 0) index = -(index + 1);

            dp[index] = height;
            if (index == len) len++;
        }

        return len;
    }
}