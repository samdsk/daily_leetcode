class Solution {
    // long dp[];
    // public long mostPoints(int[][] questions) {
    //     int n = questions.length;
    //     dp = new long[n];

    //     return dfs(questions,0);
    // }

    // private long dfs(int[][] questions, int index){
    //     if(index>=questions.length) return 0;

    //     if(dp[index] != 0) return dp[index];

    //     long points = questions[index][0];
    //     int skip = questions[index][1];

    //     dp[index] = Math.max(points + dfs(questions, index+skip+1),
    //     dfs(questions, index+1));

    //     return dp[index];
    // }

    // DP Iterative

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];

        dp[n-1] = questions[n-1][0];

        for (int i = n-2; i >=0; i--) {
            dp[i] = questions[i][0];
            int skip = questions[i][1];
            if(i+skip+1<n){
                dp[i] += dp[i+skip+1];
            }

            dp[i] = Math.max(dp[i], dp[i+1]);
        }

        return dp[0];
    }
}