class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++)
            map.computeIfAbsent(nums[i], k -> new ArrayList<Integer>()).add(i);

        for (List<Integer> arr : map.values()) {
            int m = arr.size();
            if (m == 1) {
                nums[arr.get(0)] = -1;
                continue;
            }

            for (int i = 0; i < m; i++) {
                int j = arr.get(i);
                int f = arr.get((i + 1) % m), b = arr.get((i - 1 + m) % m);

                int forward = Math.min(n - (j - f), Math.abs(j - f));
                int backward = Math.min(Math.abs(b - j), n - (b - j));
                nums[j] = Math.min(backward, forward);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int q : queries)   res.add(nums[q]);
        
        return res;
    }
}