class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        if (n == 2)
            return nums;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum ^= nums[i];
        }

        int diff = sum & -sum;

        // sum = 0110 = 6
        // -sum = 1001 + 1 = 1010

        // while((diff & sum) == 0)
        // diff = diff << 1;

        int[] ans = new int[2];

        for (int i = 0; i < n; i++) {
            if ((diff & nums[i]) == 0)
                ans[0] ^= nums[i];
            else
                ans[1] ^= nums[i];
        }

        return ans;
    }
}