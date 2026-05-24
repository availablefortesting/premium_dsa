class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (arr[cur] == 0)  return true;

            vis[cur] = true;
            if (cur + arr[cur] < n && !vis[cur + arr[cur]])             
                q.offer(cur+arr[cur]);
            if (cur - arr[cur] >= 0 && !vis[cur - arr[cur]])  
                q.offer(cur-arr[cur]);
        }

        return false;
    }
}