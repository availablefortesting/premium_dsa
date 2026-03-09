class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans= new StringBuilder();                  
        for(int i=0; i<nums.length; i++)  
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0');
        return ans.toString();

        // int n = nums.length;
        // String res = "0".repeat(n);
        // Set<Integer> nums_set = new HashSet<>();
        // for (String num : nums) nums_set.add(Integer.parseInt(num, 2));
        
        // if (!nums_set.contains(0))    return res;
        // for (int i = (int)Math.pow(2, n - 1); i < (int)Math.pow(2, n); i++) {
        //     if (!nums_set.contains(i)) {
        //         return Integer.toBinaryString(i);
        //     }
        // }
        // return res;       
    }
}