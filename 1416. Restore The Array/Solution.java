class Solution {
    final int mod = 1000000007;

    // public int numberOfArrays(String s, int k) {
    //     int n = s.length();

    //     int[] dp = new int[n+1];
    //     return dfs(dp,0,s,k);
    // }

    // private int dfs(int []dp,int start,String s,int k){
    //     if(dp[start]!=0) return dp[start];

    //     if(start == s.length()) return 1;

    //     if(s.charAt(start) == '0') return 0;

    //     int count = 0;

    //     for (int i = start; i < s.length(); i++) {
    //         String number = s.substring(start, i+1);
    //         if(Long.parseLong(number) > k) break;

    //         count = (count + dfs(dp, i+1, s, k)) % mod;
    //     }

    //     dp[start] = count;

    //     return count;
    // }

    public int numberOfArrays(String s, int k) {
        int m = s.length();

        int[] dp = new int[m+1];

        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            if(s.charAt(i) == '0') continue;

            for (int j = 0; j < m; j++) {
                String number = s.substring(i, j+1);

                if(Long.parseLong(number) > k) break;

                dp[j+1] = (dp[j+1] + dp[i]) % mod;
            }

        }

        return dp[m];
    }

}