class Solution {
    public int maxProductDifference(int[] nums) {

        int max = nums[0];
        int second_max = nums[1];
        int min = nums[0];
        int second_min = nums[1];

        for (int i = 1; i < nums.length; i++) {
            if(max < nums[i]){
                second_max = max;
                max = nums[i];
            }else if(second_max < nums[i]){
                second_max = nums[i];
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if(min > nums[i]){
                second_min = min;
                min = nums[i];
            }else if(second_min > nums[i]){
                second_min = nums[i];
            }
        }
        return (max * second_max) - (min * second_min);        
    }
}