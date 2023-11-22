class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer,List<Integer>> m = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        int max_row_size = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.size(); i++) {
            int row_size = nums.get(i).size();
            max_row_size = Math.max(max_row_size, row_size);
            for (int j = 0; j < row_size; j++) {
                int diag = i + j;
                m.computeIfAbsent(diag, k -> new ArrayList<Integer>()).add(0, nums.get(i).get(j));
            }
        }
        
        for (int i = 0; i < (nums.size() + max_row_size); i++) {
            if (m.containsKey(i)) {
                res.addAll(m.get(i));
            }
        }
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}