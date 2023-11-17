class Solution {
    private boolean recursive(String s, int cur, int open_cnt) {
        if (open_cnt < 0)
            return false;
        
        for (int i = cur; i < s.length(); i++) {
            char cur_c = s.charAt(i);
            
            if (cur_c == '(')
                open_cnt++;
            else if (cur_c == ')') {
                if (open_cnt <= 0)
                    return false;
                open_cnt--;
            } else {
                return recursive(s, i+1, open_cnt + 1) ||
                        recursive(s, i+1, open_cnt - 1) ||
                        recursive(s, i+1, open_cnt);
            }
        }
        
        return open_cnt == 0;
    }
    
    private boolean efficient(String s) {
        int open_max = 0, open_req = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char cur_c = s.charAt(i);
            
            if (cur_c == '('){
                open_max++; open_req++;
            } else if (cur_c == ')') {
                open_max--;
                open_req = Math.max(open_req - 1, 0);
            } else {
                open_max++;
                open_req = Math.max(open_req - 1, 0);
            }
            
            if (open_max < 0)
                return false;
        }
        
        return open_req == 0;
    }
    
    public boolean checkValidString(String s) {
        /*
            Microsoft - 2 | ServiceNow - 2
        */
        // return recursive(s, 0, 0);  // will give TLE 'cause it's O(3^n) - use memoization
        return efficient(s);
    }
}