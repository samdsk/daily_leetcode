import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0, max = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0)+1);

            while(map.size()>2){
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0) map.remove(fruits[left]);
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().totalFruit(new int[]{1,2,1}));
        System.out.println(new Solution().totalFruit(new int[]{0,1,2,2}));
        //System.out.println(new Solution().totalFruit(new int[]{1,2,3,2,2}));
    }
}