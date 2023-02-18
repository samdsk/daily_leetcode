import java.util.Stack;

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

 //[3,9,20,null,2,7,10,null,null,null,null,5,null,null,6]

 class Solution {
    public int maxDepth(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        return depth(root, stack);

    }

    private static int depth(TreeNode root,Stack<TreeNode> stack){
        //System.out.println(root.val);
        if(root == null) return 0;
        return Math.max(depth(root.left, stack),depth(root.right, stack))+1;
    }
}