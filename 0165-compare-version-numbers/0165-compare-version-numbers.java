class Solution {
    public int compareVersion(String version1, String version2) {
        String[] p1 = version1.split("\\.");
        String[] p2 = version2.split("\\.");

        int i = 0, j = 0, v1, v2;
        while (i < p1.length || j < p2.length) {
            v1 = (i < p1.length) ? Integer.parseInt(p1[i]) : 0;
            v2 = (j < p2.length) ? Integer.parseInt(p2[j]) : 0;

            if (v1 > v2) return 1;
            if (v1 < v2) return -1;

            i++; j++;
        }
        return 0;
    }
}