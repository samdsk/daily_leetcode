import java.util.Arrays;

class Solution {
    public int maxScore(int[] nums) {
        int size = 1 << nums.length;
        int[] memo = new int[size];
        Arrays.fill(memo,-1);
        return backtrack(nums,0,0,memo);
    }

    private int backtrack(int[] nums, int mask, int pairs, int[] memo) {
        if( 2 * pairs == nums.length) return 0;

        if(memo[mask] != -1) return memo[mask];

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if( (((mask >> i) & 1) == 1 )||(((mask >> j) & 1) == 1)){
                    continue;
                }
                int newmask = mask | (1<<i) | (1<<j);

                int score = (pairs + 1) * gcd(nums[i], nums[j]);

                int remaining = backtrack(nums, newmask, pairs+1, memo);
                ans = Math.max(ans, score+remaining);
            }
        }

        memo[mask] = ans;

        return ans;
    }

    private int gcd(int a,int b){
        if(b == 0) return a;
        return gcd(b,a%b);
    }
}