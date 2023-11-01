/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        dfs(root);
        int max = 0;

        for(int m : map.values())
            max = Math.max(max,m);

        List<Integer> max_elms = new ArrayList<>();
        for(int n : map.keySet())
            if(map.get(n) == max) max_elms.add(n);

        int[] ans = new int[max_elms.size()];

        for(int i=0;i<max_elms.size();i++)
            ans[i] = max_elms.get(i);

        return ans;
    }

    void dfs(TreeNode root){
        if(root == null) return;

        map.put(root.val,map.getOrDefault(root.val,0)+1);

        dfs(root.left);
        dfs(root.right);
    }
}