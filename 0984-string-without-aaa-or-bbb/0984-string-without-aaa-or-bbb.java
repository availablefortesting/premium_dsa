class Solution {
    public String strWithout3a3b(int a, int b) {
        return helper(a, b, "a", "b");
    }

    public static String helper(int a, int b, String aa, String bb) {
        if (a < b)
            return helper(b, a, bb, aa);
        
        if (b == 0)
            return aa.repeat(Math.min(2, a));
        
        int use_a = Math.min(2, a);
        use_a = a - use_a >= b ? use_a : 1;

        return aa.repeat(use_a) + bb + helper(a - use_a, b - 1, aa, bb);
    }
}