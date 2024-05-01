class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder rev = new StringBuilder();
        StringBuilder rest = new StringBuilder();
        boolean flag = false;

        for(int i=0;i<word.length();i++){            
            if(flag){
                rest.append(word.charAt(i));
            }else{
                rev.append(word.charAt(i));
            }

            if(word.charAt(i) == ch){
                flag = true;
            }
        }

        if(!flag)
            return word;            
            
        return rev.reverse().append(rest).toString();
    }
}