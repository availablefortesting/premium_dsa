class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0 ; i < n ; i++) {
            res[i] = 1;
        }
        
        int preMulLeft = 1;
        int preMulRight = 1;
        for ( int i = 1; i < n; i++ ) {
            preMulLeft = preMulLeft * nums[i-1];
            res[i] *= preMulLeft;
            
            preMulRight = preMulRight * nums[n - i];
            res[n - i - 1] *= preMulRight;
        }
        
        return res;
    }
}