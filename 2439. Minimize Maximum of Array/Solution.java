class Solution {
    public int minimizeArrayValue(int[] nums) {
        long ans = 0, psum = 0;

        for (int i = 0; i < nums.length; ++i) {
            psum += nums[i];
            ans = Math.max(ans,(psum+i)/(i+1));
        }

        return (int) ans;
    }
}