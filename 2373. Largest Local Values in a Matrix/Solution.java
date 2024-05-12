class Solution {
    public int[][] largestLocal(int[][] grid) {
        int N = grid.length;
        int[][] ans = new int[N-2][N-2];

        for(int i=1;i<N-1;i++){
            for(int j=1;j<N-1;j++){
                ans[i-1][j-1] = maxGrid3(grid, i,j);
            }
        }

        return ans;
    }

    private int maxGrid3(int[][] grid, int r, int c){
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;

        for(int i=r-1;i<r+2 && i<m && i>=0;i++){
            for(int j=c-1; j<c+2 && j<n && j>=0;j++){
                max = Math.max(max, grid[i][j]);
            }
        }

        return max;
    } 
}