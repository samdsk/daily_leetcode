import java.util.HashMap;
import java.util.Map;

class Solution {
    int anwser = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visit[i]){
                Map<Integer,Integer> dis = new HashMap<>();
                dis.put(i,1);
                dfs(i, edges, dis, visit);
            }
        }

        return anwser;
    }
    private void dfs(int node,int[] edges,Map<Integer,Integer> dis, boolean[] visit){
        visit[node] = true;

        int n = edges[node];

        if(n != -1 && !visit[n]){
            dis.put(n,dis.get(node)+1);
            dfs(n, edges, dis, visit);
        }else if(n != -1 && dis.containsKey(n)){
            anwser = Math.max(anwser, dis.get(node)-dis.get(n)+1);
        }
    }


}