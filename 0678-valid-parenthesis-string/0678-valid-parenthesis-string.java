class Solution {
    public boolean checkValidString(String s) {
        int max_open_cnt = 0, req_open_cnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                max_open_cnt++;
                req_open_cnt++;
            } else if (s.charAt(i) == ')') {
                max_open_cnt--;
                req_open_cnt--;
            } else {
                max_open_cnt++; // '*' => '('
                req_open_cnt--; // '*' => ')'
            }
            
            // too many close ')' parenthesis there
            if (max_open_cnt < 0)   return false;
            
            // if req_open_cnt is neg, means more ')' than '('
            //      which is not required, so don't add more ('*' => '')
            req_open_cnt = Math.max(req_open_cnt, 0);
        }
        
        return req_open_cnt == 0;
    }
}