class Solution {
    public int numSteps(String s) {
        int count = 0;
        int overflow = 0;
        
        for(int i=s.length()-1;i>0;i--){  
            int number = (s.charAt(i) + overflow) % 2;

            if(number != 0){
                count++;
                overflow = 1;
            }

            count++;
        }

        
        return count + overflow;
    }
}