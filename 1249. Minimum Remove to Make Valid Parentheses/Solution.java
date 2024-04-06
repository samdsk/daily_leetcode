class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        int n = s.length();

        for(int i=0; i<n; i++){
            if(arr[i] == '(')
                count++;
            else if (arr[i] == ')'){
                if(count > 0) count--;
                else arr[i] = ' ';
            }
        }
        count = 0;
        for(int i=n-1; i>=0; i--){
            if(arr[i] == ')')
                count++;
            else if (arr[i] == '('){
                if(count > 0) count--;
                else arr[i] = ' ';
            }
        }
        StringBuilder ans = new StringBuilder();

        for(char c : arr){
            if(c != ' ') ans.append(c);
        }

        return ans.toString();
    }   
}