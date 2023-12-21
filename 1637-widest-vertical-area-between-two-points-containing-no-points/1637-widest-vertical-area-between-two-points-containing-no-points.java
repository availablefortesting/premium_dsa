class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        TreeSet<Integer> x_points = new TreeSet<>();
        
        for (int[] point : points) 
            x_points.add(point[0]);
            
        int widest_v_area = 0;
        int l = x_points.pollFirst(), r;
        while (!x_points.isEmpty()) {
            r = x_points.pollFirst();
            widest_v_area = Math.max(widest_v_area, r - l);
            
            l = r;
        }
        
        return widest_v_area;
    }
}