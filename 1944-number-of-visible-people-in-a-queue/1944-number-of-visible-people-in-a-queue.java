class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        return canSeePersonsCount2(heights);

        // int n = heights.length;
        // Stack<Integer> monoDecreasing = new Stack<>();
        // int[] res = new int[n];

        // for (int i = 0; i < n; i++) {
        //     while (!monoDecreasing.isEmpty() && heights[monoDecreasing.peek()] <= heights[i])
        //         res[monoDecreasing.pop()]++;    // guy can see till only curr_i (which is tallest)

        //     // Now as curr_i will be smaller than stack.peek(), so peek can see curr_i
        //     if (!monoDecreasing.isEmpty())
        //         res[monoDecreasing.peek()]++;

        //     monoDecreasing.push(i);
        // }

        // return res;
    }

    public int[] canSeePersonsCount2(int[] heights) {
        int n = heights.length;
        int ans[] = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;

            // count and pop all the smaller person, compare to current
            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                count++;
                stack.pop();
            }

            // If someone taller exists → also visible
            if (!stack.isEmpty())   count++;

            ans[i] = count;
            stack.push(heights[i]);
        }

        return ans;
    }
}