class Solution {
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    private static TreeNode invert(TreeNode root){
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = invert(root.right);
        root.right = invert(temp);
        return root;
    }
}