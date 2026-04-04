class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // once width is sorted we need to find Longest Increaseing Subsequence of heights
        //    and to as we can't choose same width env, we always want to pick lowest height env incase of same width
        Arrays.sort(envelopes, (a,b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        List<Integer> tails = new ArrayList<>();
        for (int[] env : envelopes) {
            int pos = Collections.binarySearch(tails, env[1]);
            if (pos < 0)    pos = -(pos + 1);

            if (tails.size() == pos)    tails.add(env[1]);
            else tails.set(pos, env[1]);
        }

        return tails.size();
    }
}