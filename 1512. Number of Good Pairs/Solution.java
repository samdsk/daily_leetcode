class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] counts = new int[101];
        int K = 2;

        for(int i = 0; i<nums.length;i++){
            counts[nums[i]]++;
        }

        int ans = 0;        
        for(int i = 0;i<counts.length;i++){
            int n  = counts[i];
            ans += (n * (n - 1)) / K;
        }

        return ans;
    }
}