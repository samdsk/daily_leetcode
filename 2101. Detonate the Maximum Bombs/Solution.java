import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


// BFS
class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        int n = bombs.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) continue;

                if(isInRage(bombs[i], bombs[j])){
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, bfs(i,graph,n));
        }
        return ans;
    }

    private int bfs(int i, Map<Integer, List<Integer>> graph,int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visisted = new boolean[n];

        q.offer(i);
        visisted[i] = true;
        int count = 1;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int neighbour : graph.getOrDefault(node, new ArrayList<>())){
                if(!visisted[neighbour]){
                    visisted[neighbour] =  true;
                    count++;
                    q.offer(neighbour);
                }
            }
        }

        return count;
    }

    private boolean isInRage(int[] i, int[] j){
        int xi = i[0];
        int yi = i[1];
        int ri = i[2];

        int xj = j[0];
        int yj = j[1];

        long distance = (long)(xi - xj)*(xi - xj) + (long)(yi - yj)*(yi - yj);

        return distance <= (long) ri*ri;

    }
}

// DFS

// class Solution {
//     public int maximumDetonation(int[][] bombs) {
//         Map<Integer,List<Integer>> graph = new HashMap<>();

//         int n = bombs.length;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 if(i == j) continue;

//                 int xi = bombs[i][0];
//                 int yi = bombs[i][1];
//                 int ri = bombs[i][2];

//                 int xj = bombs[j][0];
//                 int yj = bombs[j][1];

//                 long distance = (long)(xi - xj)*(xi - xj) + (long)(yi - yj)*(yi - yj);

//                 if(distance <= (long) ri*ri){
//                     graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
//                 }
//             }
//         }

//         int ans = 0;

//         for (int i = 0; i < n; i++) {
//             int count = dfs(i, new HashSet<>(), graph);
//             ans = Math.max(ans, count);
//         }

//         return ans;

//     }

//     private int dfs(int node,Set<Integer> visited, Map<Integer,List<Integer>> graph){
//         visited.add(node);
//         int count = 1;

//         for (int neighbour : graph.getOrDefault(node, new ArrayList<>())) {
//             if(!visited.contains(neighbour)){
//                 count += dfs(neighbour, visited, graph);
//             }
//         }

//         return count;
//     }
// }