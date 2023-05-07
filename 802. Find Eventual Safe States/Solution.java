import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        // colors: WHITE 0, GRAY 1 = leeds to cycle, BLACK 2 = end node;
        int[] color = new int[n];

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(dfs(i,color,graph)) ans.add(i);
        }

        return ans;
    }

    private boolean dfs(int node, int[] color, int[][] graph){
        if(color[node] > 0) return color[node] == 2;

        color[node] = 1;

        for(int n: graph[node]){
            if(color[n] == 2) continue;
            if(color[n] == 1 || !dfs(n,color,graph)) return false;
        }

        color[node] = 2;
        return true;
    }
}