class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int ans1 = 0, ans2 = 0;
        int ans = n;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = s.charAt(i) - '0';

        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 != arr[i % n])        ans1++;
            if ((i + 1) % 2 != arr[i % n])  ans2++;

            if (i >= n) {
                if ((i - n) % 2 != arr[i - n])      ans1--;
                if ((i - n + 1) % 2 != arr[i - n])  ans2--;
            }

            if (i >= n - 1) ans = Math.min(ans, Math.min(ans1, ans2));
        }
        return ans;
    }
}