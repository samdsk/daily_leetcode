import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer,List<List<Integer>>> adj = new HashMap<>();

        for(int[] red : redEdges){
            adj.computeIfAbsent(red[0],k -> new ArrayList<>()).add(Arrays.asList(red[1],0));
        }
        for(int[] blu : blueEdges){
            adj.computeIfAbsent(blu[0],k -> new ArrayList<>()).add(Arrays.asList(blu[1],1));
        }

        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        boolean[][] visited = new boolean[n][2];

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0,0,-1});

        ans[0] = 0;

        visited[0][1] = visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] element = queue.poll();
            int node = element[0];
            int steps = element[1];
            int prev = element[2];

            if(!adj.containsKey(node)) continue;

            for(List<Integer> curr : adj.get(node)){
                int neighbour = curr.get(0);
                int color = curr.get(1);
                if(!visited[neighbour][color] && color != prev){
                    if(ans[neighbour] == -1) ans[neighbour] = 1 + steps;
                    visited[neighbour][color] = true;
                    queue.offer(new int[]{neighbour,1 + steps, color});
                }
            }
        }

        return ans;
    }
}