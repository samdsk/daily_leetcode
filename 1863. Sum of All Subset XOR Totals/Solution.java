class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int total) {
        if (nums.length == index)
            return total;

        return dfs(nums, index + 1, total ^ nums[index]) + dfs(nums, index + 1, total);
    }
}