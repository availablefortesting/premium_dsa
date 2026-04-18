class Solution {
    // This soluition with pruning, for easy one see previous submissions
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        int[] path = new int[4];              // fixed buffer for current combination
        kSum(nums, 0, 4, (long) target, 0, path, res);
        return res;
    }

    private void kSum(int[] nums, int start, int k, long target, int depth, int[] path, List<List<Integer>> res) {
        int n = nums.length;

        // Not enough numbers left
        if (n - start < k) return;

        // Global pruning using min/max possible sums with k numbers from this start
        long minSum = 0, maxSum = 0;
        for (int i = 0; i < k; i++) {
            minSum += nums[start + i];
            maxSum += nums[n - 1 - i];
        }
        if (target < minSum || target > maxSum) return;

        if (k == 2) {
            twoSum(nums, start, target, depth, path, res);
            return;
        }

        for (int i = start; i <= n - k; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            long currentNum = nums[i];
            long localMin = currentNum, localMax = currentNum;

            // Per-i pruning:
            // smallest possible sum if we take nums[i] + next (k-1) smallest
            for (int j = 1; j < k; j++) localMin += nums[i + j];
            if (target < localMin) break; // increasing i will only increase localMin

            // largest possible sum if we take nums[i] + (k-1) largest
            for (int j = 1; j < k; j++) localMax += nums[n - j];
            if (localMax < target) continue; // too small, try bigger i

            path[depth] = nums[i];
            kSum(nums, i + 1, k - 1, target - currentNum, depth + 1, path, res);
        }
    }

    private void twoSum(int[] nums, int start, long target, int depth, int[] path, List<List<Integer>> res) {
        int l = start, r = nums.length - 1;

        while (l < r) {
            long sum = (long) nums[l] + nums[r];
            if (sum == target) {
                path[depth] = nums[l];
                path[depth + 1] = nums[r];

                // Only allocate when we have a full solution
                res.add(Arrays.asList(path[0], path[1], path[2], path[3]));

                int leftVal = nums[l], rightVal = nums[r];
                while (l < r && nums[l] == leftVal) l++;
                while (l < r && nums[r] == rightVal) r--;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
    }
}