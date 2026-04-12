class Solution {
    Map<Character,int[]> pos;
    int n;
    String word;
    Integer[][][] dp;

    public int minimumDistance(String word) {
        this.n = word.length();
        this.word = word;

        pos = new HashMap<>();
        pos.put('#', new int[]{-1, -1});

        int cnt = 26;
        char curr = 'A';

        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                if (cnt-- > 0)
                    pos.put(curr++, new int[]{i, j});

        dp = new Integer[27][27][n]; 
        return helper('#', '#', 0);
    }

    private int helper(char i, char j, int k) {
        if (k == n) return 0;

        int idxI = (i == '#') ? 26 : i - 'A';
        int idxJ = (j == '#') ? 26 : j - 'A';

        if (dp[idxI][idxJ][k] != null)  return dp[idxI][idxJ][k];

        char curr = word.charAt(k);
        int distI = distance(i, curr), distJ = distance(j, curr);

        int res = Math.min(
            distI + helper(curr, j, k + 1),
            distJ + helper(i, curr, k + 1)
        );

        return dp[idxI][idxJ][k] = res;
    }

    private int distance(char a, char b) {
        if (a == '#') return 0;

        int[] p1 = pos.get(a), p2 = pos.get(b);
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}