import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int m = graph.length;

        if(m == 1) return 0;

        int bits = (1 << m) -1;

        int[][] visited = new int[m][bits+1];

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0;i<m;i++){
            queue.offer((new int[]{i,1<<i}));
        }

        int ans = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) {

                int[] state = queue.poll();
                int thisNode = state[0];
                int visitedBit = state[1];

                for(int node : graph[thisNode]){
                    int newVisistedBit = visitedBit | (1<<node);
                    if(visited[node][newVisistedBit] == 1) continue;

                    visited[node][newVisistedBit] = 1;
                    if(newVisistedBit == bits) return ans;

                    queue.offer(new int[]{node,newVisistedBit});
                }
            }
        }
        return -1;
    }
}