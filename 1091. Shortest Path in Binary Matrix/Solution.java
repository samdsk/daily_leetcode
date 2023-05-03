import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;

        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        int ans = 0;

        while(!q.isEmpty()){
            int size = q.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                if(cur[0] == m-1 && cur[1] == n-1) return ans;

                for(int[] direction : directions){
                    int x = cur[0]+direction[0];
                    int y = cur[1]+direction[1];
                    if(
                        x < 0   ||
                        x >= m  ||
                        y < 0   ||
                        y >= n  ||
                        visited[x][y] ||
                        grid[x][y] == 1) continue;

                    visited[x][y] = true;
                    q.offer(new int[]{x,y});
                }
            }
        }

        return -1;
    }
}