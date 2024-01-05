class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp,1);        

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }

        int max = 1;

        for(int i=0;i<dp.length;i++){
            max = Math.max(dp[i],max);
        }

        return max;
    }
}