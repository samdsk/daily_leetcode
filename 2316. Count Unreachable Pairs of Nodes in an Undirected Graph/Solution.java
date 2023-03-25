import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public long countPairs(int n, int[][] edges) {

        //unionfind

        // UnionFind dsu = new UnionFind(n);

        // for(int[] e : edges)
        //     dsu.union_set(e[0], e[1]);

        // Map<Integer,Integer> componentSize = new HashMap<>();

        // for (int i = 0; i < n; i++) {
        //     int parent = dsu.find(i);
        //     componentSize.put(parent,componentSize.getOrDefault(parent, 0)+1);
        // }

        // long numberOfPaths = 0;

        // dfs bfs

        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int[] edge : edges){
            adj.computeIfAbsent(edge[0],k-> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1],k-> new ArrayList<Integer>()).add(edge[0]);
        }

        //common
        long remaingNodes = n;

        // dfs bfs

        long numberOfPairs = 0;
        long sizeOfComponent = 0;
        boolean[] visit = new boolean[n];

        // unionfind

        // for(int c : componentSize.values()){
        //     numberOfPaths += c * (remaingNodes - c);
        //     remaingNodes -= c;
        // }

        // dfs bfs

        for (int i = 0; i < n; i++) {
            if(!visit[i]){
                sizeOfComponent = dfs(i, adj, visit);
                // sizeOfComponent = bfs(i, adj, visit);
                numberOfPairs += sizeOfComponent * (remaingNodes - sizeOfComponent);
                remaingNodes -= sizeOfComponent;
            }
        }

        // unionfind

        // return numberOfPaths;

        //dfs bfs

        return numberOfPairs;


    }

    private int dfs(int node ,Map<Integer,List<Integer>> adj, boolean[] visit){
        int count = 1;
        visit[node] = true;
        if(!adj.containsKey(node)){
            return count;
        }


        for(int n : adj.get(node)){
            if(!visit[n]){
                count += dfs(n,adj,visit);
            }
        }

        return count;
    }

    private int bfs(int node ,Map<Integer,List<Integer>> adj, boolean[] visit){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        int count = 1;
        visit[node] = true;

        while(!q.isEmpty()){
            node = q.poll();
            if(!adj.containsKey(node)){
                continue;
            }

            for(int n : adj.get(node)){
                if(!visit[n]){
                    visit[n] = true;
                    count++;
                    q.offer(n);
                }
            }
        }

        return count;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;
    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++)
            parent[i] = i;
    }
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }
    public void union_set(int x, int y) {
        int xset = find(x), yset = find(y);

        if (xset == yset) return;
         else if (rank[xset] < rank[yset]) parent[xset] = yset;
         else if (rank[xset] > rank[yset]) parent[yset] = xset;
        else {
            parent[yset] = xset;
            rank[xset]++;
        }
    }
}