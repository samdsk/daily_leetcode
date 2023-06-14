
// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int min = Integer.MAX_VALUE;
    TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        visiteInOrder(root);
        return min;
    }

    private void visiteInOrder(TreeNode current){
        if(current == null) return;

        visiteInOrder(current.left);

        if(prev != null)
            min = Math.min(min,current.val - prev.val);

        prev = current;

        visiteInOrder(current.right);
    }
}