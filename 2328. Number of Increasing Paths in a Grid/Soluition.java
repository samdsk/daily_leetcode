import java.util.Arrays;

class Solution {
    private final int mod = 1_000_000_007;
    private final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        Arrays.stream(dp).forEach(row -> Arrays.fill(row,1));

        int[][] cells = new int[m*n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                cells[idx][0] = i;
                cells[idx][1] = j;
            }
        }

        Arrays.sort(cells,(a,b)-> grid[a[0]][a[1]] - grid[b[0]][b[1]]);

        for (int[] cell : cells){
            int i = cell[0];
            int j = cell[1];

            for(int[] direction : directions){
                int curri = i + direction[0];
                int currj = j + direction[1];

                if(0 <= curri && curri < m && 0 <= currj && currj < n){
                    if(grid[curri][currj] > grid[i][j]){
                        dp[curri][currj] += dp[i][j];
                        dp[curri][currj] %= mod;
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += dp[i][j];
                ans %= mod;
            }
        }

        return ans;
    }
}