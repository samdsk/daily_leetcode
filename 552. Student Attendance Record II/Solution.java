class Solution {
    private final int MOD = 1_000_000_007;
    private int[][][] DP;

    public int checkRecord(int n) {

        DP = new int[n+1][2][3];

        for(int i=0;i<=n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    DP[i][j][k] = -1;
                }
            }
        }

        return helper(n,0,0);
    }

    private int helper(int n, int As, int Ls){
        if(As > 1 || Ls > 2) return 0;
        if(n == 0) return 1;

        if(DP[n][As][Ls] != -1) return DP[n][As][Ls];

        int count = helper(n-1, As, 0) % MOD;
        count = (count + helper(n-1, As+1, 0)) % MOD;
        count = (count + helper(n-1, As, Ls+1)) % MOD;
        
        DP[n][As][Ls] = count;

        return count;
    }
}