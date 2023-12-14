class Solution {
    public int minimumOperations(int[] nums) {
        int l = 0, r = nums.length - 1;
        int merge_op = 0;
        
        while (l < r) {
            if (nums[l] == nums[r]){
                l++; r--;
            } else {
                if (nums[l] < nums[r]) {
                    ++l;
                    nums[l] += nums[l-1]; 
                } else {
                    --r;
                    nums[r] += nums[r+1];
                }
                merge_op++;
            }
        }
        
        return merge_op;
    }
}