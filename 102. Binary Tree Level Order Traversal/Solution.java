import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    // List<List<Integer>> list;

    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     list = new ArrayList<>();
    //     Queue<TreeNode> queue = new LinkedList<>();

    //     if(root != null){
    //         list.add(List.of(root.val));
    //         queue.add(root);
    //         bfs(queue);
    //     }


    //     return list;
    // }

    // private void bfs(Queue<TreeNode> q){
    //     if(q.isEmpty()) return;
    //     List<Integer> temp = new ArrayList<>();        
    //     Queue<TreeNode> q_temp = new LinkedList<>();

    //     for(TreeNode t : q){
    //         if(t.left != null) {
    //             temp.add(t.left.val);
    //             q_temp.add(t.left);
    //         }
    //         if(t.right != null){
    //             temp.add(t.right.val);
    //             q_temp.add(t.right);
    //         }
    //     }
    //     if(!q_temp.isEmpty()) list.add(temp);

    //     bfs(q_temp);
    // }

    // private void bfs(TreeNode root){
    //     List<Integer> temp = new ArrayList<>();

    //     if(root.left != null) temp.add(root.left.val);
    //     if(root.right != null) temp.add(root.right.val);
        
    //     list.add(temp);

    //     bfs(root.left);
    //     bfs(root.right);

    //     return;
    // }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()) {


            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for(int i = 0; i<size;i++) {
                TreeNode t = queue.poll();
                list.add(t.val);
                if(t.left != null) queue.add(t.left);
                if(t.right !=null) queue.add(t.right);
            }

            res.add(list); 
        }

        return res; 
    }
}

