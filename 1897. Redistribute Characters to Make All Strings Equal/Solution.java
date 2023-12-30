class Solution {
    public boolean makeEqual(String[] words) {
        int[] chars = new int[26];

        for(String w : words){
            for(char c : w.toCharArray()){
                chars[c - 'a']++;
            }
        }

        int n = words.length;

        for(int i=0;i<26;i++){
            if(chars[i] % n != 0)
                return false;
        }

        return true;
    }
}