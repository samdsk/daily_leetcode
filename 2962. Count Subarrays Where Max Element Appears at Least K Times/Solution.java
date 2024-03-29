class Solution {
    public long countSubarrays(int[] nums, int k) {
        int freq_of_max = 0;
        int n = nums.length;
        long ans = 0;
        int left = 0;

        int max = 0;

        for(int i=0;i<n;i++){
            max = Math.max(max, nums[i]);
        }

        for(int right = 0; right < n; right++){
            if(nums[right]==max) freq_of_max++;

            while(freq_of_max == k){
                if(nums[left]==max) freq_of_max--;
                left++;
            }

            ans += left;
        }

        
        return ans;
    }
}