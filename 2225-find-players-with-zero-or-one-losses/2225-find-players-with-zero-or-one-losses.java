class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, int[]> map = new HashMap<>();
        
        for (int[] match : matches) {
            if (!map.containsKey(match[0]))
                map.put(match[0], new int[2]);
            
            if (!map.containsKey(match[1]))
                map.put(match[1], new int[2]);
            
            int[] p1 = map.get(match[0]);
            int[] p2 = map.get(match[1]);
            
            p1[0]++; p2[1]++;
        }
        
        TreeSet<Integer> neverDefeated = new TreeSet<>();
        TreeSet<Integer> onceDefeated = new TreeSet<>();
        
        for (Integer player : map.keySet()) {
            int[] summery = map.get(player);
            
            if (summery[1] == 0)
                neverDefeated.add(player);
            else if (summery[1] == 1)
                onceDefeated.add(player);
        }
        
        return List.of(new ArrayList<>(neverDefeated), new ArrayList<>(onceDefeated));
    }
}