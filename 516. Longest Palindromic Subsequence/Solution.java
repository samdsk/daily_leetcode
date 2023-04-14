class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n-1; i>=0; i--) {
            for (int j = i+1; j<n; j++) {
                if(arr[i] == arr[j])
                    dp[i][j] = 2 + dp[i+1][j-1];
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }

        return dp[0][n-1];

        // int n = s.length();
        // int[] dp = new int[n];
        // int[] dpPrev = new int[n];

        // for (int i = n-1; i>=0; --i) {
        //     dp[i] = 1;
        //     for (int j = i+1; j<n; ++j) {
        //         if(s.charAt(i) == s.charAt(j)){
        //             dp[j] = dpPrev[j-1]+2;
        //         }else{
        //             dp[j] = Math.max(dpPrev[j], dp[j-1]);
        //         }
        //     }
        //     dpPrev = dp.clone();
        // }

        // return dp[n-1];
    }

    private int find(int i, int j, String s){
        if(i>j) return 0;
        if(i==j) return 1;

        if(s.charAt(i) == s.charAt(j)) return 2+find(++i,--j,s);
        else return Math.max(find(i+1,j,s),find(i,j-1, s));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindromeSubseq("bbbab"));
        System.out.println(new Solution().longestPalindromeSubseq("cbbd"));
    }
}