import java.util.Stack;

class Solution {
    private int index = 0;
    public String decodeString(String s) {
        StringBuilder output = new StringBuilder();
        int count = 0;
        String temp;

        while(index<s.length()){
            char c = s.charAt(index);
            index++;
            if(c == '['){
                temp = decodeString(s);
                // for(int i = 0;i<count;i++){
                //     output.append(temp);
                // }
                output.append(temp.repeat(count));
                count = 0;
            }

            else if(c == ']'){
                break;
            }

            else if(Character.isAlphabetic(c)){
                output.append(c);
            }else{
                count = count * 10 + c - '0';
            }
        } 
        
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
        System.out.println(new Solution().decodeString("3[a2[c]]"));
    }
}