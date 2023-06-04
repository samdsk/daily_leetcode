class Solution {
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int[] ans = new int[len];

        int x = 0;
        int y = 1;

        for (int i = 0; i < n; i++) {
            ans[x] = nums[i];
            ans[y] = nums[n+i];
            x += 2;
            y += 2;
        }

        return ans;
    }
}