import java.util.Stack;

class Solution {
    public String removeStars(String s) {
        // Stack<Character> stack = new Stack<>();

        // for(char c : s.toCharArray()){
        //     if(c == '*' && !stack.isEmpty())
        //         stack.pop();
        //     else
        //         stack.push(c);
        // }
        // StringBuilder ans = new StringBuilder();
        // while(!stack.isEmpty()){
        //     ans.append(stack.pop());
        // }

        // return ans.reverse().toString();
        int n = s.length();
        char[] arr = new char[n];
        int index = n, count = 0;
        for (int i = index-1; i >=0; i--) {
            char c = s.charAt(i);
            if(c == '*')
                count++;
            else{
                if(count>0){
                    count--;
                }else{
                    arr[--index] = c;
                }
            }

        }

        return String.valueOf(arr,index,n-index);
    }
    public static void main(String[] args) {
        System.out.println(new Solution().removeStars("leet**cod*e"));
        System.out.println(new Solution().removeStars("erase*****"));
    }
}
