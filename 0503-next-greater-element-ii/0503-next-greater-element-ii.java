class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n])
                ans[stack.pop()] = nums[i % n];

            if (i < n)  stack.push(i);
        }
        return ans;
    }
}