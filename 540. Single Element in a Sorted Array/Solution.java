public class Solution {
    
    public int singleNonDuplicate(int[] nums) {
        int length = nums.length-1;
        if(length==0) return nums[0];

        int i = 0;
        int f = length;

        if(nums[0] != nums[1]) return nums[0];
        if(nums[length] != nums[length-1]) return nums[length-1];
        while(i<=f){
            int half = i + (f -i)/2;
            if(nums[half] != nums[half-1] && nums[half] != nums[half+1]) return nums[half];
            if((nums[half] == nums[half+1] && half % 2 == 0) || (nums[half] == nums[half-1] && half % 2 != 0))
                i = half+1;
            else f = half-1;
        }

        return nums[i];

    }


    public static void main(String[] args) {
        System.out.println(new Solution().singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(new Solution().singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
        System.out.println(new Solution().singleNonDuplicate(new int[]{1,1,2}));
        System.out.println(new Solution().singleNonDuplicate(new int[]{1,2,2}));

    }
}
