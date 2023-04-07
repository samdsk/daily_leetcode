class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            if((grid[i][0] == 1 && !visit[i][0]) || (grid[i][n-1] == 1 &&  !visit[i][n-1])){
                dfs(grid,i,0,m,n,visit);
                dfs(grid,i,n-1,m,n,visit);
            }
        }

        for (int i = 0; i < n; i++) {
            if((grid[0][i] == 1 && !visit[0][i]) || (grid[m-1][i] == 1 &&  !visit[m-1][i])){
                dfs(grid,0,i,m,n,visit);
                dfs(grid,m-1,i,m,n,visit);
            }
        }

        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visit[i][j]){
                    islands++;
                }
            }
        }

        return islands;


    }

    private void dfs(int[][] grid, int r, int c,int m,int n,boolean[][] visit){
        if(r<0 || r>=m || c<0 || c>=n || grid[r][c] == 0 || visit[r][c]) return;

        visit[r][c] = true;

        dfs(grid,r+1,c,m,n,visit);
        dfs(grid,r-1,c,m,n,visit);
        dfs(grid,r,c-1,m,n,visit);
        dfs(grid,r,c+1,m,n,visit);

    }
}