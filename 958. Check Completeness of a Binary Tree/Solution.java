import java.util.LinkedList;
import java.util.Queue;

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
    Queue<TreeNode> queue;
    public boolean isCompleteTree(TreeNode root) {
        queue = new LinkedList<>();
        return helper(root);
    }

    private boolean helper(TreeNode root){
        if(root == null) return true;
        
        queue.offer(root);
        boolean nullFound = false;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                nullFound = true;
            }else{
                if(nullFound)
                    return false;
                
                queue.offer(node.left);
                queue.offer(node.right);
            } 
        }

        return true;

    }
}