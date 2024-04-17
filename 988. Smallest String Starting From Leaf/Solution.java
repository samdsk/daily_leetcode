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
    private String min = null;
    public String smallestFromLeaf(TreeNode root) {
        if(root == null) return "";
        dfs(root, new StringBuilder());
        return min;
    }

    private void dfs(TreeNode root, StringBuilder acc){
        if(root == null) return;

        StringBuilder temp = new StringBuilder();
        char c = (char)(root.val + 'a');
        temp.append(c);
        temp.append(acc.toString());

        if(root.left == null && root.right == null){            
            assignMinString(temp.toString());
            return;
        }

        dfs(root.left, temp);
        dfs(root.right, temp);
        
    }

    private void assignMinString(String str){
        if(min == null) min = str;
        else if(str.compareTo(min) < 0)
            min = str;
    }
}