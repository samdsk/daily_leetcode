import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Map<Integer,List<Integer>> adj = new HashMap<>();

        int[] degree = new int[n];

        for(int[] e: edges){
            adj.computeIfAbsent(e[0], k -> new ArrayList<Integer>()).add(e[1]);
            degree[e[1]]++;
        }

        int[][] count = new int[n][26];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if(degree[i]==0) q.offer(i);
        }

        int ans = 1, visited = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            ans = Math.max(ans, ++count[node][colors.charAt(node)-'a']);
            visited++;

            if(!adj.containsKey(node)) continue;

            for(int neighbour : adj.get(node)){
                for (int i = 0; i < 26; i++) {
                    count[neighbour][i] = Math.max(count[neighbour][i], count[node][i]);
                }
                degree[neighbour]--;
                if(degree[neighbour] == 0) q.offer(neighbour);

            }
        }

        return visited < n ? -1 : ans;
    }
}