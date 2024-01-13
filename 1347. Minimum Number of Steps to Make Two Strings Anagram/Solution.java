class Solution {
    public int minSteps(String s, String t) {
        int[] str = new int[26];

        for(char c : s.toCharArray())
            str[c - 'a']++;

        for(char c : t.toCharArray())
            str[c - 'a']--;

        int count = 0;
        for(int i=0;i<26;i++){            
            count += Math.max(0,str[i]);
        }

        return count;
    }
}