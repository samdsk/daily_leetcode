import java.util.HashSet;
import java.util.Set;

class Solution {
    // int[] costs;
    // Integer[] memo;
    // Set<Integer> dayset;

    // public int mincostTickets(int[] days, int[] costs) {
    //     this.costs = costs;
    //     memo = new Integer[366];
    //     dayset = new HashSet<>();

    //     for(int d: days) dayset.add(d);
    //     return dp(1);
    // }

    // private int dp(int i){
    //     if(i>365) return 0;
    //     if(memo[i] != null) return memo[i];

    //     int ans;
    //     if(dayset.contains(i)){
    //         ans = Math.min(dp(i+1)+costs[0],dp(i+7)+costs[1]);
    //         ans = Math.min(ans,dp(i+30)+costs[2]);
    //     }else{
    //         ans = dp(i+1);
    //     }
    //     memo[i] = ans;
    //     return ans;
    // }

    int[] days,costs;
    Integer[] memo;
    int[] durations = new int[]{1,7,30};

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[days.length];

        return dp(0);
    }

    private int dp(int i){
        if(i>=days.length) return 0;
        if (memo[i] != null) return memo[i];

        int ans = Integer.MAX_VALUE;
        int j = i;
        for (int k = 0; k < 3; ++k) {
            while(j<days.length && days[j]<days[i]+durations[k]){
                j++;
            }
            ans = Math.min(ans,dp(j)+costs[k]);
        }

        memo[i] = ans;
        return ans;
    }

}