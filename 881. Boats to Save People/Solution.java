import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length-1, ans = 0;

        while (i<=j) {
            ans++;
            if(people[i]+people[j]<=limit) i++;
            j--;
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().numRescueBoats(new int[]{3,2,2,1}, 3));
        System.out.println(new Solution().numRescueBoats(new int[]{2,2}, 6));
    }
}