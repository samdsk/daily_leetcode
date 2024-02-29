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
    public boolean isEvenOddTree(TreeNode root) {
        if(root.val%2 == 0) return false;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode prev = q.poll();                
                TreeNode next = q.peek();
                
                if(level%2==0){
                    if(prev.val%2 == 0) return false;
                    if(i<size-1 && prev.val >= next.val) return false;
                }else{
                    if(prev.val%2 != 0) return false;
                    if(i<size-1 && prev.val <= next.val) return false;
                }                

                if(prev.left != null) q.add(prev.left);
                if(prev.right != null) q.add(prev.right);
            }

            level++;
        }

        return true;
    }
}