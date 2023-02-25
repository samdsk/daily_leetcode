class Solution {
    public int pivotIndex(int[] nums) {
        
        int total = 0;
        for(int x : nums) total += x;
        int left = 0;

        for(int i = 0;i<nums.length;i++){
            if(left == total-nums[i]-left) return i; 
            left += nums[i];
            
        }

        return -1;
    }


}