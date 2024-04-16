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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth < 1) return root;
        if(depth == 1) return new TreeNode(val, root, null);

        helper(root,root.left, val, depth-1, true);
        helper(root,root.right, val, depth-1, false);
        return root;
    }

    private void helper(TreeNode prev, TreeNode cur, int val, int depth, boolean isLeft){
        if(depth == 1 && isLeft){
            prev.left = new TreeNode(val, cur, null);
            return;
        }else if(depth == 1 && !isLeft){
            prev.right = new TreeNode(val, null, cur);
            return;
        }else if(depth > 1 && cur != null){
            helper(cur, cur.left, val, depth-1, true);
            helper(cur, cur.right, val, depth-1, false);
        }
    }
}