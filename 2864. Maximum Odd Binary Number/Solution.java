class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        
        for(char c : s.toCharArray()){
            if(c == '1') ones++;
        }

        StringBuilder ans = new StringBuilder();

        for(int i=0;i<ones-1;i++){
            ans.append('1');
        }

        for(int i=0;i<s.length()-ones;i++){
            ans.append('0');
        }

        return ans.append('1').toString();

    }
}