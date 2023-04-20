import java.util.Map;
import java.util.HashMap;


class Solution {
    Map<Integer,Integer> map;
    int maxWidth = 0;

    public int widthOfBinaryTree(TreeNode root) {
        map = new HashMap<>();
        dfs(root, 0, 0);
        return maxWidth;
    }

    private void dfs(TreeNode root, int depth,int position){
        if(root == null) return;

        if(!map.containsKey(depth))
            map.put(depth,position);

        maxWidth = Math.max(maxWidth, position - map.get(depth) + 1);

        dfs(root.left,depth+1,position*2);
        dfs(root.right,depth+1,position*2+1);
    }
}

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