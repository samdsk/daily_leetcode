class Solution {
    private int n;
    public int specialArray(int[] nums) {        
         n = nums.length;

        Arrays.sort(nums);

        for(int i=1;i<=n;i++){
            int index = helper(nums, i);

            if(n - index == i) return i;
        }  

        return -1;
    }

    private int helper(int[] nums, int target){
        int left = 0, right = n - 1;
        int index = n;

        while(left <= right){
            int m = left + (right - left) / 2;

            if(nums[m] >= target){
                right = m - 1;
                index = m;
            }else{
                left = m + 1;
            }
        }

        return index;
    }
}