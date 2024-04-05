class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        char[] letters = s.toCharArray();
        stack.push(letters[0]);

        for(int i=1;i<n;i++){
            if(!stack.isEmpty() && stack.peek() != letters[i] && Character.toLowerCase(letters[i]) == Character.toLowerCase(stack.peek())){
                stack.pop();
            }else{
                stack.push(letters[i]);
            }   

        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty())
            ans.append(stack.pop());

        return ans.reverse().toString();
    }
}