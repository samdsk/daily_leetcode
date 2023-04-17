import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];

        for (int i = 1; i < candies.length; i++) {
            max = Math.max(candies[i], max);
        }

        List<Boolean> ans = new ArrayList<>();

        max -= extraCandies;
        for(int candie : candies){
            ans.add(candie >= max);
        }

        return ans;
    }


}