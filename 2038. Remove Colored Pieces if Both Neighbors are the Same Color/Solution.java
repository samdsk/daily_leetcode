class Solution {
    public boolean winnerOfGame(String colors) {
        int A = 0, B = 0;

        for(int i=1;i<colors.length()-1;i++){
            
            char prev = colors.charAt(i-1);
            char cur = colors.charAt(i);
            char next = colors.charAt(i+1);

            if(prev == cur && cur == next){
                if(cur == 'A') A++;
                else B++;
            }
        }

        return A - B >= 1;
    }
}