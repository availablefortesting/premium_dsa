class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        int res = 0, i = 1;
        while (n != 0) {
            if ((n & 1) == 0) res += i;
            n = n >> 1;
            i = i << 1;
        }
        return res;
    }
}