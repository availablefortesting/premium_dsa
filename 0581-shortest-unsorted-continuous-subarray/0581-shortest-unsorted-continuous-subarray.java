class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // FOR EASIER APPROACH WITH MORE FOR LOOPS, LOOK PREVIOUS SUBMISSION
        if (nums.length < 2) return 0;

        int r = -1, l = -1, n = nums.length;
        int maxSeen = nums[0], minSeen = nums[n-1];

        for (int i = 1; i < n; i++) {
            // left -> right
            if (maxSeen > nums[i])  r = i;
            else                    maxSeen = nums[i];

            // right -> left
            if (minSeen < nums[n - i - 1]) l = n - i - 1;
            else                           minSeen = nums[n - i - 1];
        }

        return (r == -1) ? 0 : r - l + 1;
    }
}