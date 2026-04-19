import java.util.HashMap;
import java.util.Map;

class Solution {
    char[] chars;
    int n;
    Map<Integer, Integer> memo = new HashMap<>();

    public int numDecodings(String s) {
        this.chars = s.toCharArray();
        this.n = s.length();
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i > j) return 1;
        if (chars[i] == '0') return 0;
        if (i == j) return 1;

        int key = i * n + j;
        Integer cached = memo.get(key);
        if (cached != null) return cached;

        int res = 0;

        // take 1 digit
        res += dfs(i + 1, j);

        // take 2 digits if valid (10..26)
        int val = (chars[i] - '0') * 10 + (chars[i + 1] - '0');
        if (val >= 10 && val <= 26) {
            res += dfs(i + 2, j);
        }

        memo.put(key, res);
        return res;
    }
}