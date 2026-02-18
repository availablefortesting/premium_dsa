class Solution {
    public boolean hasAlternatingBits(int n) {
        String binN = Integer.toBinaryString(n);
        return !(binN.contains("11") || binN.contains("00"));
    }
}