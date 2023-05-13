class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        UnionFind dsu = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if(dsu.isConnected(i, graph[i][j])) return false;
                dsu.union(graph[i][0], graph[i][j]);
            }
        }

        return true;
    }

    private class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
          parent = new int[n];
          rank = new int[n];

          for (int i = 0; i < n; i++) {
            parent[i] = i;
          }
        }

        public int find(int x) {
          if(parent[x] == x) return x;

          int root = find(parent[x]);
          parent[x] = root; // path compression
          return root;
        }

        public void union(int x, int y) {
          int xset = find(x);
          int yset = find(y);

          if (xset == yset) return;

          if (rank[xset] > rank[yset]) {
            parent[yset] = xset;
            rank[xset]++;
          } else {
            parent[xset] = yset;
            rank[yset]++;
          }
        }

        public boolean isConnected(int x, int y) {
          return find(x) == find(y);
        }
      }

}