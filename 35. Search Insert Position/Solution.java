public class Solution {
    public int searchInsert(int[] nums, int target) {
        return search(nums, 0, nums.length, target);
        
    }

    private int search(int[] nums,int i,int f,int target){
        if(i>=f) return i;

        int half = (f+i)/2;
        if(nums[half]==target) return half;

        if(nums[half]>target) return search(nums,i,half,target);
        else return search(nums,half+1,f,target);
    }

    public static void main(String[] args) {
        
        System.out.println(new Solution().searchInsert(new int[]{1,3,5,6,8}, 5));
        System.out.println(new Solution().searchInsert(new int[]{1,3,5,6,8}, 2));
        System.out.println(new Solution().searchInsert(new int[]{1,3,5,6,8}, 7));
        System.out.println(new Solution().searchInsert(new int[]{1,3}, 2));

    }
}
