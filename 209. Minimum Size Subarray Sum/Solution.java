class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for(int i=0;i<nums.length;i++){
            int count = 0;
            sum += nums[i];

            while(sum >= target){
                ans = Math.min(ans, i - left + 1);
                sum -= nums[left++];
            }

        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}