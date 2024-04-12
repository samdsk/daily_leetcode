class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for(char c : num.toCharArray()){
            while(k > 0 && !stack.isEmpty() && stack.peek() > c){
                k--;
                stack.pop();
            }
            stack.push(c);
        }

        while(k>0 && !stack.isEmpty()){
            k--;
            stack.pop();
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }

        for(int i=ans.length()-1;i>=0;i--){
            if(ans.charAt(i) != '0') break;
            else ans.deleteCharAt(i);
        }       

        if(ans.length() == 0) return "0";

        return ans.reverse().toString();
    }
}