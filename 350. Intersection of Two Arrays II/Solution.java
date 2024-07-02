import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] short_arr = null;
        int[] long_arr = null;

        if (nums1.length < nums2.length) {
            short_arr = nums1;
            long_arr = nums2;
        } else {
            short_arr = nums2;
            long_arr = nums1;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : short_arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();

        for (int n : long_arr) {
            if (map.containsKey(n) && map.get(n) > 0) {
                ans.add(n);
                map.put(n, map.get(n) - 1);
            }
        }

        // return ans.stream().mapToInt(i->i).toArray();

        int[] res = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;

    }
}