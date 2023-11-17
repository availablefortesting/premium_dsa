class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1,i2) -> Integer.compare(i1[0], i2[0]));
        
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int[] prevInterval = intervals[0];
        
        for (int[] c_interval : intervals) {
            if (c_interval[0] <= prevInterval[1]) {
                prevInterval[1] = Math.max(prevInterval[1], c_interval[1]);
            } else {
                prevInterval = c_interval;
                res.add(prevInterval);
            }
        }
        
        return res.toArray(int[][]::new);
    }
}