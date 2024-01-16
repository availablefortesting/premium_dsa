class Solution {
    public int shortestSubarray(int[] nums, int k) {
        // two-pointer approch using deque 
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++)
            prefixSum[i + 1] = prefixSum[i] + nums[i];

        Deque<Integer> deque = new ArrayDeque<>();
        int res = n + 1;

        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.getFirst()] >= k)
                res = Math.min(res, i - deque.pollFirst());

            // maintain monotonic increaseing sum
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.getLast()]) 
                deque.pollLast();

            deque.offerLast(i);
        }

        return res <= n ? res : -1;
    }
}