import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        list.add(0);
        dfs(0, graph.length-1, list, graph, ans);
        return ans;
    }

    private void dfs(int node,int last,List<Integer> list,int[][] graph,List<List<Integer>> ans){

        if(node == last) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int n : graph[node]){
            list.add(n);
            dfs(n,last,list,graph,ans);
            list.remove(list.size()-1);
        }

    }

}