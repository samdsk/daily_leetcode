import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int LIMIT = nums.length/3;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums)
            map.put(n, map.getOrDefault(n, 0)+1);

        for(Entry<Integer, Integer> n : map.entrySet()){
            if(n.getValue()>LIMIT) ans.add(n.getKey());
        }

        return ans;
    }
}