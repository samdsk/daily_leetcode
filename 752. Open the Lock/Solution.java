import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> visited = new HashSet<>();

        for(String d : deadends) visited.add(Integer.parseInt(d));

        int target_int = Integer.parseInt(target);

        if(visited.contains(0)) return -1;

        int turns = 1;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                int current = queue.poll();

                for(int j=1;j<10000;j*=10){

                    int mask = current % (j * 10) / j;
                    int masked = current - (mask * j);

                    for (int k = 1; k < 10; k +=8) {
                        int next = masked + (mask+k) % 10 *j;

                        if(!visited.add(next)) continue;

                        if(next==target_int) return turns;
                        queue.add(next);
                    }
                }
            }
            turns++;
        }

        return -1;

    }
}