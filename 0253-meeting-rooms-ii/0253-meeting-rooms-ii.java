class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int meetings = intervals.length;
        int[] starts = new int[meetings];
        int[] ends = new int[meetings];
        
        for (int  i = 0; i < meetings; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(starts);    Arrays.sort(ends);
        
        int i = 0, j = 0;
        int cur_m = 0, max_m = 0;
        
        while (i < meetings && j < meetings) {
            if (starts[i] < ends[j]) {
                ++cur_m;
                max_m = Math.max(max_m, cur_m);
                
                ++i;
            } else {
                --cur_m;
                
                ++j;
            }
        }
        
        return max_m;
    }
}