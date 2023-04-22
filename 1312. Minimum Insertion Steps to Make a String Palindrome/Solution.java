import javax.lang.model.util.ElementScanner14;

class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        String s_rev = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return n - lcs(s, s_rev, n, n, dp);

    }

    private int lcs(String s1,String s2,int m, int n,int[][] dp){
        if(m == 0 || n == 0) return 0;

        if(dp[m][n] != -1) return dp[m][n];

        if(s1.charAt(m-1) == s2.charAt(n-1))
            return dp[m][n] = 1 + lcs(s1, s2, m-1, n-1, dp);
        else
            return dp[m][n] = Math.max(lcs(s1, s2, m-1, n, dp), lcs(s1, s2, m, n-1, dp));
    }

    private int lcs_dp_it(String s1,String s2,int m,int n){
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[m][n];
    }
}