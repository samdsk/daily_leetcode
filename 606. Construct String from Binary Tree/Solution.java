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
    StringBuilder str = new StringBuilder();
    public String tree2str(TreeNode root) {
        dfs(root);
        return str.toString();
    }
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        
        str.append(root.val);

        if(root.left == null && root.right == null)
            return;

        str.append('(');
        dfs(root.left);        
        str.append(')');
        
        if(root.right != null){
            str.append('(');
            dfs(root.right);            
            str.append(')');
        }
    }
}