class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            right = Math.max(right, i + nums[i]);

            if(i == left){
                ans++;
                left = right;
            }

        }
        return ans;
    }
}