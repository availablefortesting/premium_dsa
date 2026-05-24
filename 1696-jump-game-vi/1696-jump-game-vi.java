class Solution {
    // O(nlog(n))
    public int maxResult(int[] nums, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(k,
                Comparator.comparing(o -> -o.getValue())) {{
            offer(new Pair<>(0, nums[0]));
        }};

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            while (pq.peek().getKey() < i - k) { // We just compare the top node and see if it is outside of window or not.
                pq.poll();
            }

            max = nums[i] + pq.peek().getValue();
            pq.offer(new Pair<>(i, max));
        }

        return max;
    }

    // O(n)
    private int maxResultDQ(int[] nums, int k) {
        Deque<Pair<Integer, Integer>> deque = new LinkedList<>() {{
            offer(new Pair<>(0, nums[0]));
        }};
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst().getKey() < i - k) {
                deque.pollFirst();
            }

            max = nums[i] + (deque.isEmpty() ? 0 : deque.peekFirst().getValue());

            while (!deque.isEmpty() && deque.peekLast().getValue() <= max) {
                deque.pollLast();
            }

            deque.offerLast(new Pair<>(i, max));
        }

        return max;
    }
}