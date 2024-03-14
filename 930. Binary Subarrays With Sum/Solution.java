class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int n = nums.length;
        int ans = 0;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            sum += nums[i];

            if(sum == goal) 
                ans++;

            int prefix_sum = sum - goal;

            if(map.containsKey(prefix_sum))
                ans += map.get(prefix_sum);
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);            
        }

        return ans;
    }
}