class Solution {
    public int[] sortArrayByParity(int[] nums) {
        for(int i = 0, j = 0;i<nums.length;i++){
            if((nums[i] & 1) == 0){
                //swapping
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }

        return nums;

    }
}