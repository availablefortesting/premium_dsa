class Solution {
    public int pivotInteger(int n) {
        double pivot = Math.sqrt(n * (n + 1) / 2);
        if (pivot == (int) pivot)
            return (int) pivot;
        return -1;
    }
}