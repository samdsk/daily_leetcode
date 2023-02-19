import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    List<List<Integer>> list;    

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null){
            queue.add(root);
            bfs(queue,1);
        }


        return list;
    }

    private void bfs(Queue<TreeNode> q,int zigzag){
        if(q.isEmpty()) return;
        List<Integer> temp = new ArrayList<>();        
        Queue<TreeNode> q_temp = new LinkedList<>();

        for(TreeNode t : q){
            if(t.left != null) {
                temp.add(t.left.val);
                q_temp.add(t.left);
            }
            if(t.right != null){
                temp.add(t.right.val);
                q_temp.add(t.right);
            }
        }

        if(zigzag % 2 != 0) Collections.reverse(temp);

        if(!q_temp.isEmpty()) list.add(temp);

        bfs(q_temp,zigzag+1);


    }

}
