class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String> visited = new HashSet<>();
        visited.add("0,0");
        
        int[] cur_pos = new int[]{0,0};
        for (char c : path.toCharArray()) {
            if (c == 'N')   cur_pos[1] += 1;
            if (c == 'E')   cur_pos[0] += 1;
            if (c == 'S')   cur_pos[1] -= 1;
            if (c == 'W')   cur_pos[0] -= 1;
            
            String code = cur_pos[0]+","+cur_pos[1];
            if (visited.contains(code)) 
                return true;
            else
                visited.add(code);
        }
        
        return false;
    }
}