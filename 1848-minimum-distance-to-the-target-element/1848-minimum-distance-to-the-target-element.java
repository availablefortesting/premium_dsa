class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        if (nums[start] == target)  return 0;

        int i = start - 1, j = start + 1, n = nums.length;
        while (i >= 0 || j < n) {
            if (i >= 0 && nums[i] == target) return start - i;
            else if (j < n && nums[j] == target)    return j - start;
            else {
                i -= 1;
                j += 1;
            }
        }

        return -1;
    }
}