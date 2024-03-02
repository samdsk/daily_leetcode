class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;        
        int left = 0, right = n-1;
        int index = n-1;
        int[] ans = new int[n];

        while(left<=right && index>=0){
            int temp = 0;
            if(Math.abs(nums[left])<Math.abs(nums[right]))
                temp = nums[right--];
            else
                temp = nums[left++];

            ans[index--] = temp*temp;            
        }        
        
        return ans;
    }
}