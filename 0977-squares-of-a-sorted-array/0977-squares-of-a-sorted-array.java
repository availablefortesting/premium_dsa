class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        int i = 0;
        while (i < n && nums[i] < 0)
            i++;
        
        int j = (i--);
        for (int idx = 0; idx < n; idx++) {
            if (i < 0)
                ans[idx] = (int)Math.pow(nums[j++], 2);
            else if (j >= n) 
                ans[idx] = (int)Math.pow(nums[i--], 2);
            else {
                if (Math.abs(nums[i]) < nums[j])
                    ans[idx] = (int)Math.pow(nums[i--], 2);
                else
                    ans[idx] = (int)Math.pow(nums[j++], 2);
            }
        }
        
        return ans;
    }
}