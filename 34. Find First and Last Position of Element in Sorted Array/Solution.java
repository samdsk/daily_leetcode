class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];

        ans[0] = findFirstIndex(nums,target);
        ans[1] = findLastIndex(nums,target);

        return ans;
    }

    private int findFirstIndex(int[] nums, int target){
        int left = 0, right = nums.length-1;
        int index = -1;

        while(left<=right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target) 
                index = mid; 
            
            if(nums[mid] >= target)
                right = mid-1;
            else
                left = mid+1;            
        }

        return index;
    }
    
    private int findLastIndex(int[] nums, int target){
        int left = 0, right = nums.length-1;
        int index = -1;

        while(left<=right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target) 
                index = mid; 
            
            if(nums[mid] <= target)
                left = mid+1;
            else
                right = mid-1;
            
        }

        return index;
    }
}