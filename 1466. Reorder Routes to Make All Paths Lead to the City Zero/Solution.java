import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    int count = 0;
    public int minReorder(int n, int[][] connections) {
        Map<Integer,List<List<Integer>>> adj = new HashMap<>();
        for(int[] edge : connections){
            adj.computeIfAbsent(edge[0],k->new ArrayList<List<Integer>>()).add(
                Arrays.asList(edge[1],1));
            adj.computeIfAbsent(edge[1],k->new ArrayList<List<Integer>>()).add(
                Arrays.asList(edge[0],0));
        }

        dfs(0,-1,adj);
        return count;

    }
    public void dfs(int node, int parent, Map<Integer,List<List<Integer>>> adj){
        if(!adj.containsKey(node)){
            return;
        }

        for(List<Integer> n : adj.get(node)){
            int child = n.get(0);
            int sign = n.get(1);
            if(child != parent){
                count += sign;
                dfs(child,node,adj);
            }
        }
    }
}
