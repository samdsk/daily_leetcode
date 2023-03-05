import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.Adler32;

class Solution {
    
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n<2) return 0;

        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);            
        }

        HashSet<Integer> curs = new HashSet<>();
        curs.add(0);

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        visited.add(n-1);

        int steps = 0;

        HashSet<Integer> other = new HashSet<>();
        other.add(n-1);

        while(!curs.isEmpty()){
            if(curs.size()> other.size()){
                HashSet<Integer> temp = curs;
                curs = other;
                other = temp;
            }

            HashSet<Integer> next = new HashSet<>();

            for(int node : curs){

                for(int child : graph.get(arr[node])){
                    if(other.contains(child)) return steps +1;

                    if(!visited.contains(child)){
                        visited.add(child);
                        next.add(child);
                    }
                }

                graph.get(arr[node]).clear();

                if(other.contains(node + 1) || other.contains(node - 1)){
                    return steps + 1;
                }

                if(node+1 < n && !visited.contains(node+1)){
                    visited.add(node + 1);
                    next.add(node + 1);
                }
                if(node+-1 >= 0 && !visited.contains(node-1)){
                    visited.add(node - 1);
                    next.add(node - 1);
                }

            }
            curs = next;
            steps++;
        }

        return -1;

    }


    public static void main(String[] args) {

        System.out.println(new Solution().minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404}));
        System.out.println(new Solution().minJumps(new int[]{7}));
        System.out.println(new Solution().minJumps(new int[]{7,6,9,6,9,6,9,7}));
        System.out.println(new Solution().minJumps(new int[]{7,7,2,1,7,7,7,3,4,1}));
    }
}