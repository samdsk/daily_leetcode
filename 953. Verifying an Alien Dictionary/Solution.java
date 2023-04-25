class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];

        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            int j = 0;


            while(j<words[i-1].length()){
                if(j >= words[i].length()) return false;
                if(words[i-1].charAt(j) != words[i].charAt(j)){
                    int k = words[i-1].charAt(j) - 'a';
                    int l = words[i].charAt(j) - 'a';
                    if(map[k] > map[l]) return false;
                    else break;
                }
                j++;
            }

        }

        return true;
    }
}