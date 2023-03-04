class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        long count = 0;
        int minPos = -1, maxPos = -1, leftBound = -1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<minK || nums[i]>maxK){
                leftBound = i;
            }

            if(nums[i]==minK) minPos = i;
            if(nums[i]==maxK) maxPos = i;

            count += Math.max(0, Math.min(maxPos, minPos) - leftBound);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubarrays(new int[]{1,3,5,2,7,5}, 1, 5));
        System.out.println(new Solution().countSubarrays(new int[]{1,1,1,1}, 1, 1));
    }
}