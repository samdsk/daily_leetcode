import java.util.HashSet;
import java.util.Set;

class Solution {
    int[] costs;
    Integer[] memo;
    Set<Integer> dayset;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        dayset = new HashSet<>();

        for(int d: days) dayset.add(d);
        return dp(1);
    }

    private int dp(int i){
        if(i>365) return 0;
        if(memo[i] != null) return memo[i];

        int ans;
        if(dayset.contains(i)){
            ans = Math.min(dp(i+1)+costs[0],dp(i+7)+costs[1]);
            ans = Math.min(ans,dp(i+30)+costs[2]);
        }else{
            ans = dp(i+1);
        }
        memo[i] = ans;
        return ans;
    }
}