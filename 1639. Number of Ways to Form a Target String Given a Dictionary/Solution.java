class Solution {
    public int numWays(String[] words, String target) {
        int m = target.length();
        int n = words[0].length();

        int[][] count = new int[26][n];

        for (int i = 0; i < n; i++) {
            for(String s: words){
                count[s.charAt(i) - 'a'][i]++;
            }
        }

        long [][] dp = new long[m+1][n+1];
        dp[0][0] = 1;

        int mod = 1000000007;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if(i<m){
                    dp[i+1][j+1] += count[target.charAt(i) - 'a'][j] * dp[i][j];
                    dp[i+1][j+1] %= mod;
                }

                dp[i][j+1] += dp[i][j] % mod;
                dp[i][j+1] %= mod;
            }
        }

        return (int) dp[m][n];

    }
}