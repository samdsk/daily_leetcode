import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private Map<String,Integer> ids;
    private Map<Integer,Integer> count;
    private List<TreeNode> output;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ids = new HashMap<>();
        count = new HashMap<>();
        output = new ArrayList<>();
        helper(root);
        return output;
    }

    private int helper(TreeNode root){
        if(root == null) return 0;

        String node = helper(root.left) + "," + root.val + "," + helper(root.right);

        if(!ids.containsKey(node))
            ids.put(node,ids.size()+1);

        int id = ids.get(node);

        count.put(id,count.getOrDefault(id, 0)+1);
        if(count.get(id) == 2)
            output.add(root);

        return id;

    }
}