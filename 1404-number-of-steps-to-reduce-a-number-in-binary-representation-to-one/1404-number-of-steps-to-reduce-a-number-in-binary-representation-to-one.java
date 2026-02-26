class Solution {
    public int numSteps(String s) {
        int carry = 0;
        int res = 0;
        
        for (int i = s.length() - 1; i >= 1; i--) {
            if (s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                res++;
            }
            res++;
        }
        return res + carry;
    }
}