class Solution {
    int island = 0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid2[i][j] == 1){
                    island = 1;
                    dfs(grid1, grid2, i, j, m, n);
                    count += island;
                }
            }
        }

        return count;

    }

    private void dfs(int[][] grid1,int[][] grid2, int r, int c,int m,int n){
        if(r<0||c<0||r>=m||c>=n||grid2[r][c] == 0) return;

        if(grid1[r][c] == 0) island = 0;
        grid2[r][c] = 0;

        dfs(grid1, grid2, r+1, c, m, n);
        dfs(grid1, grid2, r-1, c, m, n);
        dfs(grid1, grid2, r, c+1, m, n);
        dfs(grid1, grid2, r, c-1, m, n);
    }

}