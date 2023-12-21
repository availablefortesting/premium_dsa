class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        
        // y-coordinate of a point does not matter in width
        int x_points[] = new int[n];
        for(int i=0; i < n; i++){
            x_points[i] = points[i][0];
        }
        Arrays.sort(x_points);
        
        int diff = Integer.MIN_VALUE;
        for(int i=1; i < n; i++){
            if((x_points[i] - x_points[i-1]) > diff)
                diff = x_points[i] - x_points[i-1];
        }
        
        return diff;
    }
}