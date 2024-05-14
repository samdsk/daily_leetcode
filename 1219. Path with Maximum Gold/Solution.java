class Solution {
    int rows = 0;
    int cols = 0;
    
    public int getMaximumGold(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int max = 0;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                max = Math.max(max, dfs(grid, r, c));
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int r, int c){

        if(r < 0 || c < 0 || r >= rows || c >= cols)
            return 0;

        if(grid[r][c] == 0) 
            return 0;

        int value = grid[r][c];
        grid[r][c] = 0;

        int max = 0;

        max = Math.max(max, value + dfs(grid,r+1,c));
        max = Math.max(max, value + dfs(grid,r,c+1));
        max = Math.max(max, value + dfs(grid,r-1,c));
        max = Math.max(max, value + dfs(grid,r,c-1));

        grid[r][c] = value;

        return max;
    }
}