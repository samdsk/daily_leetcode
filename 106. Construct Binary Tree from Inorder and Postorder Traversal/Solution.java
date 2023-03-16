import java.util.HashMap;
import java.util.Map;

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
    // using map to speed up the algo
    Map<Integer,Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length<1 || postorder.length<1) return null;

        // map of number -> index in inorder array
        map = new HashMap<>();
        
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        int p = postorder.length-1;
        int i = inorder.length-1;

        return helper(inorder, 0, i, postorder, 0, p);
    }

    private TreeNode helper(int[] inorder, int i_s,int i_e,int[] postorder, int p_s,int p_e){
        
        if(i_s>i_e||p_s>p_e) return null; 

        int root_val = postorder[p_e];
        int root_index = map.get(root_val);

        TreeNode root = new TreeNode(root_val);

        // left side of the tree in the range between i_s and root_index
        int left = root_index - i_s;
        // right side of the tree in the range between root_index and i_e
        int right = i_e - root_index;

        root.left = helper(inorder, i_s, root_index-1, postorder, p_s, p_s + left - 1); 
        root.right = helper(inorder, root_index + 1, i_e, postorder, p_e - right, p_e - 1); 
        return root;
    }
}