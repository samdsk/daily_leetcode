class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] dp = new int[n];

        int index = 0;

        for(int i=n-1;i>=0;i--){
            dp[index++] = nums[i];
        }

        int suffix = 1;
        for(int i=0;i<n;i++){
            int temp = dp[i];
            dp[i] = suffix;
            suffix *= temp;
        }

        int prefix = 1;
        for(int i=0;i<n;i++){
            ans[i] = prefix * dp[n-i-1];
            prefix *= nums[i];
        }


        return ans;
    }
}