class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        if(k<1) return 0;

        int n = nums.length;
        int left = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        int max = 0;

        for(int right = 0; right < n; right++){

            int key = nums[right];

            freq.put(key, freq.getOrDefault(key,0)+1);

            while(left <= right && freq.get(key) > k){
                int leftKey = nums[left];
                freq.put(leftKey, freq.getOrDefault(leftKey,1)-1);
                left++;
            }

            max = Math.max(max, right - left +1);

        }

        return max;
    }
}