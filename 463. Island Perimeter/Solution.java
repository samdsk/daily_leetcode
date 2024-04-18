class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c] == 1){
                    return helper(grid,r,c,m,n);
                }
            }
        }
        
        return 0;
    }

    private int helper(int[][] grid, int r, int c, int ROWS, int COLS){
        if(r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] == 0) return 1;
        if(grid[r][c] < 0) return 0;

        int sum = 0;
        grid[r][c] = -1;
        sum += helper(grid, r, c+1, ROWS, COLS);
        sum += helper(grid, r+1, c, ROWS, COLS);
        sum += helper(grid, r, c-1, ROWS, COLS);
        sum += helper(grid, r-1, c, ROWS, COLS);

        return sum;
    }
}