import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int[] prev = new int[n + 2];
        Arrays.fill(prev,0);
        for (int i = n-1; i>=0; i--) {

            int[] dp = new int[n+2];

            for (int time = 1; time < n; time++) {
                dp[time] = Math.max(satisfaction[i]*time + prev[time+1],prev[time]);
            }

            prev = dp;
        }

        return prev[1];
    }
    // public int maxSatisfaction(int[] satisfaction) {
    //     Arrays.sort(satisfaction);
    //     int n = satisfaction.length;

    //     int sum = 0,cur = 0,ans = 0;

    //     for (int i = n-1; i>=0; i--) {
    //         cur += sum + satisfaction[i];
    //         sum += satisfaction[i];
    //         ans = Math.max(ans,cur);
    //     }
    //     return ans;
    // }
}