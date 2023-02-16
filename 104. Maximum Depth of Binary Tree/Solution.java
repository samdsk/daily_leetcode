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

class Solution {
    public int maxDepth(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        return depth(root,stack);

    }

    private static int depth(TreeNode root,Stack<TreeNode> stack){
        System.out.println(root.val);
        if(root.right == null) return 0; 
        if(root.left == null) return 0;
        return Math.max(depth(root.left, stack),depth(root.right, stack))+1;
    }
}