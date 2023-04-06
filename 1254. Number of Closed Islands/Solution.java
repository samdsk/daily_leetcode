import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // BFS
        // boolean[][] visit = new boolean[m][n];
        // int count = 0;

        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if(grid[i][j] == 0 && !visit[i][j] && bfs(i,j,m,n,grid,visit))
        //             count++;
        //     }
        // }

        // DFS with marking directly on grid the visited cell with "-1"
        for (int i = 0; i < m; i++) {
            dfs(grid,i,0,m,n);
            dfs(grid,i,n-1,m,n);
        }
        for (int i = 0; i < n; i++) {
            dfs(grid,0,i,m,n);
            dfs(grid,m-1,i,m,n);
        }

        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0){
                    islands++;
                    dfs(grid,i,j,m,n);
                }
            }
        }

        return islands;

    }
    private void dfs(int[][] grid, int r, int c,int m,int n) {
        if(r<0 || r>=m || c<0 || c>=n || grid[r][c] != 0) return;

        grid[r][c] = -1;

        dfs(grid,r+1,c,m,n);
        dfs(grid,r,c+1,m,n);
        dfs(grid,r-1,c,m,n);
        dfs(grid,r,c-1,m,n);
    }
    private boolean bfs(int x,int y,int m,int n,int[][] grid,boolean[][] visit){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visit[x][y] = true;

        boolean closed = true;

        int[] ax = {0,1,0,-1};
        int[] ay = {-1,0,1,0};

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            x = temp[0];
            y = temp[1];

            for (int i = 0; i < 4; i++) {
                int r = x + ax[i];
                int c = y + ay[i];

                if(r<0 || r>=m || c<0 || c>=n) closed = false;
                else if(grid[r][c] == 0 && !visit[r][c]){
                    q.offer(new int[]{r,c});
                    visit[r][c] = true;
                }
            }
        }

        return closed;
    }

}