class Solution {
    public String findDifferentBinaryString(String[] nums) {
        /*
            Facebook - 2
        */
        
        HashSet<Integer> uniques = new HashSet<>();
        
        for (String num : nums) {
            uniques.add(Integer.parseInt(num, 2));
        }
        
        int n = nums[0].length();
        String cover = "";
        for (int i = 0; i < n; i++)
            cover += "0";
        
        System.out.println(uniques);
        for (int i = 0; i < Math.pow(2, n); i++) {
            if (!uniques.contains(i)) {
                String res = Integer.toBinaryString(i);
                return cover.substring(res.length()) + res;
            }
        }
        
        return "";
    }
}