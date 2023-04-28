class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind dsu = new UnionFind(n);
        int count = n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(isSimilar(strs[i], strs[j]) && dsu.find(i) != dsu.find(j)){
                    count--;
                    dsu.union_set(i, j);
                }
            }
        }

        return count;
    }

    private boolean isSimilar(String x, String y){
        int count = 0;
        for (int i = 0; i < x.length(); i++) {
            if(x.charAt(i)!= y.charAt(i)) count++;
        }

        return count == 0 || count == 2;
    }
}

class UnionFind{
    int[] parent;
    int[] rank;

    public UnionFind(int size){
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }

        rank = new int[size];
    }

    public int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union_set(int x, int y){
        int xset = find(x);
        int yset = find(y);

        if(xset == yset) return;
        else if(xset < yset) rank[xset] = yset;
        else if(xset > yset) rank[yset] = xset;
        else {
            rank[yset] = xset;
            rank[xset]++;
        }

    }
}