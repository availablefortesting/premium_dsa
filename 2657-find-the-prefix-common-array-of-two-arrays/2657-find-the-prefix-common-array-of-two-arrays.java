class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> a = new HashSet<>(), b = new HashSet<>();
        int[] res = new int[A.length];

        if (A[0] == B[0]) res[0] = 1;
        a.add(A[0]); b.add(B[0]);

        for (int i = 1; i < A.length; i++) {
            a.add(A[i]); b.add(B[i]);

            res[i] = res[i-1];
            if (A[i] == B[i]) {
                res[i]++;
                continue;
            }

            if (a.contains(B[i]))   res[i]++;
            if (b.contains(A[i]))   res[i]++;
        }

        return res;
    }
}