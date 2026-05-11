class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int num : nums) 
            for (char c : String.valueOf(num).toCharArray()) 
                res.add(c - '0');

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}