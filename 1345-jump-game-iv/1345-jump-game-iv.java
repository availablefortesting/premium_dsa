class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length, steps = 0, breadth = 0;
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++)  map.computeIfAbsent(arr[i], k -> new ArrayList<Integer>()).add(i);
        q.offer(0);

        while (!q.isEmpty()) {
            breadth = q.size();

            while (breadth-- != 0) {
                int cur = q.poll();

                if (cur == n-1) return steps;
                vis[cur] = true;

                if (cur + 1 < n && !vis[cur + 1])   q.offer(cur + 1);
                if (cur - 1 >= 0 && !vis[cur - 1])   q.offer(cur - 1);
                 if (map.containsKey(arr[cur])) {
                    for (int j : map.get(arr[cur])) {
                        if (cur == j) continue;
                        if (!vis[j])    q.offer(j);
                    }
                    map.remove(arr[cur]);
                }
            }
            steps++;
        }

        return -1;
    }
}