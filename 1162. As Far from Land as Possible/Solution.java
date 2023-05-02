class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        final int max = m+n+1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1) grid[i][j] = 0;
                else{
                    grid[i][j] = max;
                    int temp_top = max;
                    int temp_left = max;

                    if(i>0) temp_top = grid[i-1][j]+1;
                    if(j>0) temp_left = grid[i][j-1]+1;

                    grid[i][j] = Math.min(grid[i][j],Math.min(temp_left, temp_top));
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = m-1; i>=0; i--) {
            for (int j = n-1; j >=0; j--) {
                int temp_bottom = max;
                int temp_right = max;

                if(i<m-1) temp_bottom = grid[i+1][j]+1;
                if(j<n-1) temp_right = grid[i][j+1]+1;

                grid[i][j] = Math.min(grid[i][j], Math.min(temp_bottom, temp_right));

                ans = Math.max(ans,grid[i][j]);
            }
        }

        if(ans == 0 || ans == max) return -1;
        return ans;
    }
}