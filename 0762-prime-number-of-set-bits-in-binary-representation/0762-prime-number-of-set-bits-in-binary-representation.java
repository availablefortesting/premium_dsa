class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        while (left <= right)
            // 665772 is mask of prime number containing as setbits 
            count += 665772 >> Integer.bitCount(left++) & 1;
        return count;
    }
}