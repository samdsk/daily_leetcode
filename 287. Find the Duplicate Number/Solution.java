class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow == fast) break;
        }

        int index = nums[0];

        while(slow != index){
            slow = nums[slow];
            index = nums[index];
        }
        
        return index;
    }
}