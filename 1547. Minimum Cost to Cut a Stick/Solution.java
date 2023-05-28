import java.util.Arrays;

// class Solution {
//     int memo[][];
//     int newcuts[];
//     public int minCost(int n, int[] cuts) {
//         int m = cuts.length;
//         newcuts = new int[m+2];

//         for (int i = 1; i < m+1; i++) {
//             newcuts[i] = cuts[i-1];
//         }

//         newcuts[m+1] = n;

//         Arrays.sort(newcuts);

//         memo = new int[m+2][m+2];

//         for (int i = 0; i < m+2; i++) {
//             Arrays.fill(memo[i],-1);
//         }

//         return cost(0,newcuts.length-1);

//     }

//     private int cost(int left, int right) {
//         if(memo[left][right] != -1) return memo[left][right];
//         if(right - left <= 1) return 0;

//         int ans = Integer.MAX_VALUE;

//         for (int mid = left+1; mid < right; mid++) {
//             int cost = cost(left, mid)+cost(mid,right)+ newcuts[right]- newcuts[left];
//             ans = Math.min(ans, cost);
//         }

//         memo[left][right] = ans;

//         return ans;
//     }

// }

class Solution{
    public int minCost(int n, int[] cuts) {
        int m = cuts.length + 2;
        Arrays.sort(cuts);

        int arr[] = new int[m];
        arr[0] = 0;
        arr[m-1] = n;

        for (int i = 1; i < m-1; i++) {
            arr[i] = cuts[i-1];
        }

        int dp[][] = new int[m][m];

        for (int i = 2; i < m; i++) {
            for (int left = 0; left < m && i+left <m; left++) {
                int right = i+left;
                int min = Integer.MAX_VALUE;
                for (int k = left+1; k < right; k++) {
                    min = Math.min(min, dp[left][k]+dp[k][right]);
                }

                dp[left][right] = min + arr[right] - arr[left];
            }
        }

        return dp[0][m-1];
    }
}