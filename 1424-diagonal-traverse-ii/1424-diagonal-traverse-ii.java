class Solution {
    private int[] usingQueue(List<List<Integer>> nums) {
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.offer(new Pair(0,0));
        
        ArrayList<Integer> res = new ArrayList<>();
        
        while (!q.isEmpty()) {
            var pos = q.poll();
            int row = pos.getKey();
            int col = pos.getValue();
            res.add(nums.get(row).get(col));
            
            if (col == 0 && row + 1 < nums.size()) {
                q.offer(new Pair(row+1, col));
            }
            
            if (col + 1 < nums.get(row).size()) {
                q.offer(new Pair(row, col + 1));
            }
        }
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int[] usingHashMap(List<List<Integer>> nums) {
        HashMap<Integer,List<Integer>> m = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int diag = i + j;
                m.computeIfAbsent(diag, k -> new ArrayList<Integer>()).add(0, nums.get(i).get(j));
            }
        }
        
        int cur_diag = 0;
        while (m.containsKey(cur_diag)) {
            if (m.containsKey(cur_diag)) {
                res.addAll(m.get(cur_diag));
            }
            cur_diag++;
        }
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // return usingHashMap(nums);
        return usingQueue(nums);
    }
}