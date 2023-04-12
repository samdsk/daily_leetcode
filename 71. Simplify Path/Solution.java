import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        String[] arr = path.split("/");

        for(int i=0;i<arr.length;i++){
            if(!stack.isEmpty() && arr[i].equals("..")) stack.pop();
            else if(!arr[i].equals("") && !arr[i].equals(".") && !arr[i].equals(".."))
                stack.push(arr[i]);
        }

        if(stack.isEmpty()) return "/";

        while(!stack.isEmpty()){
            ans.insert(0,"/").insert(1, stack.pop());
        }

        return ans.toString();
    }
}