class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = {0,0,0};
        int sum = 0;

        for (int i = n-1; i>=0; i--) {
            sum += stoneValue[i];

            int temp1 = Math.max(sum-dp[1], sum-dp[2]);
            int temp2 = Math.max(sum-dp[0], temp1);

            dp[2] = dp[1];
            dp[1] = dp[0];
            dp[0] = temp2;
        }

        int diff = sum - dp[0];

        if(dp[0]> diff) return "Alice";
        if(dp[0]< diff) return "Bob";
        return "Tie";
    }

}