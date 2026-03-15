class Solution {
    private int kCount;
    private String result = "";

    public String getHappyString(int n, int k) {
        this.kCount = k;
        helper(n, new StringBuilder());
        return result;
    }

    private boolean helper(int n, StringBuilder currentStr) {
        if (currentStr.length() == n) {
            kCount--;
            if (kCount == 0) {
                result = currentStr.toString();
                return true;
            }
            return false;
        }

        for (char c = 'a'; c <= 'c'; c++) {
            // Check if it's the first character OR different from the previous one
            if (currentStr.length() == 0 || currentStr.charAt(currentStr.length() - 1) != c) {
                currentStr.append(c);
                if (helper(n, currentStr)) return true;
                currentStr.deleteCharAt(currentStr.length() - 1);
            }
        }
        return false;
    }
}