import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int len = s.length();
        int right = p.length();
        
        List<Integer> output = new LinkedList<>();
        if(len<right) return output;
        
        Map<Character,Integer> pMap = new HashMap<>();
        Map<Character,Integer> sMap = new HashMap<>();
        
        for(int i = 0;i<p.length();i++){
            char cp = p.charAt(i);
            char cs = s.charAt(i);
            pMap.put(cp,pMap.getOrDefault(cp, 0)+1);
            sMap.put(cs,sMap.getOrDefault(cs, 0)+1);
        }
        
        if(pMap.equals(sMap)) output.add(0);
        
        int left = 0;
        while(right<len){
            char next = s.charAt(right++);
            sMap.put(next, sMap.getOrDefault(next, 0)+1);

            char remove = s.charAt(left++);
            sMap.put(remove, sMap.get(remove)-1);

            if(sMap.get(remove)<1)
                sMap.remove(remove);

            if(sMap.equals(pMap)) output.add(left);
        }

        return output;
    }




    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("aa", "bb"));
        System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
    }
}