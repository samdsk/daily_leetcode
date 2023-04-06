import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && !visit[i][j] && bfs(i,j,m,n,grid,visit))
                    count++;
            }
        }
        return count;
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