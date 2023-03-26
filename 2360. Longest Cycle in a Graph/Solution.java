import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    // int anwser = -1;
    // public int longestCycle(int[] edges) {
    //     int n = edges.length;
    //     boolean[] visit = new boolean[n];

    //     for (int i = 0; i < n; i++) {
    //         if(!visit[i]){
    //             Map<Integer,Integer> dis = new HashMap<>();
    //             dis.put(i,1);
    //             dfs(i, edges, dis, visit);
    //         }
    //     }

    //     return anwser;
    // }
    // private void dfs(int node,int[] edges,Map<Integer,Integer> dis, boolean[] visit){
    //     visit[node] = true;

    //     int n = edges[node];

    //     if(n != -1 && !visit[n]){
    //         dis.put(n,dis.get(node)+1);
    //         dfs(n, edges, dis, visit);
    //     }else if(n != -1 && dis.containsKey(n)){
    //         anwser = Math.max(anwser, dis.get(node)-dis.get(n)+1);
    //     }
    // }

    // Kahn's Algorithm

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visit = new boolean[n];

        // Kahn's Algorithm starts
        int[] indegree = new int[n];

        for( int i: edges){
            if(i != -1)
                indegree[i]++;

        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            visit[node] = true;
            int nei = edges[node];
            if(nei != -1){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.offer(nei);
                }
            }
        }
        // Kahn's Algorithm ends

        int anwser = -1;
        for (int i = 0; i < n; i++) {
            if(!visit[i]){
                int nei = edges[i];
                int count = 1;
                visit[i] = true;

                while(nei != i){
                    visit[nei] = true;
                    count++;
                    nei = edges[nei];
                }
                anwser = Math.max(anwser,count);
            }
        }

        return anwser;
    }


}