class Solution {
    public boolean isSubsequence(String s, String t) {
        int index_s = 0;
        int index_t = 0;

        int size_s = s.length();
        
        while(index_s < size_s && index_t < t.length()){
            if(s.charAt(index_s) == t.charAt(index_t))
                index_s++;

            index_t++;
        }

        return index_s == size_s;
    }
}