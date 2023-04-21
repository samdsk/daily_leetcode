import java.util.Arrays;

class Solution {
    int mod = 1000000007;
    int dp[][][] = new int[101][101][101];

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        for (int i = 0; i <= group.length; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return find(0,0,0,n,minProfit,group,profit);

    }

    private int find(int pos,int count,int profit,int n, int minProfit, int[] groups, int[] profits){
        if(pos == groups.length)
            return profit >= minProfit ? 1 : 0;

        if(dp[pos][count][profit] != -1)
            return dp[pos][count][profit];

        int totalWays = find(pos+1,count,profit,n,minProfit,groups,profits);

        if(count + groups[pos] <=n)
            totalWays += find(pos+1, count+groups[pos], Math.min(minProfit,profit+profits[pos]), n, minProfit, groups, profits);

        return dp[pos][count][profit] = totalWays % mod;
    }
}