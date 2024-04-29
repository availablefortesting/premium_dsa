class Solution {
    public int minOperations(int[] nums, int k) {
        int bit_xor = 0;
        for (int num : nums)    bit_xor ^= num;
        
        int bit_flip_required = 0;
        while (bit_xor > 0 || k > 0) {
            if ((bit_xor & 1) != (k & 1))   bit_flip_required++;
            bit_xor >>= 1;  k >>= 1; 
        }
        
        return bit_flip_required;
    }
}