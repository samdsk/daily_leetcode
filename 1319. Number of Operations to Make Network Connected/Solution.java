import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;

        // Map<Integer,List<Integer>> adj = new HashMap<>();
        // for(int[] connection : connections){
        //     adj.computeIfAbsent(connection[0], k -> new ArrayList<Integer>()).add(connection[1]);
        //     adj.computeIfAbsent(connection[1], k -> new ArrayList<Integer>()).add(connection[0]);
        // }

        // int numberOfConnectedComponents = 0;
        // boolean[] visit = new boolean[n];
        // for (int i = 0; i < n; i++) {
        //     if(!visit[i]){
        //         numberOfConnectedComponents++;
        //         dfs(i,adj,visit);
        //     }
        // }
        UnionFind dsu = new UnionFind(n);
        int numberOfConnectedComponents = n;

        for(int[] connection : connections){
            if(dsu.find(connection[0]) != dsu.find(connection[1])){
                numberOfConnectedComponents--;
                dsu.union_set(connection[0], connection[1]);
            }
        }

        return numberOfConnectedComponents - 1;
    }

    private void dfs(int node, Map<Integer,List<Integer>> adj,boolean[] visit){
        visit[node] = true;
        if(!adj.containsKey(node)) return;

        for(int neighbor : adj.get(node)){
            if(!visit[neighbor]){
                visit[neighbor] = true;
                dfs((neighbor), adj, visit);
            }
        }
    }
}

class UnionFind{
    int[] parent;
    int[] rank;

    public UnionFind(int size){
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int i){
        if(parent[i]!=i)
            parent[i] = find(parent[i]);
        return parent[i];
    }

    public void union_set(int x,int y){
        int xset = find(x);
        int yset = find(y);

        if(xset == yset) return ;
        else if(xset > yset) parent[yset] = xset;
        else if(xset < yset) parent[xset] = yset;
        else{
            parent[yset] = xset;
            rank[xset]++;
        }
    }
}