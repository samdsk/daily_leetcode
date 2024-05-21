class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new ArrayList<>());
        return ans;
    }

    private void dfs(int[] nums, int index, List<Integer> acc){
        if(nums.length == index){ 
            ans.add(acc);
            return;
        }

        dfs(nums, index+1, acc);

        List<Integer> temp = new ArrayList<>(acc);
        temp.add(nums[index]);

        dfs(nums, index+1, temp);
    }
}