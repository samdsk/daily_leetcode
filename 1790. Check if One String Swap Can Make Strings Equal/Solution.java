import java.util.List;
import java.util.ArrayList;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> list = new ArrayList<>();

        if(s1.equals(s2)) return true;

        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) list.add(i);

            if(list.size()>2) return false;
        }

        if(list.size() == 1) return false;

        if(list.size() == 2){
            int a = list.get(0);
            int b = list.get(1);

            return s1.charAt(a) == s2.charAt(b) && s1.charAt(b) == s2.charAt(a);
        }

        return false;
    }
}