import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1n = s1.length();
        int s2n = s2.length();

        if(s1n > s2n) return false;

        int[] s1map = new int[26];
        int[] s2map = new int[26];

        for (int i = 0; i < s1n; i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2n - s1n; i++) {
            if(Arrays.equals(s1map,s2map)) return true;

            s2map[s2.charAt(i + s1n) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }

        return Arrays.equals(s1map,s2map);
    }
}

        // Map<Character,Integer> s1_map = new HashMap<>();

        // for(char c : s1.toCharArray()){
        //     s1_map.put(c,s1_map.getOrDefault(c, 0)+1);
        // }

        // for (int i = 0; i < s2.length(); i++) {
        //     Map<Character,Integer> temp = new HashMap<>();

        //     for (int j = 0; j < s1.length() && i+j < s2.length(); j++) {
        //         char c = s2.charAt(i+j);
        //         temp.put(c, temp.getOrDefault(c, 0)+1);
        //     }

        //     if(s1_map.equals(temp)) return true;
        // }

        // return false;
