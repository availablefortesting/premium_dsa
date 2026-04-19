class Solution {
    public int lengthOfLongestSubstring(String s) {
        // GENERIC solution for at most k repeating chars
        int[] freq = new int[256];
        char[] chars = s.toCharArray();
        int res = 0, k = 2, bad = 0; // with at most 1 repeating char -> k = at most + 1

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            if (++freq[chars[r]] == k) bad++;

            while (bad > 0)
                if (freq[chars[l++]]-- == k) bad--;

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}