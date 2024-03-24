class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        
        for (int i = 0; i < n; i++)
            if (nums[i] != i + 1)
                return nums[i];
        
        return -1;
    }
}