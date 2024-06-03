class Solution {
    public int appendCharacters(String s, String t) {
        int index = 0;
        int target = 0;
        
        while(index < t.length() && target < s.length()){

            if(t.charAt(index) == s.charAt(target)){
                index++;
            }

            target++;
        }

        return t.length() - index;

    }
}