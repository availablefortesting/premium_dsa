class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        if (n == 1) return adjacentPairs[0];

        HashSet<Integer> endPoints = new HashSet<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] adj : adjacentPairs) {
            if (endPoints.contains(adj[0])) endPoints.remove(adj[0]);
            else                             endPoints.add(adj[0]);

            if (endPoints.contains(adj[1])) endPoints.remove(adj[1]);
            else                             endPoints.add(adj[1]);

            map.computeIfAbsent(adj[0], k -> new ArrayList<Integer>()).add(adj[1]);
            map.computeIfAbsent(adj[1], k -> new ArrayList<Integer>()).add(adj[0]);
        }

        int[] res = new int[n+1];
        var it = endPoints.iterator();
        res[0] = it.next(); res[n] = it.next();
        res[1] = map.get(res[0]).get(0);

        for (int i = 2; i < n; i++) {
            var a = map.get(res[i-1]);
            res[i] = a.get(0) == res[i-2] ? a.get(1) : a.get(0);
        }
        return res;
    }
}