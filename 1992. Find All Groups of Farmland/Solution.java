class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        List<int[]> results = new ArrayList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (land[r][c] == 1) {
                    int[] temp = helper(land, r, c, m, n, new int[] { r, c, r, c });
                    results.add(temp);
                }
            }
        }

        int[][] ans = new int[results.size()][4];

        for (int i = 0; i < results.size(); i++) {
            ans[i] = results.get(i);
        }

        return ans;
    }

    public int[] helper(int[][] land, int r, int c, int ROWS, int COLS, int[] acc) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || land[r][c] <= 0)
            return acc;

        land[r][c] = -1;

        acc[2] = Math.max(r, acc[2]);
        acc[3] = Math.max(c, acc[3]);

        helper(land, r + 1, c, ROWS, COLS, acc);
        helper(land, r, c + 1, ROWS, COLS, acc);

        return acc;
    }
}