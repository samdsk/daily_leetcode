class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long ans = 0;
        int minPos = -1, maxPos = -1, badPos = -1;

        for(int right=0;right < n; right++){
            int curr = nums[right];
            if(curr == minK) 
                minPos = right;
            
            if(curr == maxK)
                maxPos = right;

            if(curr < minK || curr > maxK) 
                badPos = right;
            
            ans += Math.max(0,Math.min(minPos, maxPos) - badPos);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubarrays(new int[]{1,3,5,2,7,5}, 1, 5));
        System.out.println(new Solution().countSubarrays(new int[]{1,1,1,1}, 1, 1));
    }
}