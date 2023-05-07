import java.util.List;
import java.util.ArrayList;

class Solution {
    int max = Integer.MIN_VALUE;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adjs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjs.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if(manager[i] != -1) adjs.get(manager[i]).add(i);
        }

        dfs(adjs, informTime, headID,0);

        return max;
    }

    private void dfs(List<List<Integer>> adjs, int[] informTime, int current_node, int time){
        max = Math.max(max, time);

        for(int node : adjs.get(current_node)){
            dfs(adjs, informTime, node, time + informTime[current_node]);
        }
    }
}