import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean pacific[][] = new boolean[m][n];
        boolean atlantic[][] = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            dfs(heights, 0, i, m, n, heights[0][i],pacific);
            dfs(heights, m-1, i, m, n, heights[m-1][i],atlantic);
        }

        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, m, n, heights[i][0],pacific);
            dfs(heights, i, n-1, m, n, heights[i][n-1],atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) ans.add(Arrays.asList(i,j));
            }
        }

        return ans;
    }

    private void dfs(int[][] grid, int r,int c,int m,int n, int prev,boolean visited[][]){
        if(
            r<0||
            c<0||
            r>=m||
            c>=n||
            visited[r][c]||
            prev>grid[r][c]
        ) return;


        visited[r][c] = true;

        dfs(grid, r+1, c, m, n, grid[r][c],visited);
        dfs(grid, r, c+1, m, n, grid[r][c],visited);
        dfs(grid, r-1, c, m, n, grid[r][c],visited);
        dfs(grid, r, c-1, m, n, grid[r][c],visited);

    }
}