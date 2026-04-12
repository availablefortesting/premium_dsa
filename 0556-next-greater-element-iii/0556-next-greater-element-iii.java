class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();

        int i = digits.length - 2;

        // find first decreasing digit 
        while (i >= 0 && digits[i] >= digits[i + 1]) i--;
        if (i < 0) return -1;

        // swap with the smallest greater digit to the right
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) j--;

        swap(digits, i, j);
        reverse(digits, i + 1, digits.length - 1);

        long result = Long.parseLong(new String(digits));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }

    private void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    private void reverse(char[] digits, int l, int r) {
        while (l < r)   swap(digits, l++, r--);
    }
}