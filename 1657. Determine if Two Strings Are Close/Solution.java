class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        int[] str1 = new int[26];
        int[] str2 = new int[26];

        for(char c : word1.toCharArray())
            str1[c - 'a']++;

        for(char c : word2.toCharArray())
            str2[c - 'a']++;

        for(int i=0;i<26;i++)
            if(str1[i] == 0 && str2[i] != 0 || str1[i] != 0 && str2[i] == 0)
                return false;

        Arrays.sort(str1);
        Arrays.sort(str2);

        for(int i=0;i<26;i++){
            if(str1[i] != str2[i]) return false;
        }

        return true;
    }
}