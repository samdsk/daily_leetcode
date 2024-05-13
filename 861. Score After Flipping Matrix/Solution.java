class Solution {
    int ROWS = 0;
    int COLS = 0;

    public int matrixScore(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        flipRows(grid);

        for(int c=0;c<COLS;c++){
            int ones = 0;
            for(int r=0;r<ROWS;r++){
                ones += grid[r][c];
            }

            if(ones < (ROWS - ones)){
                for(int r=0;r<ROWS;r++){
                    if(grid[r][c]==0) grid[r][c] = 1;
                    else grid[r][c] = 0;
                }
            }           
        }

        return total(grid);
    }

    private void flipRows(int[][] grid){
        for(int i=0;i<ROWS;i++){
            if(grid[i][0] == 0){
                for(int j=0;j<COLS;j++){
                    if(grid[i][j]==0) grid[i][j] = 1;
                    else grid[i][j] = 0;
                }
            } 
        }
    }

    private int total(int[][] grid){
        int sum = 0;

        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                sum += grid[i][j] << (COLS-j-1);
            }
        }

        return sum;
    }
}