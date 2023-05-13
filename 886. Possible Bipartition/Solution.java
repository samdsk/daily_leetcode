import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean possibleBipartition(int n, int[][] edges) {

        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int[] edge : edges){
            int a = edge[0], b = edge[1];

            adj.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        UnionFind dsu = new UnionFind(n+1);

        for(int i=1;i<=n;i++){
            if(!adj.containsKey(i)) continue;
            for(int node : adj.get(i)){
                if(dsu.find(i) == dsu.find(node)) return false;
                 dsu.union(adj.get(i).get(0), node);
            }
        }

        return true;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++)
                parent[i] = i;
            rank = new int[size];
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int xset = find(x), yset = find(y);
            if (xset == yset) {
                return;
            } else if (rank[xset] < rank[yset]) {
                parent[xset] = yset;
            } else if (rank[xset] > rank[yset]) {
                parent[yset] = xset;
            } else {
                parent[yset] = xset;
                rank[xset]++;
            }
        }
    }
}