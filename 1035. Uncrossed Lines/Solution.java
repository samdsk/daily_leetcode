import java.util.Arrays;

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[][] dp = new int[n1+1][n2+1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if(nums1[i-1] == nums2[j-1]) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n1][n2];
    }

    // private int solve(int i, int j, int[] nums1, int[] nums2,int[][] dp) {
    //     if(i<=0 || j<=0) return 0;

    //     if(dp[i][j] != -1) return dp[i][j];

    //     if(nums1[i-1] == nums2[j-1])
    //         dp[i][j] = 1 + solve(i-1, j-1, nums1, nums2, dp);
    //     else
    //         dp[i][j] = Math.max(
    //                 solve(i, j-1, nums1, nums2, dp),
    //                 solve(i-1, j, nums1, nums2, dp)
    //             );

    //     return dp[i][j];
    // }
}