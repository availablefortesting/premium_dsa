class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<Integer>()).add(i);
        }

        int res = Integer.MAX_VALUE;
        for (List<Integer> idxs : map.values()) {
            if (idxs.size() >= 3) {
                int minDist = n;
                for (int i = 2; i < idxs.size(); i++) {
                    minDist = Math.min(minDist, idxs.get(i) - idxs.get(i-2));
                }
                res = Math.min(res, 2 * minDist);
            }
        }

        return res == Integer.MAX_VALUE? -1 : res;
    }
}