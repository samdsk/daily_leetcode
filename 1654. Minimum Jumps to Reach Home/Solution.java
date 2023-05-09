import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int limit = 2000 + 2 * b + 1;

        boolean[] visited = new boolean[limit];

        for(int n : forbidden) visited[n] = true;

        int steps = 0;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0,-1});

        visited[0] = true;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0;i<size;i++){
                int[] state = queue.poll();
                int pos = state[0];
                int direction = state[1];

                if(pos == x) return steps;

                int back = pos - b;

                if(direction<0 && back>0 && !visited[back]){
                    queue.offer(new int[]{back,1});
                    visited[back] = true;
                }

                int forward = pos + a;

                if(forward < limit && !visited[forward]){
                    queue.offer(new int[]{forward, -1});
                    visited[forward] = true;
                }
            }

            steps++;
        }

        return -1;
    }
}