class Solution {
    public int minOperations(int n) {
        
        int steps = 0;
        while (n != 0) {
            // System.out.println(Integer.toBinaryString(n));
            if ((n & 1) == 1) {
                if ((n & 2) == 2) {
                    n += 1;
                }
                steps++;
            }
            n = n >> 1;
        }

        return steps;
    }
}