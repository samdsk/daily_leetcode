import java.util.ArrayList;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        return dfs(root,new ArrayList<Integer>());
    }

    private static List<Integer> dfs(Node root,List<Integer> list){
        if(root  != null) {
            list.add(root.val);
            for(Node n : root.children)
                dfs(n,list);        
        }
            

        return list;
    }
}