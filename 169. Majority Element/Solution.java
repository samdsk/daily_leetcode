class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 0;

        for(int i=0;i<nums.length;i++){
            if(count == 0){
                count = 1;
                majority = nums[i];
            }else if(majority != nums[i])
                count--;
            else count++;
        }

        return majority;
    }
}