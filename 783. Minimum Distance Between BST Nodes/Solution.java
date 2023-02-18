import java.util.Stack;

class Solution {
    private int min_diff = Integer.MAX_VALUE;
    private TreeNode prev;

    public int minDiffInBST(TreeNode root) {
        min_diff_search(root);
        return min_diff;
    }

    private void min_diff_search(TreeNode root){
        if(root == null) return;
        min_diff_search(root.left);
        if(prev != null) min_diff = Math.min(min_diff,root.val - prev.val);
        prev = root;
        min_diff_search(root.right);
    }


}