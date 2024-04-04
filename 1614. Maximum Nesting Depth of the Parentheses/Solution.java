class Solution {
    public int maxDepth(String s) {
        if(s.length()<1 
        || (s.length() == 1 
        && (s.charAt(0) != '(' 
        || s.charAt(0) != ')'))) return 0;

        int max = 0;
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                count++;
            }else if(c == ')')
                count--;

            max = Math.max(max, count);
        }

        return max;
    }
}