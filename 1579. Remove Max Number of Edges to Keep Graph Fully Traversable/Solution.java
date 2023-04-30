import java.util.Arrays;

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges,(a,b)-> b[0]-a[0]);

        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int edgeCount = 0;

        for (int[] e : edges) {
            int type = e[0];
            int x = e[1];
            int y = e[2];

            switch(type){
                case 3:
                    if(alice.join(x, y) | bob.join(x, y)) edgeCount++;
                    break;
                case 2:
                    if(bob.join(x, y)) edgeCount++;
                    break;
                case 1:
                    if(alice.join(x, y)) edgeCount++;
                    break;
            }
        }

        if(alice.isDistinct() && bob.isDistinct())
            return edges.length - edgeCount;
        else return -1;

    }
}

class UnionFind{
    private int[] parent;
    private int distinctComponents;

    public UnionFind(int n){
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        distinctComponents = n;
    }

    public int find(int n){
        if(parent[n] != n)
            parent[n] = find(parent[n]);
        return parent[n];
    }

    public boolean join(int x, int y){
        if(find(x) != find(y)){
            parent[find(x)] = y;
            distinctComponents--;
            return true;
        }
        return false;
    }

    public boolean isDistinct(){
        return distinctComponents == 1;
    }

}