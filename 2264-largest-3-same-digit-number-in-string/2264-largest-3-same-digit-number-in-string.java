class Solution {
    public String largestGoodInteger(String num) {
        char[] char_arr = num.toCharArray();
        int max_num = Integer.MIN_VALUE;
        
        for (int i = 0; i <= num.length() - 3; i++) {
            if (char_arr[i] == char_arr[i+1] && char_arr[i+1] == char_arr[i+2]) {
                int temp = Integer.parseInt(""+char_arr[i]+char_arr[i]+char_arr[i]);
                
                max_num = Math.max(max_num, temp);
            }
        }
        
        if (max_num == 0) {
            return "000";
        }
        return max_num != Integer.MIN_VALUE ? String.valueOf(max_num) : "";
    }
}