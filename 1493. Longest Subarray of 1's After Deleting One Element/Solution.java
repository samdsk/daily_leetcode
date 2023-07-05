class Solution {
    public int longestSubarray(int[] nums) {
        int zeros = 0;
        int window = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) zeros++;

            while(zeros > 1){
                if(nums[left] == 0) zeros--;
                left++;
            }

            window = Math.max(window, i - left);
        }

        return window;
    }
}