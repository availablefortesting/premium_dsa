class Solution {
    /*
        Two tasks: A and B with A > B (A takes longer)
        Two People: X and Y with X > Y. (X works faster)
        
        Logically, person X should take A and person Y should take B, with cost max(A/X, B/Y), but let's suppose it is NOT optimal,
        let's assume that it is more optimal for Y to take A and for X to take B, the cost for this is max(A/Y, B/X)
        Our goal is to prove that max(A/Y, B/X) < max(A/X, B/Y) is a contradiction.
        max(A/Y, B/X) = A/Y because A/Y > A/X > B/X.
        A/Y > B/Y because task A takes more time to do.
        A/Y > A/X because person X works faster.
        Hence, we deduce that A/Y > max(A/X, B/Y), but it is a contradiction.
    */
    
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int ans = 0;
        for (int i = 0; i < jobs.length; i++){
            ans = Math.max(--jobs[i]/workers[i]+1, ans);
        }
        return ans;
    }
}