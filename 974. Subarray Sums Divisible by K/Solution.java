class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int prefixMod = 0;
        int[] dp = new int[k];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            prefixMod = (prefixMod + (nums[i] % k) + k) % k;
            count += dp[prefixMod];
            dp[prefixMod]++;
        }

        return count;
    }
}