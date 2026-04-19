class Solution {
    char[] chars;

    public int numDecodings(String s) {
        this.chars = s.toCharArray();
        return dfs(0, s.length() - 1);
    }

    private int dfs(int i, int j) {
        if (i > j) return 1; // decoded everything
        if (chars[i] == '0') return 0; // can't start with 0
        if (i == j) return 1; // single non-zero char

        int res = 0;

        // take 1 digit
        res += dfs(i + 1, j);

        // take 2 digits if valid (10..26)
        int val = (chars[i] - '0') * 10 + (chars[i + 1] - '0');
        if (val >= 10 && val <= 26) {
            res += dfs(i + 2, j);
        }

        return res;
    }
}