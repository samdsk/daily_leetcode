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
    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root,low,high);
        return sum;
    }

    private void helper(TreeNode root, int l, int h){
        if(root == null) return;

        if(root.val < l) {
            helper(root.right,l,h);
            return;
        }
        if(root.val > h){
            helper(root.left,l,h);
            return;
        }

        if(root.val >= l && root.val <= h){
            sum += root.val;
        }

        helper(root.left,l,h);
        helper(root.right,l,h);        
    }
}