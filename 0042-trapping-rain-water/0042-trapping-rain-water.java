class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int trapped_water = 0;
        
        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[st.peek()] < height[i]) {
                int middle_idx = st.pop();
                
                if (st.isEmpty())
                    break;
                
                int w = i - st.peek() - 1;
                int h = Math.min(height[st.peek()], height[i]) - height[middle_idx];
                trapped_water += w * h;
            }
            
            st.push(i);
        }
        
        return trapped_water;
    }
}