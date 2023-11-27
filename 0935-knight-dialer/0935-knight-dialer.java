class Solution {
    static HashMap<Integer, List<Integer>> m;
    int MOD = (int) 1e9 + 7;
    
    private static void prefillData() {
        m = new HashMap<>();
        
        m.put(0, Arrays.asList(4,6)); m.put(1, Arrays.asList(6,8));
        m.put(2, Arrays.asList(7,9)); m.put(3, Arrays.asList(4,8));
        m.put(4, Arrays.asList(0,3,9)); m.put(5, Collections.EMPTY_LIST);
        m.put(6, Arrays.asList(0,1,7)); m.put(7, Arrays.asList(2,6));
        m.put(8, Arrays.asList(1,3)); m.put(9, Arrays.asList(2,4));
    }
    
    public int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }
        prefillData();
        
        int[] prev = new int[10];
        Arrays.fill(prev, 1);
        
        while (n != 1) {
            int[] cur = new int[10];
            
            for (int i = 0; i<10; i++) {
                for (Integer next_pos : m.get(i)) {
                    cur[next_pos] = (cur[next_pos] + prev[i]) % MOD; 
                }
            }
            
            prev = cur;
            n--;
        }
        
        int res = 0;
        for (int num : prev)
            res = (res + num) % MOD;
        
        return res;
    }
}