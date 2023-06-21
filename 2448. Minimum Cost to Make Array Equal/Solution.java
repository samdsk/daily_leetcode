class Solution {
    public long minCost(int[] nums, int[] cost) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for(int num : nums){
            left = Math.min(left, num);
            right = Math.max(right,num);
        }

        long ans = getCost(nums,cost,nums[0]);

        while(left < right){
            int mid = left + (right - left) / 2;
            long cost1 = getCost(nums,cost,mid);
            long cost2 = getCost(nums,cost,mid+1);

            ans = Math.min(cost1, cost2);

            if(cost1 > cost2) left = mid + 1;
            else right = mid;
        }

        return ans;
    }

    private long getCost(int[] nums, int[] cost, int base) {
        long ans = 0L;
        for (int i = 0; i < nums.length; i++) {
            ans += 1L * Math.abs(nums[i] - base) * cost[i];
        }
        return ans;
    }
}