class Solution {
    public int longestZigZag(TreeNode root) {
        return Math.max(maxZigZag(root.left,false,0),maxZigZag(root.right,true,0));
    }

    // true = right
    // false = left
    private int maxZigZag(TreeNode root, boolean right,int count){
        if(root == null) return count;

        if(right)
            return Math.max(maxZigZag(root.left,false,count+1),maxZigZag(root.right,true,0));
        else
            return Math.max(maxZigZag(root.right,true,count+1),maxZigZag(root.left,false,0));

    }
}

//  Definition for a binary tree node.
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