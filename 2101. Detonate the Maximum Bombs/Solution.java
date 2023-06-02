import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer,List<Integer>> graph = new HashMap<>();

        int n = bombs.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) continue;

                int xi = bombs[i][0];
                int yi = bombs[i][1];
                int ri = bombs[i][2];

                int xj = bombs[j][0];
                int yj = bombs[j][1];

                long distance = (long)(xi - xj)*(xi - xj) + (long)(yi - yj)*(yi - yj);

                if(distance <= (long) ri*ri){
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int count = dfs(i, new HashSet<>(), graph);
            ans = Math.max(ans, count);
        }

        return ans;

    }

    private int dfs(int node,Set<Integer> visited, Map<Integer,List<Integer>> graph){
        visited.add(node);
        int count = 1;

        for (int neighbour : graph.getOrDefault(node, new ArrayList<>())) {
            if(!visited.contains(neighbour)){
                count += dfs(neighbour, visited, graph);
            }
        }

        return count;
    }
}