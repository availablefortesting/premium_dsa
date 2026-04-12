class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Stack<Integer> monoDecreasing = new Stack<>();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            while (!monoDecreasing.isEmpty() && heights[monoDecreasing.peek()] <= heights[i])
                res[monoDecreasing.pop()]++;    // guy can see till only curr_i (which is tallest)

            // Now as curr_i will be smaller than stack.peek(), so peek can see curr_i
            if (!monoDecreasing.isEmpty())
                res[monoDecreasing.peek()]++;

            monoDecreasing.push(i);
        }

        return res;
    }
}