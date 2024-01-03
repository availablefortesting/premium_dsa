class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        
        Arrays.sort(nums);        
        List<List<Integer>> finalResult = new ArrayList<>();
        backtrack(nums, finalResult, new ArrayList<>(), new boolean[nums.length]); 
        return finalResult;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> finalResult, List<Integer> currResult, boolean[] used) {
        if (currResult.size() == nums.length) {
            finalResult.add(new ArrayList<>(currResult));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i-1] == nums[i] && !used[i-1])    continue;
            
            currResult.add(nums[i]);
            used[i] = true;
            
            backtrack(nums, finalResult, currResult, used);
            
            used[i] = false;
            currResult.remove(currResult.size() - 1);
        }
    }

}