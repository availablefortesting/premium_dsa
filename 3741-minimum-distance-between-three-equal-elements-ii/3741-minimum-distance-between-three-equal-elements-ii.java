class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int res = Integer.MAX_VALUE, n = nums.length;

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            int[] last = map.get(num);
            if (last == null) {
                // first occurrence
                map.put(num, new int[]{i, -1});
            } else if (last[1] == -1) {
                // second occurrence
                last[1] = i;
            } else {
                // we have at least 2 previous indices
                int minDist = i - last[0];
                res = Math.min(res, 2 * minDist);

                // shift indices: keep last two
                last[0] = last[1];
                last[1] = i;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}