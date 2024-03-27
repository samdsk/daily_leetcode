class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;

        int count = 0;
        int right = 0, left = 0;

        int n = nums.length;
        int prod = 1;

        while(right < n){
            prod *= nums[right];

            while(left <= right && prod>=k){
                prod /= nums[left++];
            }

            count += right - left + 1;
            right++;            
        }

        return count;
    }
}