import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] visited = new boolean[n];

        for(List<Integer> edge : edges){
            visited[edge.get(1)] = true;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(!visited[i]) ans.add(i);
        }

        return ans;
    }

}