class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i_p = 0, i_n = 1;

        for(int i=0;i<n;i++){
            if(nums[i]>=0){
                ans[i_p] = nums[i];
                i_p += 2;
            }
            else{
                ans[i_n] = nums[i];
                i_n += 2;
            }
        }

        return ans;
    }
}