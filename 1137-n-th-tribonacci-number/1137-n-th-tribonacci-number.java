class Solution {
    public int tribonacci(int n) {
        if (n == 0)     return 0;
        else if (n == 1 || n == 2)  return 1;
        else {
            n = n - 2;
            int a = 0, b = 1, c = 1;
            int ans = 0;
            while (n != 0){
                ans = (a + b + c);
                a = b;
                b = c;
                c = ans;
                n--;
            }
            return ans;
        }
    }
}