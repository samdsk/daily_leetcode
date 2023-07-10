import java.util.LinkedList;
import java.util.Queue;

class Solution {
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

    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if(node == null) continue;

                if(node.left == null && node.right == null) return depth;

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }


        return depth;
    }

}