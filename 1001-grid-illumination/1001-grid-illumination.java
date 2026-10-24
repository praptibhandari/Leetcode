class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
       Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> cols = new HashMap<>();
        Map<Integer, Integer> diag1 = new HashMap<>();
        Map<Integer, Integer> diag2 = new HashMap<>();

        Set<Long> active = new HashSet<>();

        for (int[] lamp : lamps) {
            int r = lamp[0], c = lamp[1];
            long key = (long) r * n + c;

            if (active.add(key)) {
                rows.put(r, rows.getOrDefault(r, 0) + 1);
                cols.put(c, cols.getOrDefault(c, 0) + 1);
                diag1.put(r - c, diag1.getOrDefault(r - c, 0) + 1);
                diag2.put(r + c, diag2.getOrDefault(r + c, 0) + 1);
            }
        }

        int[] ans = new int[queries.length];
        int idx = 0;

        for (int[] q : queries) {
            int r = q[0], c = q[1];

            if (rows.getOrDefault(r, 0) > 0 ||
                cols.getOrDefault(c, 0) > 0 ||
                diag1.getOrDefault(r - c, 0) > 0 ||
                diag2.getOrDefault(r + c, 0) > 0) {
                ans[idx] = 1;
            }

            idx++;

            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    int nr = r + dr, nc = c + dc;

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                        continue;

                    long key = (long) nr * n + nc;

                    if (active.remove(key)) {
                        rows.put(nr, rows.get(nr) - 1);
                        cols.put(nc, cols.get(nc) - 1);
                        diag1.put(nr - nc, diag1.get(nr - nc) - 1);
                        diag2.put(nr + nc, diag2.get(nr + nc) - 1);
                    }
                }
            }
        }

        return ans;
    }
}