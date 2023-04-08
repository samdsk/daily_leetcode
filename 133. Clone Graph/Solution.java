import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<Integer,Node> visited;

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        visited = new HashMap<>();
        return dfs(node);
    }

    private Node dfs(Node node){
        if(node == null) return null;

        if(visited.containsKey(node.val)){
            return visited.get(node.val);
        }

        Node clone = new Node(node.val);
        visited.put(clone.val, clone);

        for(Node n : node.neighbors){
            clone.neighbors.add(dfs(n));
        }

        return clone;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
