class Solution {
    public void moveZeroes(int[] nums) {
        int notZERO = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[notZERO] = nums[i];
                notZERO++;
            }

        }

        for (int i = notZERO; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}