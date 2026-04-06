class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);

        if (a > 0) pq.add(new int[]{a, 'a'});
        if (b > 0) pq.add(new int[]{b, 'b'});

        while (!pq.isEmpty()) {

            int[] first = pq.poll();
            int len = sb.length();

            // If last two chars same as current → cannot use
            if (len >= 2 &&
                sb.charAt(len - 1) == first[1] &&
                sb.charAt(len - 2) == first[1]) {

                if (pq.isEmpty()) break;

                int[] second = pq.poll();
                sb.append((char) second[1]);
                second[0]--;

                if (second[0] > 0) pq.add(second);
                pq.add(first); // put first back
            } else {
                sb.append((char) first[1]);
                first[0]--;
                if (first[0] > 0) pq.add(first);
            }
        }

        return sb.toString();
    }
}

