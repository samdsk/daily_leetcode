import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        UnionFind dsu = new UnionFind(n);
        int qs = queries.length;

        boolean[] ans = new boolean[qs];

        int[][] q = new int[qs][4];

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < 3; j++) {
                q[i][j] = queries[i][j];
            }
            q[i][3] = i;
        }

        Comparator<int[]> by_weight = new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return x[2] - y[2];
            }
        };

        Arrays.sort(edgeList,by_weight);
        Arrays.sort(q,by_weight);

        int e_i = 0;

        for (int i = 0; i < q.length; i++) {

            while(e_i < edgeList.length && edgeList[e_i][2] < q[i][2]){
                dsu.join(edgeList[e_i][0],edgeList[e_i][1]);
                e_i++;
            }

            ans[q[i][3]] = dsu.connected(q[i][0], q[i][1]);
        }

        return ans;
    }
}

class UnionFind{
    private int[] parent;
    private int[] rank;

    public UnionFind(int n){
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        rank = new int[n];
    }

    public int find(int n){
        if(parent[n] != n)
            parent[n] = find(parent[n]);
        return parent[n];
    }

    public void join(int x, int y){
        int xset = find(x);
        int yset = find(y);

        if(parent[x] == parent[y]) return;
        else if(rank[x] < rank[y]) parent[xset] = yset;
        else if(rank[x] > rank[y]) parent[yset] = xset;
        else{
            parent[xset] = yset;
            rank[xset]++;
        }
    }

    public boolean connected(int x,int y){
        return find(x) == find(y);
    }

}
