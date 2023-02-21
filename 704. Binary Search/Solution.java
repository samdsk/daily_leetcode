class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    private int binarySearch(int[] nums,int target){
        int i = 0;
        int f = nums.length;
        
        while(i<=f){
            int mid = i + (f - i)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target){
                i = mid+1;                
            }
            if(nums[mid]>target){
                f = mid-1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().binarySearch(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(new Solution().binarySearch(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println(new Solution().binarySearch(new int[]{-1,0,3,5,9,12}, 12));
    }
}