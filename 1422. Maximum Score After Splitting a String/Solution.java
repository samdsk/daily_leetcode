class Solution {
    public int maxScore(String s) {
        int ones = 0;
        for(char c : s.toCharArray()){
            if(c == '1')
                ones++;
        } 

        int zeros = 0;
        int max = 0;
        
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == '1')
                ones--;
            else
                zeros++;

            max = Math.max(max, zeros+ones);
        }

        return max;
    }
}