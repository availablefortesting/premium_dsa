class Solution {
    private int gcd(int a, int b) {
        return a != 0 ? gcd(b % a, a) : Math.abs(b);
    }
    public String fractionAddition(String exp) {
        StringBuilder curNum = new StringBuilder();

        int A = 0, B = 1;
        int a = 0, b = 1;
        
        for (char c : (exp + "+").toCharArray()) {
            if (c == '+' || c == '-') {
                if (curNum.length() > 0) {
                    b = Integer.parseInt(curNum.toString());

                    A = (B * a) + (A * b); B = B * b;

                    int g_c_d = gcd(A, B);
                    A /= g_c_d; B /= g_c_d;
                }
                
                curNum = new StringBuilder().append(c);
            } else if (c == '/') {
                a = Integer.parseInt(curNum.toString());
                curNum = new StringBuilder();
            } else {
                curNum.append(c);
            }
        }

        return A + "/" + B;
    }
}