class Solution {
    public String reorganizeString(String s) {
        // Step 1: Frequency count
        int[] freq = new int[26];
        int n = s.length();
        
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
            if(freq[c - 'a'] > (n + 1) / 2) return "";
        }

        // Step 2: Max Heap (frequency, character)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < 26; i++)
            if(freq[i] > 0)
                pq.add(new int[]{freq[i], i});

        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
            int[] temp1 = pq.poll();

            // Conflict case
            if(res.length() > 0 && res.charAt(res.length() - 1) == (char)(temp1[1] + 'a')){
                int[] temp2 = pq.poll();
                res.append((char)(temp2[1] + 'a'));

                if(temp2[0] - 1 > 0)    pq.add(new int[]{temp2[0] - 1, temp2[1]});
                pq.add(temp1);
            }
            else{
                res.append((char)(temp1[1] + 'a'));
                if(temp1[0] - 1 > 0)   pq.add(new int[]{temp1[0] - 1, temp1[1]});
            }
        }

        return res.toString();
    }
}