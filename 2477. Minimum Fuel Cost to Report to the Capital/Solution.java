import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        Map<Integer,List<Integer>> graph = new HashMap<>();

        int[] degree = new int[n];

        for(int[] road : roads){
            graph.computeIfAbsent(road[0],k->new ArrayList<>()).add(road[1]);
            graph.computeIfAbsent(road[1],k->new ArrayList<>()).add(road[0]);
            degree[road[0]]++;
            degree[road[1]]++;
        }

        return bsf(n,graph,degree,seats);
    }

    private long bsf(int n, Map<Integer, List<Integer>> graph, int[] degree, int seats) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if(degree[i] == 1) q.offer(i);
        }

        int[] reps = new int[n];
        Arrays.fill(reps,1);

        long fuel = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            fuel += Math.ceil((double)reps[node] / seats);

            for(int neighbour : graph.get(node)){
                degree[neighbour]--;
                reps[neighbour] += reps[node];
                if(degree[neighbour] == 1 && neighbour != 0){
                    q.offer(neighbour);
                }
            }
        }
        return fuel;
    }
}