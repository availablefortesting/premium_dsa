class Solution {
    private int binLeft(int[] nums, int target) {
        int l = 0, r = nums.length;
        
        while (l < r) {
            int mid = l + (r-l)/2;
            
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        
        return l;
    }
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) {
            res.add(Arrays.asList(lower, upper));
            return res;
        }
        
        int i = binLeft(nums, lower);
        
        if (lower < nums[i])
            res.add(Arrays.asList(lower, nums[i]-1));
        
        while (i < n) {
            if (i+1 < n && nums[i] + 1 != nums[i+1])
                res.add(Arrays.asList(nums[i] + 1, nums[i+1] - 1));
            
            ++i;
        }
        
        if (i-1 >= 0 && nums[i-1] != upper)
            res.add(Arrays.asList(nums[i-1] + 1, upper));
        
        return res;
    }
}