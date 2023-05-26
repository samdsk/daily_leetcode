class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[2][n+1][n+1];

        for (int player = 0; player < 2; player++) {
            for (int i = 0; i <= n; i++) {
                for (int m = 0; m <= n; m++) {
                    dp[player][i][m] = -1;
                }
            }
        }

        return play(piles,dp,0,0,1);
    }

    private int play(int[] piles, int[][][] dp, int p, int i, int m) {
        int n = piles.length;
        if(i == n) return 0;

        if(dp[p][i][m] != -1) return dp[p][i][m];

        int ans = p == 1 ? 1_000_000 : -1;
        int s = 0;

        for (int j = 1; j <= Math.min(2*m,n-i); j++) {
            s += piles[i+j-1];
            if(p==0){
                ans = Math.max(ans, s+play(piles, dp, 1, i+j, Math.max(m,j)));
            }else{
                ans = Math.min(ans, play(piles, dp, 0, i+j, Math.max(m,j)));
            }
        }

        return dp[p][i][m] = ans;
    }


}