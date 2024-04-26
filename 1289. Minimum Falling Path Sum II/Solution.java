class Solution {
    public int minFallingPathSum(int[][] grid) {
        int N = grid.length;
        int[][] dp = new int[N][N];

        for(int i=0;i<N;i++){
            dp[N-1][i] = grid[N-1][i];
        }

        for(int r=N-2;r>=0;r--){
            for(int c=0;c<N;c++){
                int min = Integer.MAX_VALUE;
                for(int i=0;i<N;i++){
                    if(c!=i){
                        min = Math.min(min, dp[r+1][i]);
                    }
                }

                dp[r][c] = grid[r][c] + min;
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            ans = Math.min(ans,dp[0][i]);
        }

        return ans;
    }
}