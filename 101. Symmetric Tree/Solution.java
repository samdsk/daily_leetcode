class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricIter(root);
    }

    private boolean isSymmetric(TreeNode left,TreeNode right){
        
        if(left == null || right == null) 
            return left == right;

        if(left.val == right.val)
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

        return false;
    }

    private boolean isSymmetricIter(TreeNode root){
        if(root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while(!stack.isEmpty()){
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            if(left == null && right == null)
                continue;

            if(left == null || right == null || left.val != right.val)
                return false;
            
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }

        return true;
    }
}