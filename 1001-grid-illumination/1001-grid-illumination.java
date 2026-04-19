import java.util.*;

class Solution {

    // class attrs (so we don't pass many params)
    private int n;
    private Map<Integer, Integer> row, col, bDiag, fDiag;
    private Set<Long> grid; // active lamps: "r*n + c -- 2D -> 1D"

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        this.n = n;

        row = new HashMap<>();
        col = new HashMap<>();
        bDiag = new HashMap<>(); // r - c
        fDiag = new HashMap<>(); // r + c
        grid = new HashSet<>();

        // turn ON lamps (dedupe by grid set)
        for (int[] pos : lamps) {
            int r = pos[0], c = pos[1];
            if (grid.add(key(r, c)))  turnOn(r, c);
        }

        int[] res = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int r = queries[q][0], c = queries[q][1];

            boolean islluminated =
                    row.getOrDefault(r, 0) > 0 ||
                    col.getOrDefault(c, 0) > 0 ||
                    bDiag.getOrDefault(r - c, 0) > 0 ||
                    fDiag.getOrDefault(r + c, 0) > 0;

            res[q] = islluminated ? 1 : 0;

            // turn OFF lamps in 3x3 around (r,c)
            for (int t = 0; t < 9; t++) {
                int i = (r - 1) + (t / 3);
                int j = (c - 1) + (t % 3);

                if (i < 0 || i >= n || j < 0 || j >= n) continue;

                if (grid.remove(key(i, j))) turnOff(i, j);
            }
        }

        return res;
    }

    private void turnOn(int r, int c) {
        row.merge(r, 1, Integer::sum);  col.merge(c, 1, Integer::sum);
        bDiag.merge(r - c, 1, Integer::sum); fDiag.merge(r + c, 1, Integer::sum);
    }

    private void turnOff(int r, int c) {
        dec(row, r); dec(col, c);
        dec(bDiag, r - c); dec(fDiag, r + c);
    }

    private void dec(Map<Integer, Integer> map, int key) {
        map.merge(key, -1, Integer::sum);
        if (map.get(key) == 0) map.remove(key);
    }

    // basic key -- not efficient
    // private String key(int r, int c) {
    //     return r + "#" + c;
    // }

    private long key(int r, int c) {
        return ((long) r) * n + c;
    }

    // Memory efficient version to store key r,c - 32bit each, so can use long(64bit)
    // private long key(int r, int c) {
    //     return (((long) r) << 32) | (c & 0xffffffffL);
    // }
}